package de.fuchspfoten.mokkit.entity.living;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
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
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitArmorStand(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "ArmorStand", location, uuid, 2.0);
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
    public ItemStack getItemInHand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItemInHand(final ItemStack item) {
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
    public EntityType getType() {
        return EntityType.ARMOR_STAND;
    }

    @Override
    public boolean hasArms() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasBasePlate() {
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
    public void setArms(final boolean arms) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBasePlate(final boolean basePlate) {
        // TODO
        throw new UnsupportedMockException();
    }
}
