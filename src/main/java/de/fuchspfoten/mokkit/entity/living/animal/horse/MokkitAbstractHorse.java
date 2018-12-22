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

package de.fuchspfoten.mokkit.entity.living.animal.horse;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitAnimals;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.AbstractHorseInventory;

import java.util.UUID;

/**
 * @see org.bukkit.entity.AbstractHorse
 */
public abstract class MokkitAbstractHorse extends MokkitAnimals implements AbstractHorse {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitAbstractHorse(final @NonNull MokkitServer server, final @NonNull String name,
                               final @NonNull Location location, final @NonNull UUID uuid,
                               final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public int getDomestication() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDomestication(final int level) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public AbstractHorseInventory getInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getJumpStrength() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setJumpStrength(final double strength) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaxDomestication() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaxDomestication(final int level) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public AnimalTamer getOwner() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setOwner(final AnimalTamer tamer) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Horse.Variant getVariant() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setVariant(final Horse.Variant variant) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isTamed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTamed(final boolean tame) {
        // TODO
        throw new UnsupportedMockException();
    }
}
