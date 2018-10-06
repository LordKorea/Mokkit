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
        // 4 Rows, Offhand, Armor, Crafting Grid.
        super(9 * 4 + 1 + 4 + 5);
    }

    @Override
    public ItemStack getItemInMainHand() {
        return getItem(getHeldItemSlot());
    }

    @Override
    public void setItemInMainHand(final ItemStack item) {
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
    public void setLeggings(final ItemStack leggings) {
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
    public ItemStack getItemInOffHand() {
        // TODO
        throw new UnsupportedMockException();
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
    public HumanEntity getHolder() {
        // TODO
        throw new UnsupportedMockException();
    }
}
