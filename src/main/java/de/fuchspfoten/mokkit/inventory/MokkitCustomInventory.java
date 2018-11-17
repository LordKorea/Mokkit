package de.fuchspfoten.mokkit.inventory;

import lombok.NonNull;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;

/**
 * A custom inventory.
 */
public class MokkitCustomInventory extends MokkitInventory {

    /**
     * Constructor.
     *
     * @param size   The size of inventory.
     * @param holder The holder of the inventory.
     * @param title  The title of the inventory.
     */
    public MokkitCustomInventory(final int size, final InventoryHolder holder, final @NonNull String title) {
        super(size, holder, title, InventoryType.CHEST);
    }
}
