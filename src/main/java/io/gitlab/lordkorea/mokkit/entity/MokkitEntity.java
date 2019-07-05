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

package io.gitlab.lordkorea.mokkit.entity;

import io.gitlab.lordkorea.mokkit.CancelledByEventException;
import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.MokkitWorld;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import io.gitlab.lordkorea.mokkit.scheduler.TickListener;
import io.gitlab.lordkorea.mokkit.scheduler.Tickable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @see org.bukkit.entity.Entity
 */
public abstract class MokkitEntity implements Entity, Tickable {

    /**
     * The server this entity is in.
     */
    private @Getter final MokkitServer server;

    /**
     * The name of the entity.
     */
    private @Getter final String name;

    /**
     * The unique ID of the entity.
     */
    private @Getter final UUID uniqueId;

    /**
     * The messages this entity received.
     */
    private final List<String> receivedMessages = new ArrayList<>();

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The location where the entity is at.
     */
    protected Location location;

    /**
     * Whether or not the entity is despawned for some reason.
     */
    protected boolean despawned = false;

    /**
     * The velocity of the entity.
     */
    private @Getter @Setter Vector velocity;

    /**
     * Whether the entity is a server operator.
     */
    private @Getter @Setter boolean op;

    /**
     * Whether the entity is dead.
     */
    private @Getter boolean dead;

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uniqueId The UUID of the entity.
     */
    protected MokkitEntity(final @NonNull MokkitServer server, final @NonNull String name,
                           final @NonNull Location location, final @NonNull UUID uniqueId) {
        this.server = server;
        this.name = name;
        this.location = location;
        this.uniqueId = uniqueId == null ? UUID.randomUUID() : uniqueId;
    }

    /**
     * Called when this entity is damaged.
     * <p>
     * This method is part of the control interface and throws {@link CancelledByEventException}s when events are
     * cancelled.
     *
     * @param damager The damaging entity.
     * @return The actual damage.
     */
    public double onDamaged(final @NonNull Entity damager, final double damage) {
        final EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(damager, this,
                DamageCause.ENTITY_ATTACK, damage);
        server.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            throw new CancelledByEventException(event);
        }
        return event.getDamage();
    }

    @Override
    public String getCustomName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCustomName(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getLocation() {
        return getLocation(new Location(null, 0, 0, 0));
    }

    @Override
    public Location getLocation(final Location loc) {
        if (loc != null) {
            loc.setX(location.getX());
            loc.setY(location.getY());
            loc.setZ(location.getZ());
            loc.setWorld(location.getWorld());
            loc.setPitch(location.getPitch());
            loc.setYaw(location.getYaw());
        }
        return loc;
    }

    @Override
    public double getHeight() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getWidth() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isOnGround() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public World getWorld() {
        return location.getWorld();
    }

    @Override
    public boolean teleport(final @NonNull Location location) {
        return teleport(location, TeleportCause.UNKNOWN);
    }

    @Override
    public boolean teleport(final @NonNull Location location, final @NonNull TeleportCause cause) {
        final EntityTeleportEvent tp = new EntityTeleportEvent(this, getLocation().clone(), location.clone());
        server.getPluginManager().callEvent(tp);
        if (tp.isCancelled()) {
            return false;
        }

        // Perform the teleport.
        this.location = tp.getTo().clone();
        MokkitWorld.updateWorldsForEntity(this);
        return true;
    }

    @Override
    public boolean teleport(final @NonNull Entity destination) {
        return teleport(destination.getLocation(), TeleportCause.UNKNOWN);
    }

    @Override
    public boolean teleport(final @NonNull Entity destination, final @NonNull TeleportCause cause) {
        return teleport(destination.getLocation(), cause);
    }

    @Override
    public List<Entity> getNearbyEntities(final double x, final double y, final double z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getEntityId() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getFireTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMaxFireTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFireTicks(final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void remove() {
        dead = true;
        MokkitWorld.updateWorldsForEntity(this);
    }

    @Override
    public boolean isValid() {
        return !despawned && !dead;
    }

    @Override
    public Entity getPassenger() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setPassenger(final Entity passenger) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Entity> getPassengers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean addPassenger(final Entity passenger) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removePassenger(final Entity passenger) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isEmpty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean eject() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getFallDistance() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFallDistance(final float distance) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isPermissionSet(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isPermissionSet(final Permission perm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasPermission(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasPermission(final Permission perm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin plugin, final String name, final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin plugin) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin plugin, final String name, final boolean value,
                                              final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PermissionAttachment addAttachment(final Plugin plugin, final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeAttachment(final PermissionAttachment attachment) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void recalculatePermissions() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Getter for the control object.
     *
     * @return The control object.
     */
    @Override
    public Mokkit mokkit() {
        return mokkit;
    }

    @Override
    public void sendMessage(final @NonNull String message) {
        // Store the message.
        receivedMessages.add(message);
    }

    @Override
    public void sendMessage(final String[] messages) {
        for (final String message : messages) {
            sendMessage(message);
        }
    }

    @Override
    public void setMetadata(final String metadataKey, final MetadataValue newMetadataValue) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<MetadataValue> getMetadata(final String metadataKey) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasMetadata(final String metadataKey) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeMetadata(final String metadataKey, final Plugin owningPlugin) {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Control object class.
     */
    public class Mokkit implements TickListener {

        /**
         * Clears the chat log for this entity.
         */
        public void clearChatLog() {
            receivedMessages.clear();
        }

        /**
         * Get the last received message.
         *
         * @return The last received message.
         */
        public String getLastReceivedMessage() {
            if (receivedMessages.isEmpty()) {
                return null;
            }
            return receivedMessages.get(receivedMessages.size() - 1);
        }

        /**
         * Checks whether or not the player received a message that contains the given string.
         *
         * @param content The string.
         * @return Whether the player has such a message.
         */
        public boolean hasMessageLike(final @NonNull CharSequence content) {
            for (final String msg : receivedMessages) {
                if (msg.contains(content)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void tick(final long tick) {
        }
    }

    @Override
    public boolean addScoreboardTag(final String tag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLastDamageCause(final EntityDamageEvent event) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getPortalCooldown() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPortalCooldown(final int cooldown) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<String> getScoreboardTags() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getTicksLived() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTicksLived(final int value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public EntityType getType() {
        throw new UnsupportedOperationException("subclasses must handle their entity type");
    }

    @Override
    public Entity getVehicle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasGravity() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isCustomNameVisible() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCustomNameVisible(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isGlowing() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setGlowing(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isInsideVehicle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isInvulnerable() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setInvulnerable(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSilent() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSilent(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean leaveVehicle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playEffect(final EntityEffect type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean removeScoreboardTag(final String tag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setGravity(final boolean gravity) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }
}
