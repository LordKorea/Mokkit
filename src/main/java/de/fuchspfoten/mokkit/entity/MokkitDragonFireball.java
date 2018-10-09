package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.DragonFireball
 */
public class MokkitDragonFireball extends MokkitFireball implements DragonFireball {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitDragonFireball(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "DragonFireball", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.DRAGON_FIREBALL;
    }
}
