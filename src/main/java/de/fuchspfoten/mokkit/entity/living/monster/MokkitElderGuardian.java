package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.ElderGuardian
 */
public class MokkitElderGuardian extends MokkitGuardian implements ElderGuardian {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitElderGuardian(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "ElderGuardian", location, uuid, 80.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.ELDER_GUARDIAN;
    }
}
