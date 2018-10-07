package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vindicator;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Vindicator
 */
public class MokkitVindicator extends MokkitIllager implements Vindicator {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitVindicator(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Vindicator", location, uuid, 24.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.VINDICATOR;
    }
}
