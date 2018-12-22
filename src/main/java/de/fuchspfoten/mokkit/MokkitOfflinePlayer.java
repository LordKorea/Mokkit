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

package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

/**
 * @see org.bukkit.OfflinePlayer
 */
public class MokkitOfflinePlayer implements OfflinePlayer {

    /**
     * The UUID of the player.
     */
    private @Getter final UUID uniqueId;

    /**
     * Constructor.
     *
     * @param uniqueId The UUID of the player.
     */
    public MokkitOfflinePlayer(final @NonNull UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public boolean isOnline() {
        return Bukkit.getPlayer(uniqueId) != null;
    }

    @Override
    public String getName() {
        if (isOnline()) {
            return getPlayer().getName();
        }
        return null;
    }

    @Override
    public boolean isBanned() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isWhitelisted() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWhitelisted(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getPlayer() {
        if (isOnline()) {
            return Bukkit.getPlayer(uniqueId);
        }
        return null;
    }

    @Override
    public long getFirstPlayed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getLastPlayed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasPlayedBefore() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getBedSpawnLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isOp() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setOp(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, Object> serialize() {
        // TODO
        throw new UnsupportedMockException();
    }
}
