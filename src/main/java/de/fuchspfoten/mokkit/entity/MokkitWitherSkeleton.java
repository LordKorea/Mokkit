package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;

import java.util.UUID;

/**
 * @see org.bukkit.entity.WitherSkeleton
 */
public class MokkitWitherSkeleton extends MokkitSkeleton implements WitherSkeleton {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitWitherSkeleton(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "WitherSkeleton", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.WITHER_SKELETON;
    }
}
