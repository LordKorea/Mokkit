package de.fuchspfoten.mokkit.inventory;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

/**
 * @see org.bukkit.inventory.InventoryView
 */
@RequiredArgsConstructor
public class MokkitInventoryView extends InventoryView {

    /**
     * The top inventory in the view.
     */
    private @NonNull @Getter final Inventory topInventory;

    /**
     * The bottom inventory in the view.
     */
    private @NonNull @Getter final Inventory bottomInventory;

    /**
     * The player viewing the view.
     */
    private @NonNull @Getter final HumanEntity player;

    /**
     * The type of the view.
     */
    private @NonNull @Getter final InventoryType type;
}
