package de.fuchspfoten.mokkit.inventory;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
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
    private @Getter @Setter int heldItemSlot = 0;

    /**
     * Constructor.
     */
    public MokkitPlayerInventory(final @NonNull InventoryHolder holder) {
        // Hotbar: 0..8.
        // Items: 9..35.
        // Armor: 36..39.
        // Off Hand: 40.
        super(9 + 3 * 9 + 4 + 1, holder, "", InventoryType.PLAYER);
    }

    @Override
    public int clear(final int id, final int data) {
        // TODO
        throw new UnsupportedMockException();
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
