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

package de.fuchspfoten.mokkit.inventory.meta;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class MokkitItemMeta implements ItemMeta, Cloneable {

    /**
     * The set of flags of this item meta's item.
     */
    private final Set<ItemFlag> flags = EnumSet.noneOf(ItemFlag.class);
    /**
     * The lore of this item meta's item.
     */
    private @Getter
    @Setter
    List<String> lore;
    /**
     * The display name of this item meta's item.
     */
    private @Getter
    @Setter
    String displayName;
    /**
     * Whether or not this item meta is of an unbreakable item.
     */
    private @Getter
    @Setter
    boolean unbreakable;

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
    public MokkitItemMeta clone() {
        try {
            final MokkitItemMeta meta = (MokkitItemMeta) super.clone();
            meta.lore = hasLore() ? new ArrayList<>(lore) : null;
            return meta;
        } catch (final CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean hasDisplayName() {
        return displayName != null;
    }

    @Override
    public boolean hasLocalizedName() {
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
    public boolean hasLore() {
        return lore != null && !lore.isEmpty();
    }

    @Override
    public boolean hasEnchants() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasEnchant(final Enchantment ench) {
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
    public boolean addEnchant(final Enchantment ench, final int level, final boolean ignoreLevelRestriction) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removeEnchant(final Enchantment ench) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasConflictingEnchant(final Enchantment ench) {
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
    public void removeItemFlags(final @NonNull ItemFlag... itemFlags) {
        for (final ItemFlag flag : itemFlags) {
            assert flag != null : "item flags must not be null";
            flags.remove(flag);
        }
    }

    @Override
    public Set<ItemFlag> getItemFlags() {
        return Collections.unmodifiableSet(flags);
    }

    @Override
    public boolean hasItemFlag(final @NonNull ItemFlag flag) {
        return flags.contains(flag);
    }

    @Override
    public Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, Object> serialize() {
        // TODO
        throw new UnsupportedMockException();
    }
}
