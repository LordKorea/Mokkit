package de.fuchspfoten.mokkit.inventory;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * @see org.bukkit.inventory.Inventory
 */
public abstract class MokkitInventory implements Inventory {

    /**
     * The contents of the inventory.
     */
    protected final ItemStack[] contents;

    /**
     * The holder of the inventory.
     */
    private @Getter final InventoryHolder holder;

    /**
     * The inventory title.
     */
    private @Getter final String title;

    /**
     * The type of this inventory.
     */
    private @Getter final InventoryType type;

    /**
     * Constructor.
     *
     * @param size The size of inventory.
     * @param holder The holder of the inventory.
     * @param title  The title of the inventory.
     */
    public MokkitInventory(final int size, final InventoryHolder holder, final @NonNull String title,
                           final @NonNull InventoryType type) {
        assert size >= 0 : "invalid size " + size;
        contents = new ItemStack[size];
        this.holder = holder;
        this.title = title;
        this.type = type;
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(final ItemStack... items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(final int materialId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void clear(final int index) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void clear() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean contains(final int materialId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean contains(final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean contains(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean contains(final int materialId, final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean contains(final Material material, final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean contains(final ItemStack item, final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean containsAtLeast(final ItemStack item, final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int first(final int materialId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int first(final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int first(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int firstEmpty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack[] getContents() {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Gets the type of the given slot.
     *
     * @param slot The slot.
     * @return The slot type.
     */
    public abstract InventoryType.SlotType getSlotType(final int slot);

    @Override
    public void setContents(final ItemStack[] items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getItem(final int index) {
        return contents[index];
    }

    @Override
    public Location getLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaxStackSize() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaxStackSize(final int size) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getSize() {
        return contents.length;
    }

    @Override
    public ItemStack[] getStorageContents() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStorageContents(final ItemStack[] items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<HumanEntity> getViewers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ListIterator<ItemStack> iterator(final int index) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void remove(final int materialId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void remove(final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void remove(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(final ItemStack... items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItem(final int index, final ItemStack item) {
        contents[index] = item;
    }
}
