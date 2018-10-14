package de.fuchspfoten.mokkit.inventory;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 * @see org.bukkit.inventory.PlayerInventory
 */
public class MokkitPlayerInventory extends MokkitInventory implements PlayerInventory {

    /**
     * The slot of the item currently being held.
     */
    private @Getter @Setter int heldItemSlot = 0;

    /**
     * Constructor.
     */
    public MokkitPlayerInventory() {
        // Hotbar: 0..8.
        // Items: 9..35.
        // Armor: 36..39.
        // Off Hand: 40.
        super(9 + 3 * 9 + 4 + 1);
    }

    @Override
    public int clear(final int id, final int data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack[] getArmorContents() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setArmorContents(final ItemStack[] items) {
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
    public ItemStack[] getExtraContents() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setExtraContents(final ItemStack[] items) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getHelmet() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setHelmet(final ItemStack helmet) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HumanEntity getHolder() {
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
    public ItemStack getItemInMainHand() {
        return getItem(getHeldItemSlot());
    }

    @Override
    public void setItemInMainHand(final ItemStack item) {
        setItem(getHeldItemSlot(), item);
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
    public ItemStack getLeggings() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLeggings(final ItemStack leggings) {
        // TODO
        throw new UnsupportedMockException();
    }
}
