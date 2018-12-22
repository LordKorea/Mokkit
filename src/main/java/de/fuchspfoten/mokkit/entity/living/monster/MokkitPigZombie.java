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
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

import java.util.UUID;

/**
 * @see org.bukkit.entity.PigZombie
 */
public class MokkitPigZombie extends MokkitZombie implements PigZombie {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitPigZombie(final @NonNull MokkitServer server, final @NonNull Location location,
                           final @NonNull UUID uuid) {
        super(server, "PigZombie", location, uuid, 20.0);
    }

    @Override
    public int getAnger() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAnger(final int level) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.PIG_ZOMBIE;
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
}
