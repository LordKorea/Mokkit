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

package de.fuchspfoten.mokkit.entity.projectile.fireball;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.projectile.MokkitProjectile;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Fireball
 */
public abstract class MokkitFireball extends MokkitProjectile implements Fireball {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitFireball(final @NonNull MokkitServer server, final @NonNull String name,
                             final @NonNull Location location, final @NonNull UUID uniqueId) {
        super(server, name, location, uniqueId);
        setVelocity(new Vector(1.0, 0.0, 0.0));
    }

    @Override
    public Vector getDirection() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDirection(final Vector direction) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getYield() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setYield(final float yield) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isIncendiary() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setIsIncendiary(final boolean isIncendiary) {
        // TODO
        throw new UnsupportedMockException();
    }
}
