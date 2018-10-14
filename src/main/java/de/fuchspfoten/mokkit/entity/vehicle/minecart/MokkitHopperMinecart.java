package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

/**
 * @see org.bukkit.entity.minecart.HopperMinecart
 */
public class MokkitHopperMinecart extends MokkitMinecart implements HopperMinecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitHopperMinecart(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "HopperMinecart", location, uuid);
    }

    @Override
    public Inventory getInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART_HOPPER;
    }

    @Override
    public boolean isEnabled() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setEnabled(final boolean enabled) {
        // TODO
        throw new UnsupportedMockException();
    }
}
