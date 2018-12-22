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

package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Wolf
 */
public class MokkitWolf extends MokkitTameableAnimals implements Wolf {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitWolf(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Wolf", location, uuid, 8.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.WOLF;
    }

    @Override
    public boolean isAngry() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAngry(final boolean angry) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public DyeColor getCollarColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCollarColor(final DyeColor color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSitting() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSitting(final boolean sitting) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTamed(final boolean tame) {
        super.setTamed(tame);
        if (isTamed()) {
            setMaxHealth(20.0);
        } else {
            setMaxHealth(8.0);
        }
    }
}
