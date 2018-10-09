package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Husk;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Husk
 */
public class MokkitHusk extends MokkitZombie implements Husk {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitHusk(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Husk", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.HUSK;
    }
}
