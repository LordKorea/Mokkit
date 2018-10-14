package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Sheep
 */
public class MokkitSheep extends MokkitAnimals implements Sheep {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSheep(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Sheep", location, uuid, 8.0);
    }

    @Override
    public DyeColor getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final DyeColor color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.SHEEP;
    }

    @Override
    public boolean isSheared() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSheared(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }
}
