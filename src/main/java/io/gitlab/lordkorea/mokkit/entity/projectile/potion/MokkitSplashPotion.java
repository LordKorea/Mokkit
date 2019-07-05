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

package io.gitlab.lordkorea.mokkit.entity.projectile.potion;

import io.gitlab.lordkorea.mokkit.CancelledByEventException;
import io.gitlab.lordkorea.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.SplashPotion;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

/**
 * @see org.bukkit.entity.SplashPotion
 */
public class MokkitSplashPotion extends MokkitThrownPotion implements SplashPotion {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitSplashPotion(final @NonNull MokkitServer server, final @NonNull Location location,
                              final @NonNull UUID uniqueId) {
        super(server, "SplashPotion", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.SPLASH_POTION;
    }

    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitThrownPotion.Mokkit {

        /**
         * Causes the potion to splash.
         */
        public void splash() {
            final Map<LivingEntity, Double> intensityMap = new HashMap<>();
            for (final Entity entity : getWorld().getNearbyEntities(getLocation(), 5.0, 5.0, 5.0)) {
                if (entity instanceof LivingEntity) {
                    final double distanceInverse = 75 - entity.getLocation().distanceSquared(getLocation());
                    final double invDistNormal = distanceInverse / 75.0;
                    intensityMap.put((LivingEntity) entity, invDistNormal);
                }
            }

            final PotionSplashEvent event = new PotionSplashEvent(MokkitSplashPotion.this, intensityMap);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Apply the effects.
            for (final PotionEffect effect : getEffects()) {
                for (final Entry<LivingEntity, Double> entry : intensityMap.entrySet()) {
                    final PotionEffect scaled = new PotionEffect(effect.getType(),
                            (int) (effect.getDuration() * entry.getValue()), effect.getAmplifier(), effect.isAmbient(),
                            effect.hasParticles(), effect.getColor());
                    entry.getKey().addPotionEffect(scaled);
                }
            }

            remove();
        }

        @Override
        public void hitTarget(final @NonNull Entity target) {
            splash();
        }
    }
}
