package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Projectile
 */
public abstract class MokkitProjectile extends MokkitEntity implements Projectile {

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
}
