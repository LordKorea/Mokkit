package de.fuchspfoten.mokkit.entity.living.boss;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.MokkitComplexLivingEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.EnderDragon
 */
public class MokkitEnderDragon extends MokkitComplexLivingEntity implements EnderDragon {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitEnderDragon(final @NonNull MokkitServer server, final @NonNull Location location,
                             final @NonNull UUID uuid) {
        super(server, "EnderDragon", location, uuid, 200.0);
    }

    @Override
    public Phase getPhase() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPhase(final Phase phase) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDER_DRAGON;
    }
}
