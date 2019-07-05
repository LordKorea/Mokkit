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

package io.gitlab.lordkorea.mokkit.entity.living.human;

import io.gitlab.lordkorea.mokkit.CancelledByEventException;
import io.gitlab.lordkorea.mokkit.MokkitServer;
import io.gitlab.lordkorea.mokkit.MokkitWorld;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @see org.bukkit.entity.Player
 */
public class MokkitPlayer extends MokkitHumanEntity implements Player {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitPlayer(final @NonNull MokkitServer server, final @NonNull String name,
                        final @NonNull Location location, final @NonNull UUID uuid) {
        super(server, name, location, uuid);
    }

    /**
     * Despawns this player.
     */
    public void despawn() {
        despawned = true;
        MokkitWorld.updateWorldsForEntity(this);
    }

    @Override
    public String getDisplayName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDisplayName(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getPlayerListName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPlayerListName(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isConversing() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void acceptConversationInput(final String input) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean beginConversation(final Conversation conversation) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void abandonConversation(final Conversation conversation) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void abandonConversation(final Conversation conversation, final ConversationAbandonedEvent details) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isOnline() {
        return true;
    }

    @Override
    public boolean isBanned() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isWhitelisted() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWhitelisted(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getPlayer() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getFirstPlayed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getLastPlayed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasPlayedBefore() {
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

    @Override
    public void sendPluginMessage(final Plugin source, final String channel, final byte[] message) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, Object> serialize() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean teleport(final @NonNull Location location, final @NonNull TeleportCause cause) {
        final PlayerTeleportEvent tp = new PlayerTeleportEvent(this, getLocation().clone(), location.clone(),
                cause);
        getServer().getPluginManager().callEvent(tp);
        if (tp.isCancelled()) {
            return false;
        }

        // Perform the teleport.
        this.location = tp.getTo().clone();
        MokkitWorld.updateWorldsForEntity(this);
        return true;
    }

    @Override
    public EntityType getType() {
        return EntityType.PLAYER;
    }

    @Override
    public Player.Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Class for the control object.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    public class Mokkit extends MokkitHumanEntity.Mokkit {

        /**
         * Protected constructor to prevent outside instance creation.
         */
        protected Mokkit() {
        }

        /**
         * Attempts to break the given block.
         *
         * @param block The block.
         */
        public void breakBlock(final @NonNull Block block) throws CancelledByEventException {
            // Start damaging the block.
            final BlockDamageEvent blockDamageEvent = new BlockDamageEvent(MokkitPlayer.this, block,
                    getInventory().getItemInMainHand(), getGameMode() == GameMode.CREATIVE);
            getServer().getPluginManager().callEvent(blockDamageEvent);
            if (blockDamageEvent.isCancelled()) {
                throw new CancelledByEventException(blockDamageEvent);
            }

            // Break the block.
            final BlockBreakEvent blockBreakEvent = new BlockBreakEvent(block, MokkitPlayer.this);
            getServer().getPluginManager().callEvent(blockBreakEvent);
            if (blockBreakEvent.isCancelled()) {
                throw new CancelledByEventException(blockBreakEvent);
            }

            // Destroy the block.
            block.setType(Material.AIR);

            // TODO: durability of tools.
        }

        /**
         * Attempts to interact with an entity.
         *
         * @param who The entity.
         */
        public void interactWith(final @NonNull Entity who) throws CancelledByEventException {
            interactWith(who, EquipmentSlot.HAND);
        }

        /**
         * Attempts to interact with an entity.
         *
         * @param who  The entity.
         * @param hand The hand that is used for interacting.
         */
        public void interactWith(final @NonNull Entity who, final @NonNull EquipmentSlot hand)
                throws CancelledByEventException {
            final PlayerInteractEntityEvent event = new PlayerInteractEntityEvent(MokkitPlayer.this, who, hand);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // TODO use hand?
        }

        /**
         * Manipulates an armor stand.
         *
         * @param who  The armor stand.
         * @param slot The clicked slot.
         */
        public void manipulateArmorStand(final @NonNull ArmorStand who, final @NonNull EquipmentSlot slot)
                throws CancelledByEventException {
            final ItemStack armorStandItem;
            switch (slot) {
                case HAND:
                    armorStandItem = who.getItemInHand();
                    break;
                case FEET:
                    armorStandItem = who.getBoots();
                    break;
                case LEGS:
                    armorStandItem = who.getLeggings();
                    break;
                case CHEST:
                    armorStandItem = who.getChestplate();
                    break;
                case HEAD:
                    armorStandItem = who.getHelmet();
                    break;
                case OFF_HAND:
                    throw new IllegalArgumentException("armor stand can not have item in off hand");
                default:
                    throw new IllegalArgumentException("invalid equipment slot");
            }
            final PlayerArmorStandManipulateEvent event = new PlayerArmorStandManipulateEvent(MokkitPlayer.this,
                    who, getInventory().getItemInMainHand(), armorStandItem, slot);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Re-fetch possibly changed item and swap.
            // TODO: Change if setting item works! (e.g. no blocks as chestplate)
            final ItemStack newPlayerItem = getInventory().getItemInMainHand();
            final ItemStack tmp;
            switch (slot) {
                case HAND:
                    tmp = who.getItemInHand();
                    who.setItemInHand(newPlayerItem);
                    break;
                case FEET:
                    tmp = who.getBoots();
                    who.setBoots(newPlayerItem);
                    break;
                case LEGS:
                    tmp = who.getLeggings();
                    who.setLeggings(newPlayerItem);
                    break;
                case CHEST:
                    tmp = who.getChestplate();
                    who.setChestplate(newPlayerItem);
                    break;
                case HEAD:
                    tmp = who.getHelmet();
                    who.setHelmet(newPlayerItem);
                    break;
                case OFF_HAND:
                    throw new IllegalArgumentException("armor stand can not have item in off hand");
                default:
                    throw new IllegalArgumentException("invalid equipment slot");
            }
            getInventory().setItemInMainHand(tmp);
        }

        /**
         * Attempts to simulate a right click on a block.
         *
         * @param block The block.
         */
        public void rightClickBlock(final @NonNull Block block, final @NonNull BlockFace clickedFace) {
            if (getInventory().getItemInMainHand() != null && getInventory().getItemInOffHand() != null) {
                throw new UnsupportedMockException();
            }

            // Determine the hand and the item that is used.
            final EquipmentSlot slot;
            final ItemStack usedItem;
            if (getInventory().getItemInOffHand() == null) {
                slot = EquipmentSlot.HAND;
                usedItem = getInventory().getItemInMainHand();
            } else {
                slot = EquipmentSlot.OFF_HAND;
                usedItem = getInventory().getItemInOffHand();
            }

            // Block placing.
            // TODO does this trigger a PlayerInteractEvent?
            if (usedItem != null && usedItem.getType().isBlock()) {
                final Block targetBlock = block.getRelative(clickedFace);
                // TODO replacing grass etc.
                if (targetBlock.getType() == Material.AIR) {
                    placeBlock(targetBlock, usedItem.getData(), block, slot);
                    consumeItemInMainHand();
                    return;
                }
            }

            // Painting placing.
            // TODO does this trigger a PlayerInteractEvent?
            if (usedItem != null && usedItem.getType() == Material.PAINTING) {
                final Block targetBlock = block.getRelative(clickedFace);
                if (targetBlock.getType() == Material.AIR) {
                    placePainting(block, clickedFace);
                    consumeItemInMainHand();
                    return;
                }
            }

            // Filling buckets.
            // TODO does this trigger a PlayerInteractEvent?
            if (usedItem != null && usedItem.getType() == Material.BUCKET) {
                final Material targetBucket;
                switch (block.getType()) {
                    case WATER:
                    case STATIONARY_WATER:
                        targetBucket = Material.WATER_BUCKET;
                        break;
                    case LAVA:
                    case STATIONARY_LAVA:
                        targetBucket = Material.LAVA_BUCKET;
                        break;
                    default:
                        targetBucket = null;
                        break;
                }

                if (targetBucket != null) {
                    fillBucket(block, new ItemStack(targetBucket), slot);
                    return;
                }
            }

            // Emptying buckets.
            // TODO does this trigger a PlayerInteractEvent?
            if (usedItem != null) {
                final Block targetBlock = block.getRelative(clickedFace);
                final Material targetLiquid;
                switch (usedItem.getType()) {
                    case WATER_BUCKET:
                        targetLiquid = Material.WATER;
                        break;
                    case LAVA_BUCKET:
                        targetLiquid = Material.LAVA;
                        break;
                    default:
                        targetLiquid = null;
                        break;
                }

                // TODO replacing grass etc.
                if (targetLiquid != null && targetBlock.getType() == Material.AIR) {
                    emptyBucket(targetBlock, block, clickedFace, usedItem.getType(), targetLiquid, slot);
                    return;
                }
            }

            // Perform a PlayerInteractEvent.
            final Action action =
                    (block.getType() == Material.AIR) ? Action.RIGHT_CLICK_AIR : Action.RIGHT_CLICK_BLOCK;
            final PlayerInteractEvent event = new PlayerInteractEvent(MokkitPlayer.this, action, usedItem, block,
                    clickedFace, slot);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // TODO what else?
            // throw new UnsupportedMockException();
        }

        /**
         * Attempts to empty a bucket.
         *
         * @param where       Where the bucket is to be emptied.
         * @param clicked     The clicked block.
         * @param clickedFace The clicked block face.
         * @param bucket      The used bucket.
         * @param liquid      The liquid that is to be placed.
         * @param hand        The hand that was used.
         */
        protected void emptyBucket(final @NonNull Block where, final @NonNull Block clicked,
                                   final @NonNull BlockFace clickedFace, final @NonNull Material bucket,
                                   final @NonNull Material liquid, final @NonNull EquipmentSlot hand)
                throws CancelledByEventException {
            final PlayerBucketEmptyEvent event = new PlayerBucketEmptyEvent(MokkitPlayer.this, clicked,
                    clickedFace, bucket, new ItemStack(Material.BUCKET));
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Place the liquid.
            where.setType(liquid);

            // Update the hand item.
            if (hand == EquipmentSlot.HAND) {
                getInventory().setItemInMainHand(event.getItemStack());
            } else {
                getInventory().setItemInOffHand(event.getItemStack());
            }
        }

        /**
         * Attempts to fill a bucket.
         *
         * @param where      The liquid block.
         * @param resultItem The bucket that is held after the event.
         * @param hand       The used hand.
         */
        protected void fillBucket(final @NonNull Block where, final @NonNull ItemStack resultItem,
                                  final @NonNull EquipmentSlot hand) throws CancelledByEventException {
            final PlayerBucketFillEvent event = new PlayerBucketFillEvent(MokkitPlayer.this, where, BlockFace.SELF,
                    Material.BUCKET, resultItem);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Remove the liquid.
            where.setType(Material.AIR);

            // Update the hand item.
            if (hand == EquipmentSlot.HAND) {
                getInventory().setItemInMainHand(event.getItemStack());
            } else {
                getInventory().setItemInOffHand(event.getItemStack());
            }
        }

        /**
         * Attempts to place a block.
         *
         * @param where   Where to place something.
         * @param what    What to place.
         * @param clicked The block that was clicked by the player for placing.
         * @param hand    The hand that contained the placed block.
         */
        protected void placeBlock(final @NonNull Block where, final @NonNull MaterialData what,
                                  final @NonNull Block clicked, final @NonNull EquipmentSlot hand)
                throws CancelledByEventException {
            // Take a snapshot of the block before.
            final BlockState beforeState = where.getState();
            final BlockState eventState = where.getState();

            // This event is strange: The block is placed beforehand.
            final BlockState placeState = where.getState();
            placeState.setData(what);
            placeState.update(true, false);

            // Start placing.
            final BlockPlaceEvent blockPlaceEvent = new BlockPlaceEvent(where, eventState, clicked, getItemInHand(),
                    MokkitPlayer.this, true, hand);
            getServer().getPluginManager().callEvent(blockPlaceEvent);
            if (blockPlaceEvent.isCancelled() || !blockPlaceEvent.canBuild()) {
                // Reset the block.
                beforeState.update(true, false);
                throw new CancelledByEventException(blockPlaceEvent);
            }

            // Finish placing by applying physics.
            placeState.update(true, true);
        }

        /**
         * Attempts to place a painting.
         *
         * @param clicked     The clicked block.
         * @param clickedFace The clicked block face.
         */
        protected void placePainting(final @NonNull Block clicked, final @NonNull BlockFace clickedFace)
                throws CancelledByEventException {
            // This event is strange: The painting is placed beforehand.
            final Painting painting = getWorld().spawn(clicked.getRelative(clickedFace).getLocation(), Painting.class);

            // Start placing.
            final HangingPlaceEvent event = new HangingPlaceEvent(painting, MokkitPlayer.this, clicked,
                    clickedFace);
            getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                // Remove the painting as if it never existed.
                painting.remove();
                throw new CancelledByEventException(event);
            }
        }
    }

    @Override
    public InetSocketAddress getAddress() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void chat(final String msg) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void awardAchievement(final Achievement achievement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic, final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic, final Material material,
                                   final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic,
                                   final EntityType entityType) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic, final EntityType entityType, final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean canSee(final Player player) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public AdvancementProgress getAdvancementProgress(final Advancement advancement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowFlight() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAllowFlight(final boolean flight) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getBedSpawnLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBedSpawnLocation(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getCompassTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCompassTarget(final Location loc) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getExhaustion() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setExhaustion(final float value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getExp() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setExp(final float exp) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getFlySpeed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFlySpeed(final float value) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getFoodLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFoodLevel(final int value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getHealthScale() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setHealthScale(final double scale) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setLevel(final int level) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getLocale() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getPlayerTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getPlayerTimeOffset() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public WeatherType getPlayerWeather() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPlayerWeather(final WeatherType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getSaturation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSaturation(final float value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Scoreboard getScoreboard() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setScoreboard(final Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getSpectatorTarget() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSpectatorTarget(final Entity entity) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStatistic(final Statistic statistic) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStatistic(final Statistic statistic, final EntityType entityType) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getTotalExperience() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTotalExperience(final int exp) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public float getWalkSpeed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWalkSpeed(final float value) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void giveExp(final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void giveExpLevels(final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasAchievement(final Achievement achievement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void hidePlayer(final Player player) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void hidePlayer(final Plugin plugin, final Player player) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic, final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic, final Material material,
                                   final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic,
                                   final EntityType entityType) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic, final EntityType entityType,
                                   final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isFlying() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFlying(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isHealthScaled() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setHealthScaled(final boolean scale) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSleepingIgnored() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSleepingIgnored(final boolean isSleeping) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSneaking() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSneaking(final boolean sneak) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSprinting() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSprinting(final boolean sprinting) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void kickPlayer(final String message) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void loadData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean performCommand(final String command) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playEffect(final Location loc, final Effect effect, final int data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void playEffect(final Location loc, final Effect effect, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playNote(final Location loc, final byte instrument, final byte note) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playNote(final Location loc, final Instrument instrument, final Note note) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final Sound sound, final float volume, final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final String sound, final float volume, final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final Sound sound, final SoundCategory category, final float volume,
                          final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playSound(final Location location, final String sound, final SoundCategory category, final float volume,
                          final float pitch) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeAchievement(final Achievement achievement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void resetPlayerTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void resetPlayerWeather() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void resetTitle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void saveData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendBlockChange(final Location loc, final Material material, final byte data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendBlockChange(final Location loc, final int material, final byte data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean sendChunkChange(final Location loc, final int sx, final int sy, final int sz, final byte[] data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendMap(final MapView map) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendRawMessage(final String message) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendSignChange(final Location loc, final String[] lines) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendTitle(final String title, final String subtitle) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendTitle(final String title, final String subtitle, final int fadeIn, final int stay,
                          final int fadeOut) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBedSpawnLocation(final Location location, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPlayerTime(final long time, final boolean relative) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setResourcePack(final String url) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setResourcePack(final String url, final byte[] hash) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStatistic(final Statistic statistic, final int newValue) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStatistic(final Statistic statistic, final Material material,
                             final int newValue) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStatistic(final Statistic statistic, final EntityType entityType, final int newValue) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTexturePack(final String url) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void showPlayer(final Player player) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void showPlayer(final Plugin plugin, final Player player) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final Location location, final int count) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final double x, final double y, final double z,
                              final int count) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final Location location, final int count, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final double x, final double y, final double z,
                                  final int count, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final Location location, final int count, final double offsetX,
                              final double offsetY, final double offsetZ) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final double x, final double y, final double z, final int count,
                              final double offsetX, final double offsetY, final double offsetZ) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final Location location, final int count,
                                  final double offsetX, final double offsetY, final double offsetZ, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final double x, final double y, final double z,
                                  final int count, final double offsetX, final double offsetY, final double offsetZ,
                                  final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final Location location, final int count, final double offsetX,
                              final double offsetY, final double offsetZ, final double extra) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void spawnParticle(final Particle particle, final double x, final double y, final double z, final int count,
                              final double offsetX, final double offsetY, final double offsetZ, final double extra) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final Location location, final int count,
                                  final double offsetX, final double offsetY, final double offsetZ, final double extra,
                                  final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void spawnParticle(final Particle particle, final double x, final double y, final double z,
                                  final int count, final double offsetX, final double offsetY, final double offsetZ,
                                  final double extra, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void stopSound(final Sound sound) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void stopSound(final String sound) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void stopSound(final Sound sound, final SoundCategory category) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void stopSound(final String sound, final SoundCategory category) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void updateInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

}
