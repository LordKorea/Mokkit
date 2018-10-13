package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Rabbit
 */
public class MokkitRabbit extends MokkitAnimals implements Rabbit {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitRabbit(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Rabbit", location, uuid, 3.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.RABBIT;
    }

    @Override
    public Type getRabbitType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRabbitType(final Type type) {
        // TODO
        throw new UnsupportedMockException();
    }
}