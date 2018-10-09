package de.fuchspfoten.mokkit.entity.hanging;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Art;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Painting
 */
public class MokkitPainting extends MokkitHanging implements Painting {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitPainting(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "Painting", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.PAINTING;
    }

    @Override
    public Art getArt() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setArt(final Art art) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setArt(final Art art, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }
}
