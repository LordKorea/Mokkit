package de.fuchspfoten.mokkit.inventory;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
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
    private final ItemStack[] contents;

    /**
     * Constructor.
     *
     * @param size The size of inventory.
     */
    public MokkitInventory(final int size) {
        contents = new ItemStack[size];
    }

    @Override
    public ItemStack getItem(final int index) {
        return contents[index];
    }

    @Override
    public void setItem(final int index, final ItemStack item) {
        contents[index] = item;
    }

    @Override
    public int getSize() {
        return contents.length;
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
    public HashMap<Integer, ItemStack> addItem(final ItemStack... items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(final ItemStack... items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack[] getContents() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setContents(final ItemStack[] items) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
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
    public List<HumanEntity> getViewers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getTitle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryType getType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryHolder getHolder() {
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
    public Location getLocation() {
        // TODO
        throw new UnsupportedMockException();
    }
}
