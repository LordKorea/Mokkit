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

package io.gitlab.lordkorea.mokkit.entity.projectile.arrow;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TippedArrow;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

/**
 * @see org.bukkit.entity.TippedArrow
 */
public class MokkitTippedArrow extends MokkitArrow implements TippedArrow {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitTippedArrow(final @NonNull MokkitServer server, final @NonNull Location location,
                             final @NonNull UUID uniqueId) {
        super(server, "TippedArrow", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.TIPPED_ARROW;
    }

    @Override
    public boolean addCustomEffect(final PotionEffect effect, final boolean overwrite) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void clearCustomEffects() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PotionData getBasePotionData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBasePotionData(final PotionData data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Color getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final Color color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<PotionEffect> getCustomEffects() {
        // TODO
        throw new UnsupportedMockException();
    }


    @Override
    public boolean hasCustomEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasCustomEffects() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removeCustomEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }
}
