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

package de.fuchspfoten.mokkit.enchantments;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

/**
 * @see org.bukkit.enchantments.Enchantment
 */
public final class MokkitEnchantment extends Enchantment {

    /**
     * Whether or not enchantments have already been registered.
     */
    private static boolean registeredEnchantments = false;

    /**
     * Registers all enchantments.
     */
    public static void registerEnchantments() {
        if (registeredEnchantments) {
            return;
        }

        Enchantment.registerEnchantment(new MokkitEnchantment(0, "PROTECTION_ENVIRONMENTAL"));
        Enchantment.registerEnchantment(new MokkitEnchantment(1, "PROTECTION_FIRE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(2, "PROTECTION_FALL"));
        Enchantment.registerEnchantment(new MokkitEnchantment(3, "PROTECTION_EXPLOSIONS"));
        Enchantment.registerEnchantment(new MokkitEnchantment(4, "PROTECTION_PROJECTILE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(5, "OXYGEN"));
        Enchantment.registerEnchantment(new MokkitEnchantment(6, "WATER_WORKER"));
        Enchantment.registerEnchantment(new MokkitEnchantment(7, "THORNS"));
        Enchantment.registerEnchantment(new MokkitEnchantment(8, "DEPTH_STRIDER"));
        Enchantment.registerEnchantment(new MokkitEnchantment(9, "FROST_WALKER"));
        Enchantment.registerEnchantment(new MokkitEnchantment(10, "BINDING_CURSE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(16, "DAMAGE_ALL"));
        Enchantment.registerEnchantment(new MokkitEnchantment(17, "DAMAGE_UNDEAD"));
        Enchantment.registerEnchantment(new MokkitEnchantment(18, "DAMAGE_ARTHROPODS"));
        Enchantment.registerEnchantment(new MokkitEnchantment(19, "KNOCKBACK"));
        Enchantment.registerEnchantment(new MokkitEnchantment(20, "FIRE_ASPECT"));
        Enchantment.registerEnchantment(new MokkitEnchantment(21, "LOOT_BONUS_MOBS"));
        Enchantment.registerEnchantment(new MokkitEnchantment(22, "SWEEPING_EDGE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(32, "DIG_SPEED"));
        Enchantment.registerEnchantment(new MokkitEnchantment(33, "SILK_TOUCH"));
        Enchantment.registerEnchantment(new MokkitEnchantment(34, "DURABILITY"));
        Enchantment.registerEnchantment(new MokkitEnchantment(35, "LOOT_BONUS_BLOCKS"));
        Enchantment.registerEnchantment(new MokkitEnchantment(48, "ARROW_DAMAGE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(49, "ARROW_KNOCKBACK"));
        Enchantment.registerEnchantment(new MokkitEnchantment(50, "ARROW_FIRE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(51, "ARROW_INFINITE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(61, "LUCK"));
        Enchantment.registerEnchantment(new MokkitEnchantment(62, "LURE"));
        Enchantment.registerEnchantment(new MokkitEnchantment(70, "MENDING"));
        Enchantment.registerEnchantment(new MokkitEnchantment(71, "VANISHING_CURSE"));

        registeredEnchantments = true;
    }

    /**
     * The name of the enchantment.
     */
    private @Getter final String name;

    /**
     * Constructor.
     *
     * @param id   The ID of the enchantment.
     * @param name The name of the enchantment.
     */
    private MokkitEnchantment(final int id, final @NonNull String name) {
        super(id);
        this.name = name;
    }

    @Override
    public int getMaxLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isTreasure() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isCursed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean conflictsWith(final Enchantment other) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean canEnchantItem(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }
}
