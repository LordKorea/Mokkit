package de.fuchspfoten.mokkit.entity.projectile.fireball;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LargeFireball;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * @see org.bukkit.entity.LargeFireball
 */
public class MokkitLargeFireball extends MokkitFireball implements LargeFireball {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitLargeFireball(final @NonNull MokkitServer server, final @NonNull Location location,
                               final @NonNull UUID uniqueId) {
        super(server, "LargeFireball", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.FIREBALL;
    }

    @Override
    public double onDamaged(final @NonNull Entity damager, final double damage) {
        final double dmg = super.onDamaged(damager, damage);

        // Deflect the fireball.
        final Vector newVelo = getLocation().toVector().subtract(damager.getLocation().toVector());
        setVelocity(newVelo.normalize().multiply(getVelocity().length()));
        return dmg;
    }
}
