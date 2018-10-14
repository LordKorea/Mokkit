package de.fuchspfoten.mokkit.entity.vehicle;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Vehicle
 */
public abstract class MokkitVehicle extends MokkitEntity implements Vehicle {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitVehicle(final MokkitServer server, final String name, final Location location, final UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public double onDamaged(final Entity damager, final double damage) {
        final VehicleDamageEvent damageEvent = new VehicleDamageEvent(this, damager, damage);
        getServer().getPluginManager().callEvent(damageEvent);
        if (damageEvent.isCancelled()) {
            throw new CancelledByEventException(damageEvent);
        }

        // Get the final damage.
        final double finalDamage = damageEvent.getDamage();
        if (finalDamage >= 2.0) {
            // TODO actual damage? how does it work?
            // Here we assume 2.0 damage points kill the vehicle.
            final VehicleDestroyEvent destroyEvent = new VehicleDestroyEvent(this, damager);
            getServer().getPluginManager().callEvent(destroyEvent);
            if (destroyEvent.isCancelled()) {
                throw new CancelledByEventException(destroyEvent);
            }

            // TODO drops?
            remove();
        }

        return finalDamage;
    }
}
