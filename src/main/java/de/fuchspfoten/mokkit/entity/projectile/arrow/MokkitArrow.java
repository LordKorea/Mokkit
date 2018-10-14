package de.fuchspfoten.mokkit.entity.projectile.arrow;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.entity.projectile.MokkitProjectile;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Arrow
 */
public class MokkitArrow extends MokkitProjectile implements Arrow {

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
    public MokkitArrow(final MokkitServer server, final Location location, final UUID uniqueId) {
        super(server, "Arrow", location, uniqueId);
    }

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitArrow(final MokkitServer server, final String name, final Location location, final UUID uniqueId) {
        super(server, name, location, uniqueId);
    }

    @Override
    public EntityType getType() {
        return EntityType.ARROW;
    }

    @Override
    public int getKnockbackStrength() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setKnockbackStrength(final int knockbackStrength) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isCritical() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCritical(final boolean critical) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isInBlock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getAttachedBlock() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PickupStatus getPickupStatus() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPickupStatus(final PickupStatus status) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Arrow.Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    /**
     * Class for the control object.
     */
    public class Mokkit extends MokkitProjectile.Mokkit {

        @Override
        public void hitTarget(final Entity target) {
            super.hitTarget(target);

            // TODO how much damage?
            ((MokkitEntity) target).onDamaged(MokkitArrow.this, 1.0);

            // The arrow is now in the player, no longer an entity.
            // TODO confirm this?
            remove();
        }
    }
}
