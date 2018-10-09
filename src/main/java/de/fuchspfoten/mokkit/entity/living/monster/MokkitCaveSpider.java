package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.CaveSpider
 */
public class MokkitCaveSpider extends MokkitSpider implements CaveSpider {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitCaveSpider(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "CaveSpider", location, uuid, 12.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.CAVE_SPIDER;
    }
}
