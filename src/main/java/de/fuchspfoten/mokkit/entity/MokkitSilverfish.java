package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Silverfish;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Silverfish
 */
public class MokkitSilverfish extends MokkitMonster implements Silverfish {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     */
    public MokkitSilverfish(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Silverfish", location, uuid, 8.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.SILVERFISH;
    }
}
