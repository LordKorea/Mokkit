package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Stray;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Stray
 */
public class MokkitStray extends MokkitSkeleton implements Stray {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitStray(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Stray", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.STRAY;
    }
}
