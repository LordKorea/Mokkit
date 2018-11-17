package de.fuchspfoten.mokkit.entity.projectile.arrow;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TippedArrow;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

/**
 * @see org.bukkit.entity.TippedArrow
 */
public class MokkitTippedArrow extends MokkitArrow implements TippedArrow {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    public MokkitTippedArrow(final @NonNull MokkitServer server, final @NonNull Location location,
                             final @NonNull UUID uniqueId) {
        super(server, "TippedArrow", location, uniqueId);
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
    public EntityType getType() {
        return EntityType.TIPPED_ARROW;
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
