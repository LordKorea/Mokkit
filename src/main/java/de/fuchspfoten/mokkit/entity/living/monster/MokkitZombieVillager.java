package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ZombieVillager;

import java.util.UUID;

/**
 * @see org.bukkit.entity.ZombieVillager
 */
public class MokkitZombieVillager extends MokkitZombie implements ZombieVillager {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitZombieVillager(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "ZombieVillager", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.ZOMBIE_VILLAGER;
    }
}
