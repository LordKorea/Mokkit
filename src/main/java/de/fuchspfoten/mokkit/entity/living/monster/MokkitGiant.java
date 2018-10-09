package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Giant
 */
public class MokkitGiant extends MokkitMonster implements Giant {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitGiant(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Giant", location, uuid, 100.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.GIANT;
    }
}
