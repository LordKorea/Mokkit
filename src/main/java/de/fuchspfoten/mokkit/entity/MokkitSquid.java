package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Squid
 */
public class MokkitSquid extends MokkitWaterMob implements Squid {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSquid(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Squid", location, uuid, 10.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.SQUID;
    }
}
