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

import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Arrays;

/**
 * @see org.bukkit.inventory.PlayerInventory
 */
public class MokkitPlayerInventory extends MokkitInventory implements PlayerInventory {

    /**
     * The slot of the item currently being held.
     */
    private @Getter
    @Setter
    int heldItemSlot = 0;

    /**
     * Constructor.
     */
    public MokkitPlayerInventory(final @NonNull InventoryHolder holder) {
        // Hotbar: 0..8.
        // Items: 9..35.
        // Armor: 36..39.
        // Off Hand: 40.
        super(9 + 3 * 9 + 4 + 1, holder, "Inventory", InventoryType.PLAYER);
    }

    @Override
    public ItemStack[] getArmorContents() {
        final ItemStack[] result = new ItemStack[4];
        Arrays.setAll(result, i -> contents[36 + i]);
        return result;
    }

    @Override
    public void setArmorContents(final @NonNull ItemStack[] items) {
        assert items.length == 4 : "invalid array length";
        System.arraycopy(items, 0, contents, 36, 4);
    }

    @Override
    public ItemStack[] getExtraContents() {
        return new ItemStack[]{contents[40]};
    }

    @Override
    public void setExtraContents(final @NonNull ItemStack[] items) {
        assert items.length == 1 : "invalid array length";
        contents[40] = items[0];
    }

    @Override
    public ItemStack getHelmet() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getChestplate() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setChestplate(final ItemStack chestplate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getLeggings() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getBoots() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBoots(final ItemStack boots) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getItemInMainHand() {
        return getItem(heldItemSlot);
    }

    @Override
    public void setItemInMainHand(final ItemStack item) {
        setItem(heldItemSlot, item);
    }

    @Override
    public ItemStack getItemInOffHand() {
        return getItem(40);
    }

    @Override
    public void setItemInOffHand(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getItemInHand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItemInHand(final ItemStack stack) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int clear(final int id, final int data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLeggings(final ItemStack leggings) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setHelmet(final ItemStack helmet) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public SlotType getSlotType(final int slot) {
        if (slot < 8) {
            return SlotType.QUICKBAR;
        }
        if (slot >= 36 && slot <= 39) {
            return SlotType.ARMOR;
        }
        return SlotType.CONTAINER;
    }

    @Override
    public HumanEntity getHolder() {
        // TODO
        throw new UnsupportedMockException();
    }
}
