package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Tameable;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Animals
 * @see org.bukkit.entity.Tameable
 */
public class MokkitTameableAnimals extends MokkitAnimals implements Tameable {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitTameableAnimals(final MokkitServer server, final String name, final Location location, final UUID uuid,
                                 final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public boolean isTamed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTamed(final boolean tame) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public AnimalTamer getOwner() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setOwner(final AnimalTamer tamer) {
        // TODO
        throw new UnsupportedMockException();
    }
}
