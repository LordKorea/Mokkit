package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Creeper
 */
public class MokkitCreeper extends MokkitMonster implements Creeper {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitCreeper(final @NonNull MokkitServer server, final @NonNull Location location,
                         final @NonNull UUID uuid) {
        super(server, "Creeper", location, uuid, 20.0);
    }

    @Override
    public int getExplosionRadius() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setExplosionRadius(final int radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaxFuseTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaxFuseTicks(final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.CREEPER;
    }

    @Override
    public boolean isPowered() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPowered(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }
}
