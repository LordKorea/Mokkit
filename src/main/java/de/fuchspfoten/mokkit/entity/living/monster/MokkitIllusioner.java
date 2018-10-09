package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Illusioner;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Illusioner
 */
public class MokkitIllusioner extends MokkitSpellcaster implements Illusioner {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitIllusioner(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Illusioner", location, uuid, 32.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.ILLUSIONER;
    }
}
