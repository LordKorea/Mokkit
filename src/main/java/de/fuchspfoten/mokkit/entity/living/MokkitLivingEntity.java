/*
 * Copyright (c) 2018.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.fuchspfoten.mokkit.entity.living;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
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
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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
     * The potion effects of the entity.
     */
    private final Collection<PotionEffect> potionEffects = new HashSet<>();

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The max health of the entity.
     */
    private @Getter @Setter double maxHealth;

    /**
     * The health of the entity.
     */
    private @Getter @Setter double health;

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitLivingEntity(final @NonNull MokkitServer server, final @NonNull String name,
                                 final @NonNull Location location, final @NonNull UUID uuid,
                                 final double defaultMaxHealth) {
        super(server, name, location, uuid);
        this.defaultMaxHealth = defaultMaxHealth;
        maxHealth = defaultMaxHealth;
        health = defaultMaxHealth;
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
    public void resetMaxHealth() {
        maxHealth = defaultMaxHealth;
    }

    @Override
    public AttributeInstance getAttribute(final Attribute attribute) {
        // TODO
        throw new UnsupportedMockException();
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
    public boolean addPotionEffect(final @NonNull PotionEffect effect) {
        if (hasPotionEffect(effect.getType())) {
            return false;
        }
        return addPotionEffect(effect, true);
    }

    @Override
    public boolean addPotionEffect(final @NonNull PotionEffect effect, final boolean force) {
        removePotionEffect(effect.getType());
        potionEffects.add(effect);
        return true;
    }

    @Override
    public boolean addPotionEffects(final @NonNull Collection<PotionEffect> effects) {
        boolean result = true;
        for (final PotionEffect effect : effects) {
            result = result && addPotionEffect(effect);
        }
        return result;
    }

    @Override
    public boolean hasPotionEffect(final @NonNull PotionEffectType type) {
        return potionEffects.stream().anyMatch(e -> e.getType().equals(type));
    }

    @Override
    public PotionEffect getPotionEffect(final @NonNull PotionEffectType type) {
        return potionEffects.stream().filter(e -> e.getType().equals(type)).findAny().orElse(null);
    }

    @Override
    public void removePotionEffect(final @NonNull PotionEffectType type) {
        potionEffects.removeIf(e -> e.getType().equals(type));
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        return Collections.unmodifiableCollection(potionEffects);
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
    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitEntity.Mokkit {

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
        public void attackLiving(final @NonNull LivingEntity target, final double damageDone)
                throws CancelledByEventException {
            attackLiving(target, damageDone, DamageCause.ENTITY_ATTACK);
        }

        /**
         * Attempts to attack a target.
         *
         * @param target     The target.
         * @param damageDone The damage that is to be done.
         * @param cause      The cause of the damage done.
         */
        public void attackLiving(final @NonNull LivingEntity target, final double damageDone,
                                 final @NonNull DamageCause cause) throws CancelledByEventException {
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
        public void damageEntity(final @NonNull Entity target) throws CancelledByEventException {
            if (target instanceof LivingEntity) {
                attackLiving((LivingEntity) target, 1.0, DamageCause.ENTITY_ATTACK);
            } else {
                ((MokkitEntity) target).onDamaged(MokkitLivingEntity.this, 1.0);
            }
        }
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
    public Entity getLeashHolder() throws IllegalStateException {
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
    public boolean isLeashed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAI(final boolean ai) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setLeashHolder(final Entity holder) {
        // TODO
        throw new UnsupportedMockException();
    }
}
