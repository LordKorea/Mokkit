package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowman;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Snowman
 */
public class MokkitSnowman extends MokkitGolem implements Snowman {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSnowman(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Snowman", location, uuid, 4.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.SNOWMAN;
    }

    @Override
    public boolean isDerp() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDerp(final boolean derpMode) {
        // TODO
        throw new UnsupportedMockException();
    }
}
