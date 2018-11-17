package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Ocelot
 */
public class MokkitOcelot extends MokkitTameableAnimals implements Ocelot {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitOcelot(final @NonNull MokkitServer server, final @NonNull Location location,
                        final @NonNull UUID uuid) {
        super(server, "Ocelot", location, uuid, 10.0);
    }

    @Override
    public Type getCatType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCatType(final Type type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.OCELOT;
    }

    @Override
    public boolean isSitting() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSitting(final boolean sitting) {
        // TODO
        throw new UnsupportedMockException();
    }
}
