package de.fuchspfoten.mokkit.entity.vehicle;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.TreeSpecies;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Boat
 */
public class MokkitBoat extends MokkitVehicle implements Boat {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitBoat(final @NonNull MokkitServer server, final @NonNull Location location,
                      final @NonNull UUID uniqueId) {
        super(server, "Boat", location, uniqueId);
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
    public double getOccupiedDeceleration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setOccupiedDeceleration(final double rate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.BOAT;
    }

    @Override
    public double getUnoccupiedDeceleration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setUnoccupiedDeceleration(final double rate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public TreeSpecies getWoodType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWoodType(final TreeSpecies species) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getWorkOnLand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWorkOnLand(final boolean workOnLand) {
        // TODO
        throw new UnsupportedMockException();
    }
}
