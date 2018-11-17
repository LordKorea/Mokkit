package de.fuchspfoten.mokkit.inventory.meta;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @see org.bukkit.inventory.meta.ItemMeta
 */
public class MokkitItemMeta implements ItemMeta, Cloneable {

    /**
     * The lore of this item meta's item.
     */
    private @Getter @Setter List<String> lore;

    /**
     * The display name of this item meta's item.
     */
    private @Getter @Setter String displayName;

    /**
     * Whether or not this item meta is of an unbreakable item.
     */
    private @Getter @Setter boolean unbreakable;

    /**
     * The set of flags of this item meta's item.
     */
    private final Set<ItemFlag> flags = EnumSet.noneOf(ItemFlag.class);

    @Override
    public boolean addEnchant(final Enchantment ench, final int level, final boolean ignoreLevelRestriction) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void addItemFlags(final @NonNull ItemFlag... itemFlags) {
        for (final ItemFlag flag : itemFlags) {
            assert flag != null : "flags must not be null";
            flags.add(flag);
        }
    }

    @Override
    public ItemMeta clone() {
        try {
            final MokkitItemMeta meta = (MokkitItemMeta) super.clone();
            meta.lore = hasLore() ? new ArrayList<>(lore) : null;
            return meta;
        } catch (final CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
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
        return Collections.unmodifiableSet(flags);
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
    public boolean hasConflictingEnchant(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasDisplayName() {
        return displayName != null;
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
    public boolean hasItemFlag(final @NonNull ItemFlag flag) {
        return flags.contains(flag);
    }

    @Override
    public boolean hasLocalizedName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasLore() {
        return lore != null && !lore.isEmpty();
    }

    /**
     * Checks this meta for emptiness.
     *
     * @return true iff this meta is empty.
     */
    public boolean isEmpty() {
        // TODO update this to changes.
        return !hasLore() && !hasDisplayName();
    }

    @Override
    public boolean removeEnchant(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeItemFlags(final @NonNull ItemFlag... itemFlags) {
        for (final ItemFlag flag : itemFlags) {
            assert flag != null : "item flags must not be null";
            flags.remove(flag);
        }
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
