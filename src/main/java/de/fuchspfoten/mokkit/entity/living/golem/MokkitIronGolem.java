package de.fuchspfoten.mokkit.entity.living.golem;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;

import java.util.UUID;

/**
 * @see org.bukkit.entity.IronGolem
 */
public class MokkitIronGolem extends MokkitGolem implements IronGolem {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitIronGolem(final @NonNull MokkitServer server, final @NonNull Location location,
                           final @NonNull UUID uuid) {
        super(server, "IronGolem", location, uuid, 100.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.IRON_GOLEM;
    }

    @Override
    public boolean isPlayerCreated() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPlayerCreated(final boolean playerCreated) {
        // TODO
        throw new UnsupportedMockException();
    }
}
