package de.fuchspfoten.mokkit.entity.projectile.potion;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.projectile.MokkitProjectile;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @see org.bukkit.entity.ThrownPotion
 */
public abstract class MokkitThrownPotion extends MokkitProjectile implements ThrownPotion {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The potion effects of the potion.
     */
    private final Set<PotionEffect> effects = new HashSet<>();

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitThrownPotion(final MokkitServer server, final String name, final Location location,
                              final UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public Collection<PotionEffect> getEffects() {
        return Collections.unmodifiableCollection(effects);
    }

    @Override
    public ItemStack getItem() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItem(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Fetches the control object.
     *
     * @return The control object.
     */
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * The class for the control object.
     */
    public class Mokkit extends MokkitProjectile.Mokkit {

        /**
         * Adds the given effect to the potion, overwriting existing effects.
         *
         * @param effect The effect.
         */
        public void addEffect(final PotionEffect effect) {
            effects.removeIf(e -> e.getType().equals(effect.getType()));
            effects.add(effect);
        }
    }
}
