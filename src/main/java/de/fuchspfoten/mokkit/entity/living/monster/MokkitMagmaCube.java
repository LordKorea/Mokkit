package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;

import java.util.UUID;

/**
 * @see org.bukkit.entity.MagmaCube
 */
public class MokkitMagmaCube extends MokkitSlime implements MagmaCube {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitMagmaCube(final @NonNull MokkitServer server, final @NonNull Location location,
                           final @NonNull UUID uuid) {
        super(server, "MagmaCube", location, uuid, 1.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.MAGMA_CUBE;
    }
}
