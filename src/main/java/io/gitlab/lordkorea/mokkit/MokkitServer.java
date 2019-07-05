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

package io.gitlab.lordkorea.mokkit;

import io.gitlab.lordkorea.mokkit.entity.living.human.MokkitPlayer;
import io.gitlab.lordkorea.mokkit.internal.exception.InternalException;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import io.gitlab.lordkorea.mokkit.inventory.MokkitCustomInventory;
import io.gitlab.lordkorea.mokkit.inventory.MokkitItemFactory;
import io.gitlab.lordkorea.mokkit.plugin.MokkitPluginManager;
import io.gitlab.lordkorea.mokkit.scheduler.MokkitBukkitScheduler;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.advancement.Advancement;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.generator.ChunkGenerator.ChunkData;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @see org.bukkit.Server
 */
public class MokkitServer implements Server {

    /**
     * Retrieves a UUID for the given name.
     *
     * @param name The name.
     * @return The UUID.
     */
    private static UUID getUUIDForName(final @NonNull String name) {
        return UUID.nameUUIDFromBytes(("Mokkit:" + name).getBytes());
    }

    /**
     * The plugin manager of the server.
     */
    private @Getter final MokkitPluginManager pluginManager = new MokkitPluginManager(this);

    /**
     * The logger used by the server.
     */
    private @Getter final Logger logger;

    /**
     * The scheduler for time-based tasks.
     */
    private @Getter final MokkitBukkitScheduler scheduler = new MokkitBukkitScheduler();

    /**
     * The services manager.
     */
    private @Getter final ServicesManager servicesManager = new SimpleServicesManager();

    /**
     * The worlds on the server.
     */
    private final Map<String, MokkitWorld> worlds = new HashMap<>();

    /**
     * The item factory.
     */
    private @Getter final ItemFactory itemFactory = new MokkitItemFactory();

    /**
     * The registered recipes.
     * TODO: Default recipes?
     */
    private final Collection<Recipe> recipes = new ArrayList<>();

    /**
     * The mokkit control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The players on the server.
     */
    private final Collection<MokkitPlayer> players = new HashSet<>();

    /**
     * Constructor.
     */
    public MokkitServer() {
        logger = Logger.getLogger("Mokkit");
        try {
            final InputStream stream = ClassLoader.getSystemResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(stream);
        } catch (final IOException e) {
            logger.warning("Could not load file logger.properties");
        }
        logger.setLevel(Level.ALL);
    }

    /**
     * Get the control object.
     *
     * @return The control object.
     */
    public Mokkit mokkit() {
        return mokkit;
    }

    @Override
    public String getName() {
        return "Mokkit";
    }

    @Override
    public String getVersion() {
        return io.gitlab.lordkorea.mokkit.Mokkit.VERSION;
    }

    @Override
    public String getBukkitVersion() {
        return "Mokkit-Bukkit (Spigot)";
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return Collections.unmodifiableCollection(players);
    }

    @Override
    public int getMaxPlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getPort() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getViewDistance() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getIp() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getServerName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getServerId() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getWorldType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getGenerateStructures() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowEnd() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowNether() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasWhitelist() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWhitelist(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void reloadWhitelist() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int broadcastMessage(final @NonNull String message) {
        logger.info(ChatColor.stripColor(message));

        // TODO permissions.
        players.forEach(p -> p.sendMessage(message));
        return players.size();
    }

    @Override
    public String getUpdateFolder() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public File getUpdateFolderFile() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getConnectionThrottle() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getPlayer(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getPlayerExact(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<Player> matchPlayer(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getPlayer(final @NonNull UUID id) {
        return players.stream().filter(p -> p.getUniqueId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<World> getWorlds() {
        return new ArrayList<>(worlds.values());
    }

    @Override
    public MokkitWorld createWorld(final @NonNull WorldCreator creator) {
        final MokkitWorld world = new MokkitWorld(this, creator.name());
        worlds.put(creator.name(), world);
        return world;
    }

    @Override
    public boolean unloadWorld(final String name, final boolean save) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unloadWorld(final World world, final boolean save) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public World getWorld(final @NonNull String name) {
        return worlds.get(name);
    }

    @Override
    public World getWorld(final UUID uid) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public MapView getMap(final short id) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public MapView createMap(final World world) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void reload() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void reloadData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PluginCommand getPluginCommand(final @NonNull String name) {
        return pluginManager.getCommand(name);
    }

    @Override
    public void savePlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean dispatchCommand(final CommandSender sender, final String commandLine) throws CommandException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean addRecipe(final Recipe recipe) {
        return recipes.add(recipe);
    }

    @Override
    public List<Recipe> getRecipesFor(final ItemStack result) {
        return recipes.stream().filter(r -> r.getResult().isSimilar(result)).collect(Collectors.toList());
    }

    @Override
    public Iterator<Recipe> recipeIterator() {
        return recipes.iterator();
    }

    @Override
    public void clearRecipes() {
        recipes.clear();
    }

    @Override
    public void resetRecipes() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, String[]> getCommandAliases() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getSpawnRadius() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setSpawnRadius(final int value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getOnlineMode() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean getAllowFlight() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isHardcore() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void shutdown() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int broadcast(final String message, final String permission) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public OfflinePlayer getOfflinePlayer(final @NonNull String name) {
        return getOfflinePlayer(getUUIDForName(name));
    }

    @Override
    public OfflinePlayer getOfflinePlayer(final @NonNull UUID id) {
        return new MokkitOfflinePlayer(id);
    }

    @Override
    public Set<String> getIPBans() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void banIP(final String address) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void unbanIP(final String address) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BanList getBanList(final Type type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public GameMode getDefaultGameMode() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setDefaultGameMode(final GameMode mode) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public File getWorldContainer() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public OfflinePlayer[] getOfflinePlayers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Messenger getMessenger() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HelpMap getHelpMap() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Inventory createInventory(final InventoryHolder owner, final InventoryType type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Inventory createInventory(final InventoryHolder owner, final InventoryType type, final String title) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Inventory createInventory(final InventoryHolder owner, final int size)
            throws IllegalArgumentException {
        return createInventory(owner, size, "");
    }

    @Override
    public Inventory createInventory(final InventoryHolder owner, final int size, final @NonNull String title)
            throws IllegalArgumentException {
        assert size % 9 == 0 : "invalid size " + size;
        return new MokkitCustomInventory(size, owner, title);
    }

    @Override
    public Merchant createMerchant(final String title) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getMonsterSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getAnimalSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getAmbientSpawnLimit() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isPrimaryThread() {
        // We're running single-threaded.
        // TODO thread emulation?
        return true;
    }

    @Override
    public String getMotd() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public String getShutdownMessage() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public WarningState getWarningState() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public CachedServerIcon getServerIcon() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public CachedServerIcon loadServerIcon(final File file) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public CachedServerIcon loadServerIcon(final BufferedImage image) {
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

    /**
     * Class for the control object.
     */
    public class Mokkit {

        /**
         * Protected constructor to prevent outside instance creation.
         */
        protected Mokkit() {
        }

        /**
         * Makes a player join.
         *
         * @param name The name of the player.
         * @return The player.
         */
        public MokkitPlayer joinPlayer(final @NonNull String name) throws CancelledByEventException {
            return joinPlayer(name, "127.0.0.1");
        }

        /**
         * Makes a player join.
         *
         * @param name      The name of the player.
         * @param ipAddress The IP address of the player.
         * @return The player.
         */
        public MokkitPlayer joinPlayer(final @NonNull String name, final @NonNull String ipAddress)
                throws CancelledByEventException {
            // Create the IP address.
            final InetAddress ipAddr;
            try {
                ipAddr = InetAddress.getByName(ipAddress);
            } catch (final UnknownHostException ex) {
                throw new InternalException("could not create IP address", ex);
            }

            // Pre-Login.
            final AsyncPlayerPreLoginEvent preLoginEvent = new AsyncPlayerPreLoginEvent(name, ipAddr,
                    getUUIDForName(name));
            getPluginManager().callEvent(preLoginEvent);
            if (preLoginEvent.getLoginResult() != Result.ALLOWED) {
                getLogger().info(String.format("Disallowed login of %1$s (%2$s) in pre-login phase: %3$s (%4$s)",
                        name, getUUIDForName(name).toString(), preLoginEvent.getKickMessage(),
                        preLoginEvent.getLoginResult().name()));
                throw new CancelledByEventException(preLoginEvent);
            }

            // Create the player.
            final MokkitPlayer player = new MokkitPlayer(MokkitServer.this, name,
                    new Location(getWorld("world"), 0, 0, 0), getUUIDForName(name));
            MokkitWorld.updateWorldsForEntity(player);
            players.add(player);

            // Login.
            final PlayerLoginEvent loginEvent = new PlayerLoginEvent(player, ipAddr.getHostAddress(), ipAddr);
            getPluginManager().callEvent(loginEvent);
            if (loginEvent.getResult() != PlayerLoginEvent.Result.ALLOWED) {
                player.despawn();
                players.remove(player);

                getLogger().info(String.format("Disallowed login of %1$s (%2$s): %3$s (%4$s)", name,
                        getUUIDForName(name).toString(), loginEvent.getKickMessage(), loginEvent.getResult().name()));
                throw new CancelledByEventException(loginEvent);
            }

            // Join.
            final PlayerJoinEvent joinEvent = new PlayerJoinEvent(player,
                    "§e" + player.getName() + " joined the game.");
            getPluginManager().callEvent(joinEvent);
            if (joinEvent.getJoinMessage() != null && !joinEvent.getJoinMessage().isEmpty()) {
                broadcastMessage(joinEvent.getJoinMessage());
            }

            getLogger().info(String.format("Player joined: %1$s (%2$s)", name, getUUIDForName(name).toString()));
            return player;
        }
    }

    @Override
    public Iterator<Advancement> advancementIterator() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BossBar createBossBar(final String title, final BarColor color, final BarStyle style,
                                 final BarFlag... flags) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Advancement getAdvancement(final NamespacedKey key) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getEntity(final UUID uuid) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getIdleTimeout() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setIdleTimeout(final int threshold) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public UnsafeValues getUnsafe() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Spigot spigot() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ChunkData createChunkData(final World world) {
        // TODO
        throw new UnsupportedMockException();
    }
}
