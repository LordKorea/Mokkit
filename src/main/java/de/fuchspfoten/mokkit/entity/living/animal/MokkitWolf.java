package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Wolf
 */
public class MokkitWolf extends MokkitTameableAnimals implements Wolf {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitWolf(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Wolf", location, uuid, 8.0);
    }

    @Override
    public void setTamed(final boolean tame) {
        super.setTamed(tame);
        if (isTamed()) {
            setMaxHealth(20.0);
        } else {
            setMaxHealth(8.0);
        }
    }

    @Override
    public EntityType getType() {
        return EntityType.WOLF;
    }

    @Override
    public boolean isAngry() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAngry(final boolean angry) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public DyeColor getCollarColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCollarColor(final DyeColor color) {
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
