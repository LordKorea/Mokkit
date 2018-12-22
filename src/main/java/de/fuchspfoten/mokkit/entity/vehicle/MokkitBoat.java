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

package de.fuchspfoten.mokkit.entity.vehicle;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.TreeSpecies;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Boat
 */
public class MokkitBoat extends MokkitVehicle implements Boat {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitBoat(final @NonNull MokkitServer server, final @NonNull Location location,
                      final @NonNull UUID uniqueId) {
        super(server, "Boat", location, uniqueId);
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
    public double getOccupiedDeceleration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setOccupiedDeceleration(final double rate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.BOAT;
    }

    @Override
    public double getUnoccupiedDeceleration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setUnoccupiedDeceleration(final double rate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public TreeSpecies getWoodType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWoodType(final TreeSpecies species) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getWorkOnLand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWorkOnLand(final boolean workOnLand) {
        // TODO
        throw new UnsupportedMockException();
    }
}
