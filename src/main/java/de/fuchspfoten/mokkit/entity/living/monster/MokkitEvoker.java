package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Evoker
 */
public class MokkitEvoker extends MokkitSpellcaster implements Evoker {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitEvoker(final @NonNull MokkitServer server, final @NonNull Location location,
                        final @NonNull UUID uuid) {
        super(server, "Evoker", location, uuid, 24.0);
    }

    @Override
    public Evoker.Spell getCurrentSpell() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCurrentSpell(final Evoker.Spell spell) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.EVOKER;
    }
}
