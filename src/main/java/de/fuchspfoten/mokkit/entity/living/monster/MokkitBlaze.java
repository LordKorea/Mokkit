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

package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Blaze
 */
public class MokkitBlaze extends MokkitMonster implements Blaze {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitBlaze(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Blaze", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.BLAZE;
    }
}
