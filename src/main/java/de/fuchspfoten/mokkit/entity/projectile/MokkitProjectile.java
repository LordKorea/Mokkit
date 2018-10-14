package de.fuchspfoten.mokkit.entity.projectile;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Projectile
 */
public abstract class MokkitProjectile extends MokkitEntity implements Projectile {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitProjectile(final MokkitServer server, final String name, final Location location,
                            final UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public ProjectileSource getShooter() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShooter(final ProjectileSource source) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean doesBounce() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBounce(final boolean doesBounce) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Getter for the control object.
     *
     * @return The control object.
     */
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    public class Mokkit {

        /**
         * Lets the projectile hit a target.
         *
         * @param target The target.
         */
        public void hitTarget(final Entity target) {
            final ProjectileHitEvent hitEvent = new ProjectileHitEvent(MokkitProjectile.this, target);
            getServer().getPluginManager().callEvent(hitEvent);
        }
    }
}
