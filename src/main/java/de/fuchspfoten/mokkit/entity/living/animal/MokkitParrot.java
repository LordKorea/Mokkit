package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Parrot
 */
public class MokkitParrot extends MokkitTameableAnimals implements Parrot {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitParrot(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Parrot", location, uuid, 6.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.PARROT;
    }

    @Override
    public Variant getVariant() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setVariant(final Variant variant) {
        // TODO
        throw new UnsupportedMockException();
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
