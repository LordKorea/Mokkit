package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.enchantments.MokkitEnchantment;
import de.fuchspfoten.mokkit.internal.ReflectionHelper;
import de.fuchspfoten.mokkit.potion.MokkitPotionEffectType;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Helper for Mokkit operations.
 */
public final class Mokkit {

    /**
     * The implementation version.
     */
    public static final String VERSION = "1.12.2";

    /**
     * The server that is being mocked.
     */
    private static MokkitServer server = null;

    /**
     * Loads and enables the given plugin.
     *
     * @param pluginClass The plugin's class.
     * @param <T>         The plugin type.
     * @return The plugin.
     */
    public static <T extends JavaPlugin> T loadPlugin(final @NonNull Class<T> pluginClass) {
        final T plugin = server.getPluginManager().loadPlugin(pluginClass);
        server.getPluginManager().enablePlugin(plugin);
        return plugin;
    }

    /**
     * Simulates a single tick.
     */
    public static void simulateTick() {
        simulateTicks(1);
    }

    /**
     * Simulates the given amount of ticks.
     *
     * @param amount The amount of ticks to simulate.
     */
    public static void simulateTicks(final int amount) {
        assert amount > 0 : "invalid amount";
        for (int i = 0; i < amount; i++) {
            server.getScheduler().tick();
            server.getWorlds().stream()
                    .map(x -> (MokkitWorld) x)
                    .forEach(x -> x.tick(server.getScheduler().getCurrentTick()));
        }
    }

    /**
     * Starts mocking a server and returns it.
     *
     * @return The mocking server.
     */
    public static MokkitServer startServer() {
        if (server != null) {
            throw new IllegalStateException("can not restart mocking without stopping");
        }

        // Start mocking.
        server = new MokkitServer();
        ReflectionHelper.setStaticField(Bukkit.class, "server", null);
        Bukkit.setServer(server);

        // Create potion effects.
        MokkitPotionEffectType.registerPotionEffects();

        // Create enchantments.
        MokkitEnchantment.registerEnchantments();

        // Create the default world.
        server.createWorld(new WorldCreator("world"));

        // TODO what else.
        return server;
    }

    /**
     * Stop the server and invalidate it.
     */
    public static void stopServer() {
        // TODO what else?
        server.getPluginManager().disablePlugins();

        // Stop mocking.
        server = null;
        ReflectionHelper.setStaticField(Bukkit.class, "server", null);
    }

    /**
     * Private constructor to prevent instance creation.
     */
    private Mokkit() {
    }
}
