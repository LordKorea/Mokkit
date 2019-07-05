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

package io.gitlab.lordkorea.mokkit.entity.vehicle;

import io.gitlab.lordkorea.mokkit.CancelledByEventException;
import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.entity.MokkitEntity;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Vehicle
 */
public abstract class MokkitVehicle extends MokkitEntity implements Vehicle {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitVehicle(final @NonNull MokkitServer server, final @NonNull String name,
                            final @NonNull Location location, final @NonNull UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public double onDamaged(final @NonNull Entity damager, final double damage) {
        final VehicleDamageEvent damageEvent = new VehicleDamageEvent(this, damager, damage);
        getServer().getPluginManager().callEvent(damageEvent);
        if (damageEvent.isCancelled()) {
            throw new CancelledByEventException(damageEvent);
        }

        // Get the final damage.
        final double finalDamage = damageEvent.getDamage();
        if (finalDamage >= 2.0) {
            // TODO actual damage? how does it work?
            // Here we assume 2.0 damage points kill the vehicle.
            final VehicleDestroyEvent destroyEvent = new VehicleDestroyEvent(this, damager);
            getServer().getPluginManager().callEvent(destroyEvent);
            if (destroyEvent.isCancelled()) {
                throw new CancelledByEventException(destroyEvent);
            }

            // TODO drops?
            remove();
        }

        return finalDamage;
    }
}
