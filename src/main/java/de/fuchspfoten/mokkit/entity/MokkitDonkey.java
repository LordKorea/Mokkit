package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Donkey
 */
public class MokkitDonkey extends MokkitChestedHorse implements Donkey {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitDonkey(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Donkey", location, uuid, 15.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.DONKEY;
    }
}