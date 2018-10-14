package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Skeleton
 */
public class MokkitSkeleton extends MokkitMonster implements Skeleton {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSkeleton(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Skeleton", location, uuid, 20.0);
    }

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitSkeleton(final MokkitServer server, final String name, final Location location, final UUID uuid,
                             final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public SkeletonType getSkeletonType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSkeletonType(final SkeletonType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.SKELETON;
    }
}
