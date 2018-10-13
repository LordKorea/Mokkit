package de.fuchspfoten.mokkit.entity.living;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @see org.bukkit.entity.LivingEntity
 */
public abstract class MokkitLivingEntity extends MokkitEntity implements LivingEntity {

    /**
     * The default max health.
     */
    private final double defaultMaxHealth;

    /**
     * The max health of the entity.
     */
    private @Getter @Setter double maxHealth;

    /**
     * The health of the entity.
     */
    private @Getter @Setter double health;

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitLivingEntity(final MokkitServer server, final String name, final Location location, final UUID uuid,
                              final double defaultMaxHealth) {
        super(server, name, location, uuid);
        this.defaultMaxHealth = defaultMaxHealth;
        maxHealth = defaultMaxHealth;
        health = defaultMaxHealth;
    }

    @Override
    public void resetMaxHealth() {
        maxHealth = defaultMaxHealth;
    }

    @Override
    public void damage(final double amount) {
        damage(amount, null);
    }

    @Override
    public void damage(final double amount, final Entity source) {
        // TODO what do we do with the source?
        health -= amount;
        if (isDead()) {
            // TODO drops, exp
            final EntityDeathEvent event = new EntityDeathEvent(this, Collections.emptyList(), 0);
            getServer().getPluginManager().callEvent(event);

            // Ensure cancelling isn't possible with tricks, either.
            health = -1.0;
        }
    }

    @Override
    public double getEyeHeight() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getEyeHeight(final boolean ignorePose) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getEyeLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Block> getLineOfSight(final Set<Material> transparent, final int maxDistance) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getTargetBlock(final Set<Material> transparent, final int maxDistance) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(final Set<Material> transparent, final int maxDistance) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getRemainingAir() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRemainingAir(final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaximumAir() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaximumAir(final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaximumNoDamageTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMaximumNoDamageTicks(final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getLastDamage() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLastDamage(final double damage) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getNoDamageTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setNoDamageTicks(final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getKiller() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean addPotionEffect(final PotionEffect effect) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean addPotionEffect(final PotionEffect effect, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean addPotionEffects(final Collection<PotionEffect> effects) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasPotionEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PotionEffect getPotionEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removePotionEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasLineOfSight(final Entity other) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRemoveWhenFarAway(final boolean remove) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityEquipment getEquipment() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getCanPickupItems() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCanPickupItems(final boolean pickup) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isLeashed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setLeashHolder(final Entity holder) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isGliding() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setGliding(final boolean gliding) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAI(final boolean ai) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasAI() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isCollidable() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCollidable(final boolean collidable) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public AttributeInstance getAttribute(final Attribute attribute) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Projectile> T launchProjectile(final Class<? extends T> projectile) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Projectile> T launchProjectile(final Class<? extends T> projectile, final Vector velocity) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Get the control object.
     *
     * @return The control object.
     */
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    public class Mokkit {

        /**
         * Protected constructor to prevent outside instance creation.
         */
        protected Mokkit() {
        }

        /**
         * Attempts to attack a target.
         *
         * @param target     The target.
         * @param damageDone The damage that is to be done.
         */
        public void attackLiving(final LivingEntity target, final double damageDone) throws CancelledByEventException {
            attackLiving(target, damageDone, EntityDamageEvent.DamageCause.ENTITY_ATTACK);
        }

        /**
         * Attempts to attack a target.
         *
         * @param target     The target.
         * @param damageDone The damage that is to be done.
         * @param cause      The cause of the damage done.
         */
        public void attackLiving(final LivingEntity target, final double damageDone,
                                 final EntityDamageEvent.DamageCause cause) throws CancelledByEventException {
            // Attempt damaging the target.
            final EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(MokkitLivingEntity.this,
                    target, cause, damageDone);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Damage the target.
            target.damage(damageDone);
        }

        /**
         * Damages an entity. If the entity has health, the damage done is 1 damage point.
         *
         * @param target The target.
         */
        public void damageEntity(final Entity target) throws CancelledByEventException {
            if (target instanceof LivingEntity) {
                attackLiving((LivingEntity) target, 1.0, EntityDamageEvent.DamageCause.ENTITY_ATTACK);
            } else {
                ((MokkitEntity) target).onDamaged(MokkitLivingEntity.this, 1.0);
            }
        }
    }
}