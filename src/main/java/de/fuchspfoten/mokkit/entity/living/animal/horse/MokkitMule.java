package de.fuchspfoten.mokkit.entity.living.animal.horse;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mule;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Mule
 */
public class MokkitMule extends MokkitChestedHorse implements Mule {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitMule(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Mule", location, uuid, 15.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.MULE;
    }
}
