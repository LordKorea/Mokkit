package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Witch;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Witch
 */
public class MokkitWitch extends MokkitMonster implements Witch {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitWitch(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Witch", location, uuid, 26.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.WITCH;
    }
}
