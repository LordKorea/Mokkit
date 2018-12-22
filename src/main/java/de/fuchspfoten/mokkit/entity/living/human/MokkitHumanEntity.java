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

package de.fuchspfoten.mokkit.entity.living.human;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.MokkitLivingEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import de.fuchspfoten.mokkit.inventory.MokkitInventory;
import de.fuchspfoten.mokkit.inventory.MokkitInventoryView;
import de.fuchspfoten.mokkit.inventory.MokkitPlayerInventory;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Villager;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

/**
 * @see org.bukkit.entity.HumanEntity
 */
public abstract class MokkitHumanEntity extends MokkitLivingEntity implements HumanEntity {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The inventory of the human entity.
     */
    private @Getter final PlayerInventory inventory = new MokkitPlayerInventory(this);

    /**
     * The game mode of the human entity.
     */
    private @Getter @Setter GameMode gameMode = GameMode.SURVIVAL;

    /**
     * The currently opened inventory.
     */
    private @Getter InventoryView openInventory;

    /**
     * The item on the cursor.
     */
    private @Getter @Setter ItemStack itemOnCursor;

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitHumanEntity(final @NonNull MokkitServer server, final @NonNull String name,
                             final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, name, location, uuid, 20.0);
    }

    @Override
    public void closeInventory() {
        if (openInventory == null) {
            return;
        }

        final InventoryCloseEvent event = new InventoryCloseEvent(openInventory);
        getServer().getPluginManager().callEvent(event);
        openInventory = null;
    }

    @Override
    public int getCooldown(final Material material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Inventory getEnderChest() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getExpToLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getItemInHand() {
        return getInventory().getItemInMainHand();
    }

    @Override
    public void setItemInHand(final ItemStack item) {
        getInventory().setItemInMainHand(item);
    }

    @Override
    public MainHand getMainHand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getShoulderEntityLeft() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShoulderEntityLeft(final Entity entity) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getShoulderEntityRight() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShoulderEntityRight(final Entity entity) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getSleepTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasCooldown(final Material material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBlocking() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isHandRaised() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSleeping() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openEnchanting(final Location location, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openInventory(final Inventory inventory) {
        final InventoryView newView = new MokkitInventoryView(inventory, this.inventory, this,
                inventory.getType());
        final InventoryOpenEvent event = new InventoryOpenEvent(newView);
        getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            return openInventory;
        }
        openInventory = newView;
        return openInventory;
    }

    @Override
    public void openInventory(final InventoryView inventory) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openMerchant(final Villager trader, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openMerchant(final Merchant merchant, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openWorkbench(final Location location, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCooldown(final Material material, final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setWindowProperty(final InventoryView.Property prop, final int value) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Consumes an item from the main hand.
     */
    protected void consumeItemInMainHand() {
        final ItemStack nextItem = getInventory().getItemInMainHand();
        if (nextItem.getAmount() == 1) {
            getInventory().setItemInMainHand(null);
        } else {
            nextItem.setAmount(nextItem.getAmount() - 1);
            getInventory().setItemInMainHand(nextItem);
        }
    }

    /**
     * Fetches the control object.
     *
     * @return The control object.
     */
    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * The class of the control object.
     */
    public class Mokkit extends MokkitLivingEntity.Mokkit {

        /**
         * Performs a click in the open bottom inventory.
         *
         * @param slot      The slot in the bottom inventory.
         * @param clickType The click type.
         * @param key       The pressed key, if any.
         */
        public void clickInBottomInventory(final int slot, final @NonNull ClickType clickType, final int key) {
            if (openInventory == null) {
                return;
            }
            assert 0 <= slot && slot < openInventory.getBottomInventory().getSize() : "invalid slot " + slot;

            final boolean armor = 36 <= slot && slot <= 39;
            final boolean offHand = slot == 40;
            final boolean hotbar = slot < 9;
            final int rawSlot;
            if (hotbar) {
                rawSlot = slot + 27;
            } else {
                if (armor) {
                    rawSlot = 44 - slot;
                } else {
                    if (offHand) {
                        rawSlot = slot + 5;
                    } else {
                        rawSlot = slot - 9;
                    }
                }
            }
            clickInOpenInventory(rawSlot + openInventory.getTopInventory().getSize(), clickType, key);
        }

        /**
         * Performs a click in the open top inventory.
         *
         * @param slot      The slot in the top inventory.
         * @param clickType The click type.
         * @param key       The pressed key, if any.
         */
        public void clickInTopInventory(final int slot, final @NonNull ClickType clickType, final int key) {
            if (openInventory == null) {
                return;
            }
            assert 0 <= slot && slot < openInventory.getTopInventory().getSize() : "invalid slot " + slot;
            clickInOpenInventory(slot, clickType, key);
        }

        /**
         * Performs a click in the open inventory.
         *
         * @param slot      The raw slot.
         * @param clickType The click type.
         * @param key The pressed key, if any.
         */
        private void clickInOpenInventory(final int slot, final @NonNull ClickType clickType, final int key) {
            if (openInventory == null) {
                return;
            }

            final boolean isBottom = slot >= openInventory.getTopInventory().getSize();
            final int convertedSlot = openInventory.convertSlot(slot);
            final Inventory inventory = isBottom ? openInventory.getBottomInventory() : openInventory.getTopInventory();

            final InventoryType.SlotType slotType;
            if (isBottom && slot < 5) {
                // Player crafting.
                slotType = (slot == 0) ? InventoryType.SlotType.RESULT : InventoryType.SlotType.CRAFTING;
            } else {
                slotType = ((MokkitInventory) inventory).getSlotType(convertedSlot);
            }

            final ItemStack cursor = openInventory.getCursor();
            final ItemStack current = inventory.getItem(convertedSlot);
            final boolean hasItem = current != null;
            final boolean hasCursor = cursor != null;
            final InventoryAction action;
            switch (clickType) {
                case LEFT:
                    if (hasItem) {
                        if (hasCursor) {
                            if (current.isSimilar(cursor)) {
                                if (current.getAmount() == current.getMaxStackSize()) {
                                    action = InventoryAction.NOTHING;
                                } else {
                                    action = InventoryAction.PLACE_SOME;
                                }
                            } else {
                                action = InventoryAction.SWAP_WITH_CURSOR;
                            }
                        } else {
                            action = InventoryAction.PICKUP_ALL;
                        }
                    } else {
                        if (hasCursor) {
                            action = InventoryAction.PLACE_ALL;
                        } else {
                            action = InventoryAction.NOTHING;
                        }
                    }
                    break;
                case UNKNOWN:
                    action = InventoryAction.UNKNOWN;
                    break;

                case SHIFT_LEFT:
                case RIGHT:
                case SHIFT_RIGHT:
                case WINDOW_BORDER_LEFT:
                case WINDOW_BORDER_RIGHT:
                case MIDDLE:
                case NUMBER_KEY:
                case DOUBLE_CLICK:
                case DROP:
                case CONTROL_DROP:
                case CREATIVE:
                default:
                    throw new UnsupportedMockException();
            }

            final InventoryClickEvent event = new InventoryClickEvent(openInventory, slotType, slot, clickType, action,
                    key);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            switch (action) {
                case NOTHING:
                    break;
                case PICKUP_ALL:
                    openInventory.setCursor(inventory.getItem(convertedSlot));
                    inventory.setItem(convertedSlot, null);
                    break;
                case SWAP_WITH_CURSOR:
                    final ItemStack tmp = openInventory.getCursor();
                    openInventory.setCursor(inventory.getItem(convertedSlot));
                    inventory.setItem(convertedSlot, tmp);
                    break;
                case PLACE_ALL:
                    inventory.setItem(convertedSlot, openInventory.getCursor());
                    openInventory.setCursor(null);
                    break;
                case PLACE_SOME:
                    throw new UnsupportedMockException();

                /*case PICKUP_SOME:
                case PICKUP_HALF:
                case PICKUP_ONE:
                case PLACE_ONE:
                case DROP_ALL_CURSOR:
                case DROP_ONE_CURSOR:
                case DROP_ALL_SLOT:
                case DROP_ONE_SLOT:
                case MOVE_TO_OTHER_INVENTORY:
                case HOTBAR_MOVE_AND_READD:
                case HOTBAR_SWAP:
                case CLONE_STACK:
                case COLLECT_TO_CURSOR:*/
                case UNKNOWN:
                    throw new UnsupportedMockException();
            }
        }
    }
}
