package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Ageable;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Ageable
 */
public class MokkitAgeable extends MokkitCreature implements Ageable {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitAgeable(final MokkitServer server, final String name, final Location location, final UUID uuid,
                         final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public int getAge() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAge(final int age) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAgeLock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAgeLock(final boolean lock) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBaby() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAdult() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isAdult() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean canBreed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBreed(final boolean breed) {
        // TODO
        throw new UnsupportedMockException();
    }
}
