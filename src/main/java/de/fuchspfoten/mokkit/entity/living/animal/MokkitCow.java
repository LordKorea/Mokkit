package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Cow
 */
public class MokkitCow extends MokkitAnimals implements Cow {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitCow(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Cow", location, uuid, 10.0);
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
    protected MokkitCow(final @NonNull MokkitServer server, final @NonNull String name,
                        final @NonNull Location location, final @NonNull UUID uuid, final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public EntityType getType() {
        return EntityType.COW;
    }
}
