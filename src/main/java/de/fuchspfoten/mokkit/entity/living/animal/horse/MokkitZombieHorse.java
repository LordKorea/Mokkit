package de.fuchspfoten.mokkit.entity.living.animal.horse;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ZombieHorse;

import java.util.UUID;

/**
 * @see org.bukkit.entity.ZombieHorse
 */
public class MokkitZombieHorse extends MokkitAbstractHorse implements ZombieHorse {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitZombieHorse(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "ZombieHorse", location, uuid, 15.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.ZOMBIE_HORSE;
    }
}
