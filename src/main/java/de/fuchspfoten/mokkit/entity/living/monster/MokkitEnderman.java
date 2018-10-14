package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Enderman
 */
public class MokkitEnderman extends MokkitMonster implements Enderman {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitEnderman(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Enderman", location, uuid, 40.0);
    }

    @Override
    public MaterialData getCarriedMaterial() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCarriedMaterial(final MaterialData material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDERMAN;
    }
}
