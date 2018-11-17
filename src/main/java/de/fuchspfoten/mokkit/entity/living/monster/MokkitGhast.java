package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.MokkitFlying;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Ghast
 */
public class MokkitGhast extends MokkitFlying implements Ghast {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitGhast(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Ghast", location, uuid, 10.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.GHAST;
    }
}
