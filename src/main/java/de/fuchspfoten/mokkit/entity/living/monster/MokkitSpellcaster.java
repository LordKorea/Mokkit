package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.Spellcaster;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Spellcaster
 */
public abstract class MokkitSpellcaster extends MokkitIllager implements Spellcaster {

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitSpellcaster(final MokkitServer server, final String name, final Location location, final UUID uuid,
                             final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public Spell getSpell() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSpell(final Spell spell) {
        // TODO
        throw new UnsupportedMockException();
    }
}
