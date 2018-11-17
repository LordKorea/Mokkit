package de.fuchspfoten.mokkit.entity.living.boss;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitMonster;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Wither
 */
public class MokkitWither extends MokkitMonster implements Wither {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitWither(final @NonNull MokkitServer server, final @NonNull Location location,
                        final @NonNull UUID uuid) {
        super(server, "Wither", location, uuid, 300.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.WITHER;
    }
}
