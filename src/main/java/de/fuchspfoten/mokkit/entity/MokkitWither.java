package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Wither
 */
public class MokkitWither extends MokkitMonster implements Wither {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     */
    public MokkitWither(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Wither", location, uuid, 300.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.WITHER;
    }
}
