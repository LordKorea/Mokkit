package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.RideableMinecart;

import java.util.UUID;

/**
 * @see org.bukkit.entity.minecart.RideableMinecart
 */
public class MokkitRideableMinecart extends MokkitMinecart implements RideableMinecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitRideableMinecart(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "RideableMinecart", location, uuid);
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART;
    }
}
