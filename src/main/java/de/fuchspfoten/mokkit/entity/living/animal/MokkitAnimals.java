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
import de.fuchspfoten.mokkit.entity.living.MokkitAgeable;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Animals;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Animals
 */
public abstract class MokkitAnimals extends MokkitAgeable implements Animals {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitAnimals(final @NonNull MokkitServer server, final @NonNull String name,
                         final @NonNull Location location, final @NonNull UUID uuid, final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }
}
