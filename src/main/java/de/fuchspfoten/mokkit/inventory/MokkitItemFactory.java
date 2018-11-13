package de.fuchspfoten.mokkit.inventory;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import de.fuchspfoten.mokkit.inventory.meta.MokkitItemMeta;
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
    public ItemMeta asMetaFor(final ItemMeta meta, final ItemStack stack) throws IllegalArgumentException {
        // TODO: subclasses?
        return meta;
    }

    @Override
    public ItemMeta asMetaFor(final ItemMeta meta, final Material material) throws IllegalArgumentException {
        // TODO: subclasses?
        return meta;
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
    public Color getDefaultLeatherColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemMeta getItemMeta(final Material material) {
        // TODO: subclasses?
        return new MokkitItemMeta();
    }

    @Override
    public boolean isApplicable(final ItemMeta meta, final ItemStack stack) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isApplicable(final ItemMeta meta, final Material material) throws IllegalArgumentException {
        // TODO: subclasses?
        return true;
    }
}
