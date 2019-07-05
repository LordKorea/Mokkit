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
import io.gitlab.lordkorea.mokkit.inventory.meta.MokkitItemMeta;
import lombok.NonNull;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @see org.bukkit.inventory.ItemFactory
 */
public class MokkitItemFactory implements ItemFactory {

    @Override
    public ItemMeta getItemMeta(final @NonNull Material material) {
        // TODO: subclasses?
        return new MokkitItemMeta();
    }

    @Override
    public boolean isApplicable(final ItemMeta meta, final ItemStack stack) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isApplicable(final @NonNull ItemMeta meta, final @NonNull Material material)
            throws IllegalArgumentException {
        // TODO: subclasses?
        return true;
    }

    @Override
    public boolean equals(final ItemMeta meta1, final ItemMeta meta2) throws IllegalArgumentException {
        if (meta1 == null) {
            return meta2 == null || ((MokkitItemMeta) meta2).isEmpty();
        }
        if (meta2 == null) {
            return ((MokkitItemMeta) meta1).isEmpty();
        }
        if (meta1.getClass() != meta2.getClass()) {
            return false;
        }
        return meta1.equals(meta2);
    }

    @Override
    public ItemMeta asMetaFor(final @NonNull ItemMeta meta, final @NonNull ItemStack stack)
            throws IllegalArgumentException {
        // TODO: subclasses?
        return meta;
    }

    @Override
    public ItemMeta asMetaFor(final @NonNull ItemMeta meta, final @NonNull Material material)
            throws IllegalArgumentException {
        // TODO: subclasses?
        return meta;
    }

    @Override
    public Color getDefaultLeatherColor() {
        // TODO
        throw new UnsupportedMockException();
    }
}
