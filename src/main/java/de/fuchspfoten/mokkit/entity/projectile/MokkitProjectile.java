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

package de.fuchspfoten.mokkit.entity.projectile;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Projectile
 */
public abstract class MokkitProjectile extends MokkitEntity implements Projectile {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The shooter of this projectile.
     */
    private @Getter @Setter ProjectileSource shooter;

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitProjectile(final @NonNull MokkitServer server, final @NonNull String name,
                               final @NonNull Location location, final @NonNull UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public boolean doesBounce() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBounce(final boolean doesBounce) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Getter for the control object.
     *
     * @return The control object.
     */
    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitEntity.Mokkit {

        /**
         * Lets the projectile hit a target.
         *
         * @param target The target.
         */
        public void hitTarget(final @NonNull Entity target) {
            final ProjectileHitEvent hitEvent = new ProjectileHitEvent(MokkitProjectile.this, target);
            getServer().getPluginManager().callEvent(hitEvent);
            remove();
        }
    }
}
