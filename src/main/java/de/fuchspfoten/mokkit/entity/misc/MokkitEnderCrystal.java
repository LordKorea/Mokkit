package de.fuchspfoten.mokkit.entity.misc;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @see org.bukkit.entity.EnderCrystal
 */
public class MokkitEnderCrystal extends MokkitEntity implements EnderCrystal {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitEnderCrystal(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "EnderCrystal", location, uniqueId);
    }

    @Override
    public Location getBeamTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBeamTarget(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDER_CRYSTAL;
    }

    @Override
    public boolean isShowingBottom() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShowingBottom(final boolean showing) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double onDamaged(final Entity damager, final double damage) {
        final double dmg = super.onDamaged(damager, damage);

        // TODO: Explosion blocks and strength.
        final EntityExplodeEvent explosionEvent = new EntityExplodeEvent(this, getLocation(), new ArrayList<>(),
                0.0f);
        getServer().getPluginManager().callEvent(explosionEvent);
        if (explosionEvent.isCancelled()) {
            throw new CancelledByEventException(explosionEvent);
        }

        // Remove the target.
        remove();

        // Perform the explosion.
        // TODO perform the explosion.

        return dmg;
    }
}
