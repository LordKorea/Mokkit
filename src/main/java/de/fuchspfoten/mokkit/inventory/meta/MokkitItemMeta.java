package de.fuchspfoten.mokkit.inventory.meta;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @see org.bukkit.inventory.meta.ItemMeta
 */
public class MokkitItemMeta implements ItemMeta {

    @Override
    public boolean addEnchant(final Enchantment ench, final int level, final boolean ignoreLevelRestriction) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void addItemFlags(final ItemFlag... itemFlags) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemMeta clone() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getDisplayName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDisplayName(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getEnchantLevel(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<Enchantment, Integer> getEnchants() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<ItemFlag> getItemFlags() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getLocalizedName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLocalizedName(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<String> getLore() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLore(final List<String> lore) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasConflictingEnchant(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasDisplayName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasEnchant(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasEnchants() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasItemFlag(final ItemFlag flag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasLocalizedName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasLore() {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Checks this meta for emptiness.
     *
     * @return true iff this meta is empty.
     */
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean isUnbreakable() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setUnbreakable(final boolean unbreakable) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removeEnchant(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeItemFlags(final ItemFlag... itemFlags) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, Object> serialize() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }
}
