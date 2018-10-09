package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Pig
 */
public class MokkitPig extends MokkitAnimals implements Pig {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitPig(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Pig", location, uuid, 10.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.PIG;
    }

    @Override
    public boolean hasSaddle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSaddle(final boolean saddled) {
        // TODO
        throw new UnsupportedMockException();
    }
}
