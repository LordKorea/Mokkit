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

package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.vehicle.MokkitVehicle;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Minecart
 */
public abstract class MokkitMinecart extends MokkitVehicle implements Minecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitMinecart(final @NonNull MokkitServer server, final @NonNull String name,
                          final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, name, location, uuid);
    }

    @Override
    public double getDamage() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDamage(final double damage) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Vector getDerailedVelocityMod() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDerailedVelocityMod(final Vector derailed) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public MaterialData getDisplayBlock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDisplayBlock(final MaterialData material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getDisplayBlockOffset() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDisplayBlockOffset(final int offset) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Vector getFlyingVelocityMod() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFlyingVelocityMod(final Vector flying) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getMaxSpeed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaxSpeed(final double speed) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSlowWhenEmpty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSlowWhenEmpty(final boolean slow) {
        // TODO
        throw new UnsupportedMockException();
    }
}
