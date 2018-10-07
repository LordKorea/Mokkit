package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Hanging
 */
public abstract class MokkitHanging extends MokkitEntity implements Hanging {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitHanging(final MokkitServer server, final String name, final Location location, final UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public boolean setFacingDirection(final BlockFace face, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockFace getAttachedFace() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFacingDirection(final BlockFace face) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockFace getFacing() {
        // TODO
        throw new UnsupportedMockException();
    }
}
