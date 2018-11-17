package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.PoweredMinecart;

import java.util.UUID;

/**
 * @see org.bukkit.entity.minecart.PoweredMinecart
 */
public class MokkitPoweredMinecart extends MokkitMinecart implements PoweredMinecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitPoweredMinecart(final @NonNull MokkitServer server, final @NonNull Location location,
                                 final @NonNull UUID uuid) {
        super(server, "PoweredMinecart", location, uuid);
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART_FURNACE;
    }
}
