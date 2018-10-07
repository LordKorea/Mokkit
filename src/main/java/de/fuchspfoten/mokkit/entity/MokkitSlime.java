package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Slime;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Slime
 */
public class MokkitSlime extends MokkitLivingEntity implements Slime {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     */
    public MokkitSlime(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Slime", location, uuid, 1.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.SLIME;
    }

    @Override
    public int getSize() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSize(final int sz) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTarget(final LivingEntity target) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public LivingEntity getTarget() {
        // TODO
        throw new UnsupportedMockException();
    }
}
