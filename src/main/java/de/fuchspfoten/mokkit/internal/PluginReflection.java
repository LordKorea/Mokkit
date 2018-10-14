package de.fuchspfoten.mokkit.internal;

import de.fuchspfoten.mokkit.internal.exception.InternalException;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import sun.reflect.ReflectionFactory;

import java.io.File;
import java.lang.reflect.Constructor;

/**
 * Helps with plugin reflection.
 */
public final class PluginReflection {

    /**
     * Creates a plugin from the given class.
     *
     * @param clazz The class.
     * @param <T>   The type of the plugin.
     * @return The plugin.
     */
    public static <T extends JavaPlugin> T createPlugin(final Class<T> clazz, final Server server,
                                                        final JavaPluginLoader loader,
                                                        final PluginDescriptionFile pluginDescriptionFile,
                                                        final File dataFolder, final File file) {
        final T pluginRaw = createWithoutConstructor(clazz);
        ReflectionHelper.invokeMethod(JavaPlugin.class, pluginRaw, "init", new Class[]{PluginLoader.class,
                        Server.class, PluginDescriptionFile.class, File.class, File.class, ClassLoader.class},
                new Object[]{loader, server, pluginDescriptionFile, dataFolder, file,
                        new ProtectionDomainFilteringResourceLoader(clazz)});

        // By now the plugin is initialized but nothing else has been done.
        return pluginRaw;
    }

    /**
     * Evil black magic creates objects without invoking the constructor.
     *
     * @param clazz The class.
     * @param <T>   The type of the class.
     * @return The uninitialized instance.
     */
    private static <T> T createWithoutConstructor(final Class<T> clazz) {
        // Evil, dark magic. Breaks on other JVMs... works on Oracle JDK & OpenJDK.
        try {
            final ReflectionFactory evil = ReflectionFactory.getReflectionFactory();
            final Constructor objCons = Object.class.getDeclaredConstructor();
            final Constructor surrogate = evil.newConstructorForSerialization(clazz, objCons);
            return clazz.cast(surrogate.newInstance());
        } catch (final Exception ex) {
            throw new InternalException("could not create plugin instance", ex);
        }
    }

    /**
     * Private constructor to prevent instance creation.
     */
    private PluginReflection() {
    }
}
