package de.fuchspfoten.mokkit.entity.hanging;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

/**
 * @see org.bukkit.entity.ItemFrame
 */
public class MokkitItemFrame extends MokkitHanging implements ItemFrame {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitItemFrame(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "ItemFrame", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.ITEM_FRAME;
    }

    @Override
    public ItemStack getItem() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItem(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Rotation getRotation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRotation(final Rotation rotation) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }
}
