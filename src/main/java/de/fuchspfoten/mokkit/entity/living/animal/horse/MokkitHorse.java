package de.fuchspfoten.mokkit.entity.living.animal.horse;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Horse
 */
public class MokkitHorse extends MokkitAbstractHorse implements Horse {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitHorse(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Horse", location, uuid, 15.0);
    }

    @Override
    public Color getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final Color color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HorseInventory getInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Style getStyle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStyle(final Style style) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.HORSE;
    }

    @Override
    public boolean isCarryingChest() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCarryingChest(final boolean chest) {
        // TODO
        throw new UnsupportedMockException();
    }
}
