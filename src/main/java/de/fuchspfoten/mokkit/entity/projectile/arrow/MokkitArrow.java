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

package de.fuchspfoten.mokkit.entity.projectile.arrow;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.entity.projectile.MokkitProjectile;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Arrow
 */
public class MokkitArrow extends MokkitProjectile implements Arrow {

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
    public MokkitArrow(final @NonNull MokkitServer server, final @NonNull Location location,
                       final @NonNull UUID uniqueId) {
        super(server, "Arrow", location, uniqueId);
    }

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitArrow(final @NonNull MokkitServer server, final @NonNull String name,
                          final @NonNull Location location, final @NonNull UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public int getKnockbackStrength() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setKnockbackStrength(final int knockbackStrength) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isCritical() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCritical(final boolean critical) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isInBlock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getAttachedBlock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PickupStatus getPickupStatus() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPickupStatus(final PickupStatus status) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.ARROW;
    }

    @Override
    public Arrow.Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitProjectile.Mokkit {

        @Override
        public void hitTarget(final @NonNull Entity target) {
            super.hitTarget(target);

            // TODO how much damage?
            final double resultDamage = ((MokkitEntity) target).onDamaged(MokkitArrow.this, 1.0);
            if (target instanceof LivingEntity) {
                ((Damageable) target).damage(resultDamage);
            }

            // The arrow is now in the player, no longer an entity.
            // TODO confirm this?
            remove();
        }
    }
}
