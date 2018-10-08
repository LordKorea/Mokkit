package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Shulker;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Shulker
 */
public class MokkitShulker extends MokkitGolem implements Shulker {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitShulker(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Shulker", location, uuid, 30.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.SHULKER;
    }

    @Override
    public DyeColor getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final DyeColor color) {
        // TODO
        throw new UnsupportedMockException();
    }
}
