package de.fuchspfoten.mokkit.entity.projectile.potion;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.SplashPotion;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @see org.bukkit.entity.SplashPotion
 */
public class MokkitSplashPotion extends MokkitThrownPotion implements SplashPotion {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitSplashPotion(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "SplashPotion", location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.SPLASH_POTION;
    }

    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    public class Mokkit extends MokkitThrownPotion.Mokkit {

        @Override
        public void hitTarget(final Entity target) {
            splash();
        }

        /**
         * Causes the potion to splash.
         */
        public void splash() {
            final Map<LivingEntity, Double> intensityMap = new HashMap<>();
            for (final Entity entity : getWorld().getNearbyEntities(getLocation(), 5.0, 5.0, 5.0)) {
                if (entity instanceof LivingEntity) {
                    final double distanceInverse = 75 - entity.getLocation().distanceSquared(getLocation());
                    final double invDistNormal = distanceInverse / 75.0;
                    intensityMap.put((LivingEntity) entity, invDistNormal);
                }
            }

            final PotionSplashEvent event = new PotionSplashEvent(MokkitSplashPotion.this, intensityMap);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Apply the effects.
            for (final PotionEffect effect : getEffects()) {
                for (final Map.Entry<LivingEntity, Double> entry : intensityMap.entrySet()) {
                    final PotionEffect scaled = new PotionEffect(effect.getType(),
                            (int) (effect.getDuration() * entry.getValue()), effect.getAmplifier(), effect.isAmbient(),
                            effect.hasParticles(), effect.getColor());
                    entry.getKey().addPotionEffect(scaled);
                }
            }

            remove();
        }
    }
}
