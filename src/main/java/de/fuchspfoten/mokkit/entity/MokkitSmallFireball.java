package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.SmallFireball;

import java.util.UUID;

/**
 * @see org.bukkit.entity.SmallFireball
 */
public class MokkitSmallFireball extends MokkitFireball implements SmallFireball {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitSmallFireball(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "SmallFireball", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.SMALL_FIREBALL;
    }
}
