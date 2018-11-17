package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Endermite
 */
public class MokkitEndermite extends MokkitMonster implements Endermite {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitEndermite(final @NonNull MokkitServer server, final @NonNull Location location,
                           final @NonNull UUID uuid) {
        super(server, "Endermite", location, uuid, 8.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDERMITE;
    }
}
