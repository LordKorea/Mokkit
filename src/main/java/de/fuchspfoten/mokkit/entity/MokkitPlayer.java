package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.CancelledByEventException;
import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
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
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.map.MapView;
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
    public MokkitPlayer(final MokkitServer server, final String name, final Location location, final UUID uuid) {
        super(server, name, location, uuid);
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
    public InetSocketAddress getAddress() {
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
    public void sendRawMessage(final String message) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void kickPlayer(final String message) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void chat(final String msg) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean performCommand(final String command) {
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
    public void saveData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void loadData() {
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
    public void sendBlockChange(final Location loc, final Material material, final byte data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean sendChunkChange(final Location loc, final int sx, final int sy, final int sz, final byte[] data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendBlockChange(final Location loc, final int material, final byte data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendSignChange(final Location loc, final String[] lines) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void sendMap(final MapView map) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void updateInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void awardAchievement(final Achievement achievement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeAchievement(final Achievement achievement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasAchievement(final Achievement achievement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic, final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic, final int amount) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStatistic(final Statistic statistic, final int newValue) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStatistic(final Statistic statistic) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void incrementStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void decrementStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
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
    public void decrementStatistic(final Statistic statistic, final Material material,
                                   final int amount) throws IllegalArgumentException {
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
    public void incrementStatistic(final Statistic statistic,
                                   final EntityType entityType) throws IllegalArgumentException {
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
    public int getStatistic(final Statistic statistic, final EntityType entityType) throws IllegalArgumentException {
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
    public void decrementStatistic(final Statistic statistic, final EntityType entityType, final int amount) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStatistic(final Statistic statistic, final EntityType entityType, final int newValue) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPlayerTime(final long time, final boolean relative) {
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
    public boolean isPlayerTimeRelative() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void resetPlayerTime() {
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
    public void resetPlayerWeather() {
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
    public boolean isOnline() {
        // TODO
        throw new UnsupportedMockException();
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
    public void setBedSpawnLocation(final Location location, final boolean force) {
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
    public boolean canSee(final Player player) {
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
    public void setTexturePack(final String url) {
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
    public void resetTitle() {
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
    public AdvancementProgress getAdvancementProgress(final Advancement advancement) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getLocale() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, Object> serialize() {
        // TODO
        throw new UnsupportedMockException();
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
    public Player.Spigot spigot() {
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
    public final class Mokkit {

        /**
         * Attempts to break the given block.
         *
         * @param block The block.
         */
        public void breakBlock(final Block block) throws CancelledByEventException {
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
        }
    }
}
