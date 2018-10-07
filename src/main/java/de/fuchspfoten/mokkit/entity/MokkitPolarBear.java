package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PolarBear;

import java.util.UUID;

/**
 * @see org.bukkit.entity.PolarBear
 */
public class MokkitPolarBear extends MokkitAnimals implements PolarBear {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitPolarBear(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "PolarBear", location, uuid, 30.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.POLAR_BEAR;
    }
}
