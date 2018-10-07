package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Creature
 */
public abstract class MokkitCreature extends MokkitLivingEntity implements Creature {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitCreature(final MokkitServer server, final String name, final Location location, final UUID uuid,
                          final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public LivingEntity getTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTarget(final LivingEntity target) {
        // TODO
        throw new UnsupportedMockException();
    }
}
