package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.entity.MokkitBat;
import de.fuchspfoten.mokkit.entity.MokkitChicken;
import de.fuchspfoten.mokkit.entity.MokkitCow;
import de.fuchspfoten.mokkit.entity.MokkitDonkey;
import de.fuchspfoten.mokkit.entity.MokkitElderGuardian;
import de.fuchspfoten.mokkit.entity.MokkitEnderman;
import de.fuchspfoten.mokkit.entity.MokkitEvoker;
import de.fuchspfoten.mokkit.entity.MokkitGuardian;
import de.fuchspfoten.mokkit.entity.MokkitHusk;
import de.fuchspfoten.mokkit.entity.MokkitLlama;
import de.fuchspfoten.mokkit.entity.MokkitMule;
import de.fuchspfoten.mokkit.entity.MokkitOcelot;
import de.fuchspfoten.mokkit.entity.MokkitPainting;
import de.fuchspfoten.mokkit.entity.MokkitParrot;
import de.fuchspfoten.mokkit.entity.MokkitPig;
import de.fuchspfoten.mokkit.entity.MokkitPolarBear;
import de.fuchspfoten.mokkit.entity.MokkitRabbit;
import de.fuchspfoten.mokkit.entity.MokkitSheep;
import de.fuchspfoten.mokkit.entity.MokkitSkeleton;
import de.fuchspfoten.mokkit.entity.MokkitSkeletonHorse;
import de.fuchspfoten.mokkit.entity.MokkitSpider;
import de.fuchspfoten.mokkit.entity.MokkitStray;
import de.fuchspfoten.mokkit.entity.MokkitVex;
import de.fuchspfoten.mokkit.entity.MokkitVindicator;
import de.fuchspfoten.mokkit.entity.MokkitWitch;
import de.fuchspfoten.mokkit.entity.MokkitWitherSkeleton;
import de.fuchspfoten.mokkit.entity.MokkitWolf;
import de.fuchspfoten.mokkit.entity.MokkitZombie;
import de.fuchspfoten.mokkit.entity.MokkitZombieHorse;
import de.fuchspfoten.mokkit.entity.MokkitZombieVillager;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import org.bukkit.BlockChangeDelegate;
import org.bukkit.Bukkit;
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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @see org.bukkit.World
 */
public class MokkitWorld implements World {

    /**
     * Updates the worlds for the given entity. Adds the entity to the correct world and removes it from all others.
     *
     * @param entity The entity.
     */
    public static void updateWorldsForEntity(final Entity entity) {
        for (final World world : Bukkit.getWorlds()) {
            assert world instanceof MokkitWorld;
            final MokkitWorld mWorld = (MokkitWorld) world;
            if (mWorld == entity.getWorld() && entity.isValid()) {
                mWorld.entities.add(entity);
            } else {
                mWorld.entities.remove(entity);
            }
        }
    }

    /**
     * The server this world is in.
     */
    private final MokkitServer server;

    /**
     * The name of the world.
     */
    private @Getter final String name;

    /**
     * The loaded chunks of the world.
     */
    private final Map<MokkitChunkCoordinate, Chunk> loadedChunks = new HashMap<>();

    /**
     * The entities in the world.
     */
    private final Set<Entity> entities = new HashSet<>();

    /**
     * Constructor.
     *
     * @param name The name of the world.
     */
    public MokkitWorld(final MokkitServer server, final String name) {
        this.server = server;
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
    public Entity spawnEntity(final Location loc, final EntityType type) {
        return spawn(loc, type.getEntityClass());
    }

    @Override
    public <T extends Entity> T spawn(final Location location, final Class<T> clazz) throws IllegalArgumentException {
        return spawn(location, clazz, t -> {
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Entity> T spawn(final Location location, final Class<T> clazz,
                                      final Consumer<T> function) throws IllegalArgumentException {
        if (location == null || clazz == null || function == null) {
            throw new IllegalArgumentException("location or class null");
        }
        if (location.getWorld() != this) {
            throw new IllegalArgumentException("attempting to spawn in conflicting worlds");
        }

        // Determine the entity type.
        EntityType targetType = null;
        for (final EntityType possible : EntityType.values()) {
            if (possible.getEntityClass() == clazz) {
                targetType = possible;
                break;
            }
        }
        if (targetType == null) {
            throw new IllegalArgumentException("can not find entity for class: " + clazz.getName());
        }

        // Determine whether we can spawn this type.
        switch (targetType) {
            case BAT:
            case CHICKEN:
            case COW:
            case DONKEY:
            case ELDER_GUARDIAN:
            case ENDERMAN:
            case EVOKER:
            case GUARDIAN:
            case HUSK:
            case LLAMA:
            case MULE:
            case OCELOT:
            case PAINTING:
            case PARROT:
            case PIG:
            case POLAR_BEAR:
            case RABBIT:
            case SHEEP:
            case SKELETON:
            case SKELETON_HORSE:
            case SPIDER:
            case STRAY:
            case VEX:
            case VINDICATOR:
            case WITCH:
            case WITHER_SKELETON:
            case WOLF:
            case ZOMBIE:
            case ZOMBIE_HORSE:
            case ZOMBIE_VILLAGER:
                // Supported.
                break;
            case COMPLEX_PART:
            case LIGHTNING:
            case PLAYER:
            case UNKNOWN:
            case WEATHER:
                throw new IllegalArgumentException("can not spawn " + targetType.name());
            case DROPPED_ITEM:
            case EXPERIENCE_ORB:
            case AREA_EFFECT_CLOUD:
            case EGG:
            case LEASH_HITCH:
            case ARROW:
            case SNOWBALL:
            case FIREBALL:
            case SMALL_FIREBALL:
            case ENDER_PEARL:
            case ENDER_SIGNAL:
            case SPLASH_POTION:
            case THROWN_EXP_BOTTLE:
            case ITEM_FRAME:
            case WITHER_SKULL:
            case PRIMED_TNT:
            case FALLING_BLOCK:
            case FIREWORK:
            case SPECTRAL_ARROW:
            case SHULKER_BULLET:
            case DRAGON_FIREBALL:
            case ARMOR_STAND:
            case EVOKER_FANGS:
            case ILLUSIONER:
            case MINECART_COMMAND:
            case BOAT:
            case MINECART:
            case MINECART_CHEST:
            case MINECART_FURNACE:
            case MINECART_TNT:
            case MINECART_HOPPER:
            case MINECART_MOB_SPAWNER:
            case CREEPER:
            case GIANT:
            case SLIME:
            case GHAST:
            case PIG_ZOMBIE:
            case CAVE_SPIDER:
            case SILVERFISH:
            case BLAZE:
            case MAGMA_CUBE:
            case ENDER_DRAGON:
            case WITHER:
            case ENDERMITE:
            case SHULKER:
            case SQUID:
            case MUSHROOM_COW:
            case SNOWMAN:
            case IRON_GOLEM:
            case HORSE:
            case LLAMA_SPIT:
            case VILLAGER:
            case ENDER_CRYSTAL:
            case LINGERING_POTION:
            case FISHING_HOOK:
            case TIPPED_ARROW:
                // Not (yet) supported.
                throw new UnsupportedMockException();
        }

        // Spawn the entity.
        assert clazz == targetType.getEntityClass();
        final T entity;
        switch (targetType) {
            case BAT:
                entity = (T) new MokkitBat(server, location, UUID.randomUUID());
                break;
            case CHICKEN:
                entity = (T) new MokkitChicken(server, location, UUID.randomUUID());
                break;
            case COW:
                entity = (T) new MokkitCow(server, location, UUID.randomUUID());
                break;
            case DONKEY:
                entity = (T) new MokkitDonkey(server, location, UUID.randomUUID());
                break;
            case ELDER_GUARDIAN:
                entity = (T) new MokkitElderGuardian(server, location, UUID.randomUUID());
                break;
            case ENDERMAN:
                entity = (T) new MokkitEnderman(server, location, UUID.randomUUID());
                break;
            case EVOKER:
                entity = (T) new MokkitEvoker(server, location, UUID.randomUUID());
                break;
            case GUARDIAN:
                entity = (T) new MokkitGuardian(server, location, UUID.randomUUID());
                break;
            case HUSK:
                entity = (T) new MokkitHusk(server, location, UUID.randomUUID());
                break;
            case LLAMA:
                entity = (T) new MokkitLlama(server, location, UUID.randomUUID());
                break;
            case MULE:
                entity = (T) new MokkitMule(server, location, UUID.randomUUID());
                break;
            case OCELOT:
                entity = (T) new MokkitOcelot(server, location, UUID.randomUUID());
                break;
            case PAINTING:
                entity = (T) new MokkitPainting(server, location, UUID.randomUUID());
                break;
            case PARROT:
                entity = (T) new MokkitParrot(server, location, UUID.randomUUID());
                break;
            case PIG:
                entity = (T) new MokkitPig(server, location, UUID.randomUUID());
                break;
            case POLAR_BEAR:
                entity = (T) new MokkitPolarBear(server, location, UUID.randomUUID());
                break;
            case SHEEP:
                entity = (T) new MokkitSheep(server, location, UUID.randomUUID());
                break;
            case SKELETON:
                entity = (T) new MokkitSkeleton(server, location, UUID.randomUUID());
                break;
            case SKELETON_HORSE:
                entity = (T) new MokkitSkeletonHorse(server, location, UUID.randomUUID());
                break;
            case SPIDER:
                entity = (T) new MokkitSpider(server, location, UUID.randomUUID());
                break;
            case STRAY:
                entity = (T) new MokkitStray(server, location, UUID.randomUUID());
                break;
            case RABBIT:
                entity = (T) new MokkitRabbit(server, location, UUID.randomUUID());
                break;
            case VEX:
                entity = (T) new MokkitVex(server, location, UUID.randomUUID());
                break;
            case VINDICATOR:
                entity = (T) new MokkitVindicator(server, location, UUID.randomUUID());
                break;
            case WITCH:
                entity = (T) new MokkitWitch(server, location, UUID.randomUUID());
                break;
            case WITHER_SKELETON:
                entity = (T) new MokkitWitherSkeleton(server, location, UUID.randomUUID());
                break;
            case WOLF:
                entity = (T) new MokkitWolf(server, location, UUID.randomUUID());
                break;
            case ZOMBIE:
                entity = (T) new MokkitZombie(server, location, UUID.randomUUID());
                break;
            case ZOMBIE_HORSE:
                entity = (T) new MokkitZombieHorse(server, location, UUID.randomUUID());
                break;
            case ZOMBIE_VILLAGER:
                entity = (T) new MokkitZombieVillager(server, location, UUID.randomUUID());
                break;
            default:
                throw new IllegalStateException("control flow must not reach this");
        }

        // Invoke the callback.
        function.accept(entity);

        // Add to the world.
        entities.add(entity);

        return entity;
    }

    @SafeVarargs
    @Override
    public final <T extends Entity> Collection<T> getEntitiesByClass(final Class<T>... classes) {
        final List<T> results = new LinkedList<>();
        for (final Class<T> clazz : classes) {
            results.addAll(getEntitiesByClass(clazz));
        }
        return results;
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(final Class<T> cls) {
        return entities.stream()
                .filter(e -> cls.isAssignableFrom(e.getClass()))
                .map(cls::cast)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(final Class<?>... classes) {
        final List<Entity> results = new LinkedList<>();
        for (final Class<?> clazz : classes) {
            if (Entity.class.isAssignableFrom(clazz)) {
                //noinspection unchecked clazz must extend Entity.
                results.addAll(getEntitiesByClass((Class<? extends Entity>) clazz));
            }
        }
        return results;
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
