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

package de.fuchspfoten.mokkit.entity.hanging;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Hanging
 */
public abstract class MokkitHanging extends MokkitEntity implements Hanging {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitHanging(final @NonNull MokkitServer server, final @NonNull String name,
                         final @NonNull Location location, final @NonNull UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public BlockFace getAttachedFace() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double onDamaged(final @NonNull Entity damager, final double damage) {
        final HangingBreakByEntityEvent event = new HangingBreakByEntityEvent(this, damager,
                HangingBreakEvent.RemoveCause.ENTITY);
        getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            throw new CancelledByEventException(event);
        }

        // TODO drop?
        remove();

        return 1.0;
    }

    @Override
    public void setFacingDirection(final BlockFace face) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockFace getFacing() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setFacingDirection(final BlockFace face, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }
}
