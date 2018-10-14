package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.CommandMinecart;

import java.util.UUID;

/**
 * @see org.bukkit.entity.minecart.CommandMinecart
 */
public class MokkitCommandMinecart extends MokkitMinecart implements CommandMinecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitCommandMinecart(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "CommandMinecart", location, uuid);
    }

    @Override
    public String getCommand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCommand(final String command) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART_COMMAND;
    }

    @Override
    public void setName(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }
}
