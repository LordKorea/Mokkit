package de.fuchspfoten.mokkit.entity.misc;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import java.util.List;
import java.util.UUID;

/**
 * @see org.bukkit.entity.AreaEffectCloud
 */
public class MokkitAreaEffectCloud extends MokkitEntity implements AreaEffectCloud {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitAreaEffectCloud(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "AreaEffectCloud", location, uniqueId);
    }

    @Override
    public boolean addCustomEffect(final PotionEffect effect, final boolean overwrite) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void clearCustomEffects() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PotionData getBasePotionData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBasePotionData(final PotionData data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Color getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final Color color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<PotionEffect> getCustomEffects() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getDuration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDuration(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getDurationOnUse() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDurationOnUse(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Particle getParticle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setParticle(final Particle particle) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getRadius() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRadius(final float radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getRadiusOnUse() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRadiusOnUse(final float radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getRadiusPerTick() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRadiusPerTick(final float radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getReapplicationDelay() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setReapplicationDelay(final int delay) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ProjectileSource getSource() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSource(final ProjectileSource source) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        return EntityType.AREA_EFFECT_CLOUD;
    }

    @Override
    public int getWaitTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWaitTime(final int waitTime) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasCustomEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasCustomEffects() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removeCustomEffect(final PotionEffectType type) {
        // TODO
        throw new UnsupportedMockException();
    }
}
