package de.fuchspfoten.mokkit.entity.vehicle.minecart;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;

import java.util.UUID;

/**
 * @see org.bukkit.entity.minecart.SpawnerMinecart
 */
public class MokkitSpawnerMinecart extends MokkitMinecart implements SpawnerMinecart {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSpawnerMinecart(final @NonNull MokkitServer server, final @NonNull Location location,
                                 final @NonNull UUID uuid) {
        super(server, "SpawnerMinecart", location, uuid);
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART_MOB_SPAWNER;
    }
}
