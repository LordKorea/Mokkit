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

package io.gitlab.lordkorea.mokkit.entity.living.water;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.entity.living.MokkitLivingEntity;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.WaterMob;

import java.util.UUID;

/**
 * @see org.bukkit.entity.WaterMob
 */
public abstract class MokkitWaterMob extends MokkitLivingEntity implements WaterMob {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitWaterMob(final @NonNull MokkitServer server, final @NonNull String name,
                             final @NonNull Location location, final @NonNull UUID uuid,
                             final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }
}
