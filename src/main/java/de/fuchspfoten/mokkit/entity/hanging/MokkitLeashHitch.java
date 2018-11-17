package de.fuchspfoten.mokkit.entity.hanging;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LeashHitch;

import java.util.UUID;

/**
 * @see org.bukkit.entity.LeashHitch
 */
public class MokkitLeashHitch extends MokkitHanging implements LeashHitch {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitLeashHitch(final @NonNull MokkitServer server, final @NonNull Location location,
                            final @NonNull UUID uniqueId) {
        super(server, "LeashHitch", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.LEASH_HITCH;
    }
}
