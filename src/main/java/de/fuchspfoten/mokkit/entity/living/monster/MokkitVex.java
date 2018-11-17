package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vex;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Vex
 */
public class MokkitVex extends MokkitMonster implements Vex {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitVex(final @NonNull MokkitServer server, final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, "Vex", location, uuid, 14.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.VEX;
    }
}
