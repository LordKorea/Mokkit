package de.fuchspfoten.mokkit.entity.living;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;

import java.util.Set;
import java.util.UUID;

/**
 * @see org.bukkit.entity.ComplexLivingEntity
 */
public abstract class MokkitComplexLivingEntity extends MokkitLivingEntity implements ComplexLivingEntity {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitComplexLivingEntity(final @NonNull MokkitServer server, final @NonNull String name,
                                     final @NonNull Location location, final @NonNull UUID uuid,
                                     final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public Set<ComplexEntityPart> getParts() {
        // TODO
        throw new UnsupportedMockException();
    }
}
