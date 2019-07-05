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

package io.gitlab.lordkorea.mokkit.entity.misc;

import io.gitlab.lordkorea.mokkit.CancelledByEventException;
import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.entity.MokkitEntity;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @see org.bukkit.entity.EnderCrystal
 */
public class MokkitEnderCrystal extends MokkitEntity implements EnderCrystal {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitEnderCrystal(final @NonNull MokkitServer server, final @NonNull Location location,
                              final @NonNull UUID uniqueId) {
        super(server, "EnderCrystal", location, uniqueId);
    }

    @Override
    public boolean isShowingBottom() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShowingBottom(final boolean showing) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getBeamTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBeamTarget(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double onDamaged(final @NonNull Entity damager, final double damage) {
        final double dmg = super.onDamaged(damager, damage);

        // TODO: Explosion blocks and strength.
        final EntityExplodeEvent explosionEvent = new EntityExplodeEvent(this, getLocation(), new ArrayList<>(),
                0.0f);
        getServer().getPluginManager().callEvent(explosionEvent);
        if (explosionEvent.isCancelled()) {
            throw new CancelledByEventException(explosionEvent);
        }

        // Remove the target.
        remove();

        // Perform the explosion.
        // TODO perform the explosion.

        return dmg;
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDER_CRYSTAL;
    }
}
