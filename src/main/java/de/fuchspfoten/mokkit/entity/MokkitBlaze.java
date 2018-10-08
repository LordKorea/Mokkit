package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Blaze
 */
public class MokkitBlaze extends MokkitMonster implements Blaze {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitBlaze(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Blaze", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.BLAZE;
    }
}
