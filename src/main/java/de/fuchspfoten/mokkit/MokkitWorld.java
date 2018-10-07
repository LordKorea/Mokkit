package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @see org.bukkit.World
 */
public class MokkitWorld implements World {

    /**
     * The name of the world.
     */
    private @Getter final String name;

    /**
     * The loaded chunks of the world.
     */
    private final Map<MokkitChunkCoordinate, Chunk> loadedChunks = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name The name of the world.
     */
    public MokkitWorld(final String name) {
        this.name = name;
    }

    @Override
    public Block getBlockAt(final int x, final int y, final int z) {
        final Chunk chunk = getChunkAt(x >> 4, z >> 4);
        final int chunkXOff = (x >> 4) * 16;
        final int chunkZOff = (z >> 4) * 16;
        return chunk.getBlock(x - chunkXOff, y, z - chunkZOff);
    }

    @Override
    public Block getBlockAt(final Location location) {
        return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public Chunk getChunkAt(final Location location) {
        return getChunkAt(location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }

    @Override
    public Chunk getChunkAt(final int x, final int z) {
        final MokkitChunkCoordinate coord = new MokkitChunkCoordinate(x, z);
        if (!loadedChunks.containsKey(coord)) {
            loadChunk(coord.getX(), coord.getZ());
        }
        return loadedChunks.get(coord);
    }

    @Override
    public Chunk getChunkAt(final Block block) {
        return getChunkAt(block.getLocation());
    }

    @Override
    public void loadChunk(final int x, final int z) {
        loadChunk(x, z, true);
    }

    @Override
    public boolean loadChunk(final int x, final int z, final boolean generate) {
        final MokkitChunkCoordinate coord = new MokkitChunkCoordinate(x, z);
        if (loadedChunks.containsKey(coord)) {
            return true;
        }

        // Create the chunk.
        if (!generate) {
            loadedChunks.put(coord, new MokkitChunk(this, x, z));
        } else {
            loadedChunks.put(coord, new MokkitSuperflatChunk(this, x, z));
        }
        return true;
    }

    @Override
    public int getMaxHeight() {
        return 256;
    }

    @Override
    public int getBlockTypeIdAt(final int x, final int y, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getBlockTypeIdAt(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getHighestBlockYAt(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getHighestBlockYAt(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getHighestBlockAt(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getHighestBlockAt(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isChunkLoaded(final Chunk chunk) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Chunk[] getLoadedChunks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void loadChunk(final Chunk chunk) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isChunkLoaded(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isChunkInUse(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final Chunk chunk) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final int x, final int z, final boolean save) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunk(final int x, final int z, final boolean save, final boolean safe) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunkRequest(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadChunkRequest(final int x, final int z, final boolean safe) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean regenerateChunk(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean refreshChunk(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Item dropItem(final Location location, final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Item dropItemNaturally(final Location location, final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Arrow spawnArrow(final Location location, final Vector direction, final float speed, final float spread) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Arrow> T spawnArrow(final Location location, final Vector direction, final float speed,
                                          final float spread, final Class<T> clazz) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean generateTree(final Location location, final TreeType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean generateTree(final Location loc, final TreeType type, final BlockChangeDelegate delegate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity spawnEntity(final Location loc, final EntityType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public LightningStrike strikeLightning(final Location loc) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public LightningStrike strikeLightningEffect(final Location loc) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Entity> getEntities() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<LivingEntity> getLivingEntities() {
        // TODO
        throw new UnsupportedMockException();
    }

    @SafeVarargs
    @Override
    public final <T extends Entity> Collection<T> getEntitiesByClass(final Class<T>... classes) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(final Class<T> cls) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(final Class<?>... classes) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Player> getPlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Collection<Entity> getNearbyEntities(final Location location, final double x, final double y,
                                                final double z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public UUID getUID() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getSpawnLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setSpawnLocation(final Location location) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setSpawnLocation(final int x, final int y, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTime(final long time) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getFullTime() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setFullTime(final long time) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasStorm() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStorm(final boolean hasStorm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getWeatherDuration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWeatherDuration(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isThundering() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setThundering(final boolean thundering) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getThunderDuration() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setThunderDuration(final int duration) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final double x, final double y, final double z, final float power) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final double x, final double y, final double z, final float power,
                                   final boolean setFire) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final double x, final double y, final double z, final float power,
                                   final boolean setFire, final boolean breakBlocks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final Location loc, final float power) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean createExplosion(final Location loc, final float power, final boolean setFire) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Environment getEnvironment() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getSeed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getPVP() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setPVP(final boolean pvp) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ChunkGenerator getGenerator() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void save() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<BlockPopulator> getPopulators() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Entity> T spawn(final Location location, final Class<T> clazz) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T extends Entity> T spawn(final Location location, final Class<T> clazz,
                                      final Consumer<T> function) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public FallingBlock spawnFallingBlock(final Location location,
                                          final MaterialData data) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public FallingBlock spawnFallingBlock(final Location location, final Material material,
                                          final byte data) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public FallingBlock spawnFallingBlock(final Location location, final int blockId,
                                          final byte blockData) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playEffect(final Location location, final Effect effect, final int data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void playEffect(final Location location, final Effect effect, final int data, final int radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void playEffect(final Location location, final Effect effect, final T data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public <T> void playEffect(final Location location, final Effect effect, final T data, final int radius) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(final int x, final int z, final boolean includeBiome,
                                               final boolean includeBiomeTempRain) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSpawnFlags(final boolean allowMonsters, final boolean allowAnimals) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowAnimals() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowMonsters() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Biome getBiome(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBiome(final int x, final int z, final Biome bio) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getTemperature(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getHumidity(final int x, final int z) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getSeaLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setKeepSpawnInMemory(final boolean keepLoaded) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isAutoSave() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAutoSave(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Difficulty getDifficulty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDifficulty(final Difficulty difficulty) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public File getWorldFolder() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public WorldType getWorldType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean canGenerateStructures() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTicksPerAnimalSpawns(final int ticksPerAnimalSpawns) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setTicksPerMonsterSpawns(final int ticksPerMonsterSpawns) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMonsterSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMonsterSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getAnimalSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAnimalSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWaterAnimalSpawnLimit(final int limit) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getAmbientSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setAmbientSpawnLimit(final int limit) {
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
    public String[] getGameRules() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getGameRuleValue(final String rule) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setGameRuleValue(final String rule, final String value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isGameRule(final String rule) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public WorldBorder getWorldBorder() {
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
    public Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
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
}
