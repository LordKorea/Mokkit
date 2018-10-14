package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.vehicle.MokkitVehicle;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Minecart
 */
public abstract class MokkitMinecart extends MokkitVehicle implements Minecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitMinecart(final MokkitServer server, final String name, final Location location, final UUID uuid) {
        super(server, name, location, uuid);
    }

    @Override
    public double getDamage() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDamage(final double damage) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Vector getDerailedVelocityMod() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDerailedVelocityMod(final Vector derailed) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public MaterialData getDisplayBlock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDisplayBlock(final MaterialData material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getDisplayBlockOffset() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDisplayBlockOffset(final int offset) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Vector getFlyingVelocityMod() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFlyingVelocityMod(final Vector flying) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getMaxSpeed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaxSpeed(final double speed) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSlowWhenEmpty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSlowWhenEmpty(final boolean slow) {
        // TODO
        throw new UnsupportedMockException();
    }
}
