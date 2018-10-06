package de.fuchspfoten.mokkit.plugin;

import de.fuchspfoten.mokkit.internal.FileDeleter;
import de.fuchspfoten.mokkit.internal.PluginReflection;
import de.fuchspfoten.mokkit.internal.ReflectionHelper;
import de.fuchspfoten.mokkit.internal.exception.FailureException;
import de.fuchspfoten.mokkit.internal.exception.InternalException;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.UnknownDependencyException;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see org.bukkit.plugin.PluginManager
 */
public class MokkitPluginManager implements PluginManager {

    /**
     * The server.
     */
    private final Server server;

    /**
     * The plugin loader.
     */
    private final JavaPluginLoader pluginLoader;

    /**
     * The plugins that are loaded.
     */
    private final Map<String, JavaPlugin> pluginMap = new HashMap<>();

    /**
     * The commands that exist.
     */
    private final List<PluginCommand> commandList = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param server The server.
     */
    public MokkitPluginManager(final Server server) {
        this.server = server;
        pluginLoader = new JavaPluginLoader(server);
    }

    /**
     * Loads the given plugin.
     *
     * @param clazz The plugin's class.
     * @param <T>   The plugin type.
     * @return The plugin.
     */
    public <T extends JavaPlugin> T loadPlugin(final Class<T> clazz) {
        final PluginDescriptionFile description = getPluginYAML(clazz);
        final File dataFolder;
        try {
            dataFolder = File.createTempFile(clazz.getSimpleName() + "_" + System.currentTimeMillis(),
                    null);
            if (!dataFolder.delete()) {
                throw new InternalException("Could not delete data folder to mkdir!");
            }
            if (!dataFolder.mkdir()) {
                throw new InternalException("Can not create data folder!");
            }
            FileDeleter.scheduleForDeletion(dataFolder);
        } catch (final IOException ex) {
            throw new InternalException("Could not create data folder!", ex);
        }

        // Create the plugin.
        final T plugin = PluginReflection.createPlugin(clazz, server, pluginLoader, description, dataFolder, null);
        pluginMap.put(plugin.getName(), plugin);

        // Fetch the commands.
        fetchCommands(plugin);

        // Finish loading.
        plugin.onLoad();
        return plugin;
    }

    @Override
    public boolean isPluginEnabled(final Plugin plugin) {
        return plugin.isEnabled();
    }

    @Override
    public boolean isPluginEnabled(final String name) {
        return getPlugin(name).isEnabled();
    }

    @Override
    public Plugin getPlugin(final String name) {
        return pluginMap.get(name);
    }

    @Override
    public void enablePlugin(final Plugin plugin) {
        if (!plugin.isEnabled()) {
            assert plugin instanceof JavaPlugin;
            ReflectionHelper.invokeMethod(JavaPlugin.class, (JavaPlugin) plugin, "setEnabled",
                    new Class[]{boolean.class}, new Object[]{true});
            callEvent(new PluginEnableEvent(plugin));
        }
    }

    @Override
    public void disablePlugin(final Plugin plugin) {
        if (plugin.isEnabled()) {
            assert plugin instanceof JavaPlugin;
            callEvent(new PluginDisableEvent(plugin));
            ReflectionHelper.invokeMethod(JavaPlugin.class, (JavaPlugin) plugin, "setEnabled",
                    new Class[]{boolean.class}, new Object[]{false});
        }
    }

    @Override
    public void disablePlugins() {
        for (final Plugin plugin : pluginMap.values()) {
            disablePlugin(plugin);
        }
    }

    @Override
    public void registerEvents(final Listener listener, final Plugin plugin) {
        for (final Method method : listener.getClass().getMethods()) {
            final EventHandler annot = method.getAnnotation(EventHandler.class);
            if (annot != null) {
                if (method.getParameterCount() != 1) {
                    throw new IllegalStateException("Invalid event handler " + method);
                }
                final Class<?> event = method.getParameterTypes()[0];
                final HandlerList handlerList = (HandlerList) ReflectionHelper.invokeStaticInheritedMethod(event,
                        "getHandlerList", new Class[0], new Object[0]);
                final RegisteredListener entry = new RegisteredListener(listener,
                        new MokkitEventExecutor(event, method), annot.priority(), plugin, annot.ignoreCancelled());
                handlerList.register(entry);
            }
        }
        HandlerList.bakeAll();
    }

    @Override
    public void callEvent(final Event event) throws IllegalStateException {
        final HandlerList handlerList = event.getHandlers();
        for (final RegisteredListener listener : handlerList.getRegisteredListeners()) {
            try {
                listener.callEvent(event);
            } catch (final EventException ex) {
                FailureException.failIfNotMock("Exception in event handler", ex);
            }
        }
    }

    @Override
    public void registerInterface(final Class<? extends PluginLoader> loader) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Plugin[] getPlugins() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Plugin loadPlugin(final File file) throws UnknownDependencyException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Plugin[] loadPlugins(final File directory) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void clearPlugins() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Permission getPermission(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void addPermission(final Permission perm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removePermission(final Permission perm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void registerEvent(final Class<? extends Event> event, final Listener listener, final EventPriority priority,
                              final EventExecutor executor, final Plugin plugin) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void registerEvent(final Class<? extends Event> event, final Listener listener, final EventPriority priority,
                              final EventExecutor executor, final Plugin plugin, final boolean ignoreCancelled) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removePermission(final String name) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<Permission> getDefaultPermissions(final boolean op) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void recalculatePermissionDefaults(final Permission perm) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void subscribeToPermission(final String permission, final Permissible permissible) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void unsubscribeFromPermission(final String permission, final Permissible permissible) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<Permissible> getPermissionSubscriptions(final String permission) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void subscribeToDefaultPerms(final boolean op, final Permissible permissible) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void unsubscribeFromDefaultPerms(final boolean op, final Permissible permissible) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<Permissible> getDefaultPermSubscriptions(final boolean op) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Set<Permission> getPermissions() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean useTimings() {
        // TODO
        throw new UnsupportedMockException();
    }

    /**
     * Get the plugin command with the given name.
     *
     * @param name The name.
     * @return The command.
     */
    public PluginCommand getCommand(final String name) {
        return commandList.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
    }

    /**
     * Fetch the commands of the given plugin.
     *
     * @param plugin The plugin.
     */
    private void fetchCommands(final Plugin plugin) {
        final PluginDescriptionFile description = plugin.getDescription();
        if (description.getCommands() != null) {
            for (final Map.Entry<String, Map<String, Object>> entry : description.getCommands().entrySet()) {
                final PluginCommand cmd = ReflectionHelper.create(PluginCommand.class,
                        new Class[]{String.class, Plugin.class}, new Object[]{entry.getKey(), plugin});
                for (final Map.Entry<String, Object> additionalEntry : entry.getValue().entrySet()) {
                    final String value = additionalEntry.getValue().toString();
                    switch (additionalEntry.getKey()) {
                        case "description":
                            cmd.setDescription(value);
                            break;
                        case "aliases":
                            if (additionalEntry.getValue() instanceof List) {
                                final List<?> aliases = (List<?>) additionalEntry.getValue();
                                cmd.setAliases(aliases.stream().map(Object::toString).collect(Collectors.toList()));
                            } else {
                                cmd.setAliases(Collections.singletonList(value));
                            }
                            break;
                        case "permission":
                            cmd.setPermission(value);
                            break;
                        case "permission-message":
                            cmd.setPermissionMessage(value);
                            break;
                        case "usage":
                            cmd.setUsage(value);
                            break;
                        default:
                            throw new IllegalStateException("Invalid command section in plugin.yml: "
                                    + additionalEntry.getKey());
                    }
                }
                commandList.add(cmd);
            }
        }
    }

    /**
     * Retrieves the plugin.yml file of the given plugin main class.
     *
     * @param source The main class.
     * @return The plugin.yml as a plugin description file.
     */
    private PluginDescriptionFile getPluginYAML(final Class<?> source) {
        try {
            final Enumeration<URL> candidates = source.getClassLoader().getResources("plugin.yml");
            while (candidates.hasMoreElements()) {
                final URL candidate = candidates.nextElement();
                final PluginDescriptionFile pdf = new PluginDescriptionFile(candidate.openStream());
                if (source.getName().equals(pdf.getMain())) {
                    return pdf;
                }
            }
            throw new IllegalStateException("Could not find plugin YAML");
        } catch (final IOException | InvalidDescriptionException ex) {
            throw new IllegalStateException("Could not load plugin YAML", ex);
        }
    }
}
