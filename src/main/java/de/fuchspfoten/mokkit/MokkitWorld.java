package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.entity.MokkitEntity;
import de.fuchspfoten.mokkit.entity.hanging.MokkitItemFrame;
import de.fuchspfoten.mokkit.entity.hanging.MokkitLeashHitch;
import de.fuchspfoten.mokkit.entity.hanging.MokkitPainting;
import de.fuchspfoten.mokkit.entity.living.MokkitArmorStand;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitBat;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitChicken;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitCow;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitMushroomCow;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitOcelot;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitParrot;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitPig;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitPolarBear;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitRabbit;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitSheep;
import de.fuchspfoten.mokkit.entity.living.animal.MokkitWolf;
import de.fuchspfoten.mokkit.entity.living.animal.horse.MokkitDonkey;
import de.fuchspfoten.mokkit.entity.living.animal.horse.MokkitHorse;
import de.fuchspfoten.mokkit.entity.living.animal.horse.MokkitLlama;
import de.fuchspfoten.mokkit.entity.living.animal.horse.MokkitMule;
import de.fuchspfoten.mokkit.entity.living.animal.horse.MokkitSkeletonHorse;
import de.fuchspfoten.mokkit.entity.living.animal.horse.MokkitZombieHorse;
import de.fuchspfoten.mokkit.entity.living.boss.MokkitEnderDragon;
import de.fuchspfoten.mokkit.entity.living.boss.MokkitWither;
import de.fuchspfoten.mokkit.entity.living.golem.MokkitIronGolem;
import de.fuchspfoten.mokkit.entity.living.golem.MokkitShulker;
import de.fuchspfoten.mokkit.entity.living.golem.MokkitSnowman;
import de.fuchspfoten.mokkit.entity.living.human.MokkitVillager;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitBlaze;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitCaveSpider;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitCreeper;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitElderGuardian;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitEnderman;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitEndermite;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitEvoker;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitGhast;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitGiant;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitGuardian;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitHusk;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitIllusioner;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitMagmaCube;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitPigZombie;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitSilverfish;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitSkeleton;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitSlime;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitSpider;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitStray;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitVex;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitVindicator;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitWitch;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitWitherSkeleton;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitZombie;
import de.fuchspfoten.mokkit.entity.living.monster.MokkitZombieVillager;
import de.fuchspfoten.mokkit.entity.living.water.MokkitSquid;
import de.fuchspfoten.mokkit.entity.misc.MokkitEnderCrystal;
import de.fuchspfoten.mokkit.entity.projectile.arrow.MokkitArrow;
import de.fuchspfoten.mokkit.entity.projectile.arrow.MokkitSpectralArrow;
import de.fuchspfoten.mokkit.entity.projectile.arrow.MokkitTippedArrow;
import de.fuchspfoten.mokkit.entity.projectile.fireball.MokkitDragonFireball;
import de.fuchspfoten.mokkit.entity.projectile.fireball.MokkitLargeFireball;
import de.fuchspfoten.mokkit.entity.projectile.fireball.MokkitSmallFireball;
import de.fuchspfoten.mokkit.entity.vehicle.MokkitBoat;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitCommandMinecart;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitExplosiveMinecart;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitHopperMinecart;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitPoweredMinecart;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitRideableMinecart;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitSpawnerMinecart;
import de.fuchspfoten.mokkit.entity.vehicle.minecart.MokkitStorageMinecart;
import de.fuchspfoten.mokkit.internal.exception.InternalException;
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
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
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
     * The spawnable entities.
     */
    private static final Map<EntityType, Class<? extends MokkitEntity>> spawnableEntities =
            new EnumMap<>(EntityType.class);

    static {
        spawnableEntities.put(EntityType.ARMOR_STAND, MokkitArmorStand.class);
        spawnableEntities.put(EntityType.ARROW, MokkitArrow.class);
        spawnableEntities.put(EntityType.BAT, MokkitBat.class);
        spawnableEntities.put(EntityType.BLAZE, MokkitBlaze.class);
        spawnableEntities.put(EntityType.BOAT, MokkitBoat.class);
        spawnableEntities.put(EntityType.CAVE_SPIDER, MokkitCaveSpider.class);
        spawnableEntities.put(EntityType.CHICKEN, MokkitChicken.class);
        spawnableEntities.put(EntityType.COW, MokkitCow.class);
        spawnableEntities.put(EntityType.CREEPER, MokkitCreeper.class);
        spawnableEntities.put(EntityType.DONKEY, MokkitDonkey.class);
        spawnableEntities.put(EntityType.DRAGON_FIREBALL, MokkitDragonFireball.class);
        spawnableEntities.put(EntityType.ELDER_GUARDIAN, MokkitElderGuardian.class);
        spawnableEntities.put(EntityType.ENDER_CRYSTAL, MokkitEnderCrystal.class);
        spawnableEntities.put(EntityType.ENDER_DRAGON, MokkitEnderDragon.class);
        spawnableEntities.put(EntityType.ENDERMAN, MokkitEnderman.class);
        spawnableEntities.put(EntityType.ENDERMITE, MokkitEndermite.class);
        spawnableEntities.put(EntityType.EVOKER, MokkitEvoker.class);
        spawnableEntities.put(EntityType.FIREBALL, MokkitLargeFireball.class);
        spawnableEntities.put(EntityType.GHAST, MokkitGhast.class);
        spawnableEntities.put(EntityType.GIANT, MokkitGiant.class);
        spawnableEntities.put(EntityType.GUARDIAN, MokkitGuardian.class);
        spawnableEntities.put(EntityType.HORSE, MokkitHorse.class);
        spawnableEntities.put(EntityType.HUSK, MokkitHusk.class);
        spawnableEntities.put(EntityType.ILLUSIONER, MokkitIllusioner.class);
        spawnableEntities.put(EntityType.IRON_GOLEM, MokkitIronGolem.class);
        spawnableEntities.put(EntityType.ITEM_FRAME, MokkitItemFrame.class);
        spawnableEntities.put(EntityType.LEASH_HITCH, MokkitLeashHitch.class);
        spawnableEntities.put(EntityType.LLAMA, MokkitLlama.class);
        spawnableEntities.put(EntityType.MAGMA_CUBE, MokkitMagmaCube.class);
        spawnableEntities.put(EntityType.MINECART, MokkitRideableMinecart.class);
        spawnableEntities.put(EntityType.MINECART_CHEST, MokkitStorageMinecart.class);
        spawnableEntities.put(EntityType.MINECART_COMMAND, MokkitCommandMinecart.class);
        spawnableEntities.put(EntityType.MINECART_FURNACE, MokkitPoweredMinecart.class);
        spawnableEntities.put(EntityType.MINECART_HOPPER, MokkitHopperMinecart.class);
        spawnableEntities.put(EntityType.MINECART_MOB_SPAWNER, MokkitSpawnerMinecart.class);
        spawnableEntities.put(EntityType.MINECART_TNT, MokkitExplosiveMinecart.class);
        spawnableEntities.put(EntityType.MULE, MokkitMule.class);
        spawnableEntities.put(EntityType.MUSHROOM_COW, MokkitMushroomCow.class);
        spawnableEntities.put(EntityType.OCELOT, MokkitOcelot.class);
        spawnableEntities.put(EntityType.PAINTING, MokkitPainting.class);
        spawnableEntities.put(EntityType.PARROT, MokkitParrot.class);
        spawnableEntities.put(EntityType.PIG, MokkitPig.class);
        spawnableEntities.put(EntityType.PIG_ZOMBIE, MokkitPigZombie.class);
        spawnableEntities.put(EntityType.POLAR_BEAR, MokkitPolarBear.class);
        spawnableEntities.put(EntityType.RABBIT, MokkitRabbit.class);
        spawnableEntities.put(EntityType.SHEEP, MokkitSheep.class);
        spawnableEntities.put(EntityType.SHULKER, MokkitShulker.class);
        spawnableEntities.put(EntityType.SILVERFISH, MokkitSilverfish.class);
        spawnableEntities.put(EntityType.SKELETON, MokkitSkeleton.class);
        spawnableEntities.put(EntityType.SKELETON_HORSE, MokkitSkeletonHorse.class);
        spawnableEntities.put(EntityType.SLIME, MokkitSlime.class);
        spawnableEntities.put(EntityType.SMALL_FIREBALL, MokkitSmallFireball.class);
        spawnableEntities.put(EntityType.SNOWMAN, MokkitSnowman.class);
        spawnableEntities.put(EntityType.SPECTRAL_ARROW, MokkitSpectralArrow.class);
        spawnableEntities.put(EntityType.SPIDER, MokkitSpider.class);
        spawnableEntities.put(EntityType.SQUID, MokkitSquid.class);
        spawnableEntities.put(EntityType.STRAY, MokkitStray.class);
        spawnableEntities.put(EntityType.TIPPED_ARROW, MokkitTippedArrow.class);
        spawnableEntities.put(EntityType.VEX, MokkitVex.class);
        spawnableEntities.put(EntityType.VILLAGER, MokkitVillager.class);
        spawnableEntities.put(EntityType.VINDICATOR, MokkitVindicator.class);
        spawnableEntities.put(EntityType.WITCH, MokkitWitch.class);
        spawnableEntities.put(EntityType.WITHER, MokkitWither.class);
        spawnableEntities.put(EntityType.WITHER_SKELETON, MokkitWitherSkeleton.class);
        spawnableEntities.put(EntityType.WOLF, MokkitWolf.class);
        spawnableEntities.put(EntityType.ZOMBIE, MokkitZombie.class);
        spawnableEntities.put(EntityType.ZOMBIE_HORSE, MokkitZombieHorse.class);
        spawnableEntities.put(EntityType.ZOMBIE_VILLAGER, MokkitZombieVillager.class);
    }

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

        // Block illegal entity types.
        final Set<EntityType> illegal = EnumSet.noneOf(EntityType.class);
        illegal.addAll(Arrays.asList(EntityType.COMPLEX_PART, EntityType.LIGHTNING, EntityType.PLAYER,
                EntityType.UNKNOWN, EntityType.WEATHER));
        if (illegal.contains(targetType)) {
            throw new IllegalArgumentException("can not spawn " + targetType.name());
        }

        // Determine the spawnable entities.
        if (!spawnableEntities.containsKey(targetType)) {
            throw new UnsupportedMockException();
        }

        // Determine whether we can spawn this type.
        // switch (targetType) {
            /*case DROPPED_ITEM:
            case EXPERIENCE_ORB:
            case AREA_EFFECT_CLOUD:
            case EGG:
            case SNOWBALL:
            case ENDER_PEARL:
            case ENDER_SIGNAL:
            case SPLASH_POTION:
            case THROWN_EXP_BOTTLE:
            case WITHER_SKULL:
            case PRIMED_TNT:
            case FALLING_BLOCK:
            case FIREWORK:
            case SPECTRAL_ARROW:
            case SHULKER_BULLET:
            case EVOKER_FANGS:

            case LLAMA_SPIT:
            case LINGERING_POTION:
            case FISHING_HOOK:
            case TIPPED_ARROW:
                // Not (yet) supported.
                throw new UnsupportedMockException();*/
        // }

        // Spawn the entity.
        final Class<? extends MokkitEntity> toSpawn = spawnableEntities.get(targetType);
        final T entity;
        try {
            entity = (T) toSpawn.getConstructor(MokkitServer.class, Location.class, UUID.class).newInstance(server,
                    location, UUID.randomUUID());
        } catch (final ReflectiveOperationException ex) {
            throw new InternalException("can not create entity", ex);
        }

        // TODO SpawnerSpawnEvent? Spawn reasons?
        if (entity instanceof Item) {
            final ItemSpawnEvent event = new ItemSpawnEvent((Item) entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled ItemSpawnEvent");
            }
        } else if (entity instanceof LivingEntity) {
            final CreatureSpawnEvent event = new CreatureSpawnEvent((LivingEntity) entity,
                    CreatureSpawnEvent.SpawnReason.CUSTOM);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled CreatureSpawnEvent");
            }
        } else if (entity instanceof Projectile) {
            final ProjectileLaunchEvent event = new ProjectileLaunchEvent(entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled ProjectileLaunchEvent");
            }
        } else if (entity instanceof Vehicle) {
            final VehicleCreateEvent event = new VehicleCreateEvent((Vehicle) entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled VehicleCreateEvent");
            }
        } else {
            final EntitySpawnEvent event = new EntitySpawnEvent(entity);
            server.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new IllegalArgumentException("can not spawn entity due to cancelled EntitySpawnEvent");
            }
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
    public Arrow spawnArrow(final Location location, final Vector direction, final float speed, final float spread) {
        return spawnArrow(location, direction, speed, spread, Arrow.class);
    }

    @Override
    public <T extends Arrow> T spawnArrow(final Location location, final Vector direction, final float speed,
                                          final float spread, final Class<T> clazz) {
        return spawn(location, clazz, arrow -> {
            arrow.setVelocity(direction.normalize().multiply(speed));
            // TODO spread?
        });
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
