package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.MokkitLivingEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
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
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitSlime(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Slime", location, uuid, 1.0);
    }

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitSlime(final @NonNull MokkitServer server, final @NonNull String name,
                          final @NonNull Location location, final @NonNull UUID uuid, final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
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
    public LivingEntity getTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTarget(final LivingEntity target) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.SLIME;
    }
}
