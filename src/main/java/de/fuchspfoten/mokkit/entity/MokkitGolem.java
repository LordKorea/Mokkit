package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.Golem;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Golem
 */
public class MokkitGolem extends MokkitCreature implements Golem {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitGolem(final MokkitServer server, final String name, final Location location, final UUID uuid,
                       final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }
}
