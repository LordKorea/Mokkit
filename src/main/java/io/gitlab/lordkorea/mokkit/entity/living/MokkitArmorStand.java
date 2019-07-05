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

package io.gitlab.lordkorea.mokkit.entity.living;

import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.UUID;

/**
 * @see org.bukkit.entity.ArmorStand
 */
public class MokkitArmorStand extends MokkitLivingEntity implements ArmorStand {

    /**
     * The item the armor stand is holding.
     */
    private @Getter @Setter ItemStack itemInHand;

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitArmorStand(final @NonNull MokkitServer server, final @NonNull Location location,
                            final @NonNull UUID uuid) {
        super(server, "ArmorStand", location, uuid, 2.0);
    }

    @Override
    public ItemStack getBoots() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBoots(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getLeggings() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLeggings(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getChestplate() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setChestplate(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getHelmet() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setHelmet(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EulerAngle getBodyPose() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBodyPose(final EulerAngle pose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EulerAngle getLeftArmPose() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLeftArmPose(final EulerAngle pose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EulerAngle getRightArmPose() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRightArmPose(final EulerAngle pose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EulerAngle getLeftLegPose() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLeftLegPose(final EulerAngle pose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EulerAngle getRightLegPose() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRightLegPose(final EulerAngle pose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EulerAngle getHeadPose() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setHeadPose(final EulerAngle pose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasBasePlate() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBasePlate(final boolean basePlate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isVisible() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setVisible(final boolean visible) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasArms() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setArms(final boolean arms) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSmall() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSmall(final boolean small) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isMarker() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMarker(final boolean marker) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.ARMOR_STAND;
    }
}
