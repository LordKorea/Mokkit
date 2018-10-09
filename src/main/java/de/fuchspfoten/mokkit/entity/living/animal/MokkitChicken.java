package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Chicken
 */
public class MokkitChicken extends MokkitAnimals implements Chicken {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitChicken(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Chicken", location, uuid, 4.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.CHICKEN;
    }
}
