package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Cow
 */
public class MokkitCow extends MokkitAnimals implements Cow {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitCow(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Cow", location, uuid, 10.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.COW;
    }
}
