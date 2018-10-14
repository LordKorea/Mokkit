package de.fuchspfoten.mokkit.entity.projectile.arrow;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.SpectralArrow;

import java.util.UUID;

/**
 * @see org.bukkit.entity.SpectralArrow
 */
public class MokkitSpectralArrow extends MokkitArrow implements SpectralArrow {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitSpectralArrow(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "SpectralArrow", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.SPECTRAL_ARROW;
    }

    @Override
    public int getGlowingTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setGlowingTicks(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }
}
