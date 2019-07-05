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

package io.gitlab.lordkorea.mokkit.entity.living.animal;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Sheep
 */
public class MokkitSheep extends MokkitAnimals implements Sheep {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSheep(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Sheep", location, uuid, 8.0);
    }

    @Override
    public DyeColor getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final DyeColor color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.SHEEP;
    }

    @Override
    public boolean isSheared() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSheared(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }
}
