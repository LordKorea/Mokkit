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

package io.gitlab.lordkorea.mokkit.entity.living.animal;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Animals
 * @see org.bukkit.entity.Tameable
 */
public abstract class MokkitTameableAnimals extends MokkitAnimals implements Tameable {

    /**
     * The UUID of the tameable owner.
     */
    private UUID ownerUUID;

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitTameableAnimals(final @NonNull MokkitServer server, final @NonNull String name,
                                    final @NonNull Location location, final @NonNull UUID uuid,
                                    final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public boolean isTamed() {
        return ownerUUID != null;
    }

    @Override
    public void setTamed(final boolean tame) {
        if (!isTamed()) {
            ownerUUID = UUID.randomUUID();
        }
    }

    @Override
    public AnimalTamer getOwner() {
        if (!isTamed()) {
            return null;
        }

        final Player onlineOwner = Bukkit.getPlayer(ownerUUID);
        if (onlineOwner == null || !onlineOwner.isOnline()) {
            return Bukkit.getOfflinePlayer(ownerUUID);
        }
        return onlineOwner;
    }

    @Override
    public void setOwner(final @NonNull AnimalTamer tamer) {
        ownerUUID = tamer.getUniqueId();
    }
}
