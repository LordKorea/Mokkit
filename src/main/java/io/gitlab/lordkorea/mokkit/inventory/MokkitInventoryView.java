/*
 * Copyright (c) 2018.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.gitlab.lordkorea.mokkit.inventory;

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
    private @NonNull
    @Getter final Inventory topInventory;

    /**
     * The bottom inventory in the view.
     */
    private @NonNull
    @Getter final Inventory bottomInventory;

    /**
     * The player viewing the view.
     */
    private @NonNull
    @Getter final HumanEntity player;

    /**
     * The type of the view.
     */
    private @NonNull
    @Getter final InventoryType type;
}
