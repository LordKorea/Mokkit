package de.fuchspfoten.mokkit.entity.projectile.potion;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LingeringPotion;

import java.util.UUID;

/**
 * @see org.bukkit.entity.LingeringPotion
 */
public class MokkitLingeringPotion extends MokkitThrownPotion implements LingeringPotion {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitLingeringPotion(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "LingeringPotion", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.LINGERING_POTION;
    }
}
