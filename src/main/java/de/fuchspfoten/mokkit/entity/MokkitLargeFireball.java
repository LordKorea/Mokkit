package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LargeFireball;

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
    public MokkitLargeFireball(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "LargeFireball", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.FIREBALL;
    }
}
