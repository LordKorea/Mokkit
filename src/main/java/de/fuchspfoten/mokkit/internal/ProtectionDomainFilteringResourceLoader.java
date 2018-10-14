package de.fuchspfoten.mokkit.internal;

import de.fuchspfoten.mokkit.internal.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * A classloader that filters the provided resources depending on the protection domain of the associated plugin.
 */
public class ProtectionDomainFilteringResourceLoader extends ClassLoader {

    /**
     * The location prefix for the code source of the protection domain.
     */
    private final String pathPrefix;

    /**
     * Constructor.
     *
     * @param associatedPlugin The plugin this loader is associated with.
     */
    public ProtectionDomainFilteringResourceLoader(final Class<? extends JavaPlugin> associatedPlugin) {
        super(associatedPlugin.getClassLoader());
        this.pathPrefix = stripProtocols(associatedPlugin.getProtectionDomain().getCodeSource().getLocation());
        Bukkit.getLogger().info("Code source prefix of protection domain for class "
                + associatedPlugin.getSimpleName() + " is " + pathPrefix);
    }

    @Override
    public void clearAssertionStatus() {
        throw new UnsupportedOperationException("Mock class loader can only provide resources!");
    }

    @Override
    public URL getResource(final String name) {
        try {
            final Enumeration<URL> candidates = getResources(name);
            if (!candidates.hasMoreElements()) {
                return null;
            }
            return candidates.nextElement();
        } catch (final IOException ex) {
            throw new InternalException("could not get resources", ex);
        }
    }

    @Override
    public InputStream getResourceAsStream(final String name) {
        try {
            final URL resUrl = getResource(name);
            if (resUrl != null) {
                return resUrl.openStream();
            }
            return null;
        } catch (final IOException ex) {
            throw new InternalException("could not open resource", ex);
        }
    }

    @Override
    public Enumeration<URL> getResources(final String name) throws IOException {
        final Enumeration<URL> unfiltered = getParent().getResources(name);
        return new FilterURLEnumeration(unfiltered);
    }

    @Override
    public Class<?> loadClass(final String name) {
        throw new UnsupportedOperationException("Mock class loader can only provide resources!");
    }

    @Override
    public void setClassAssertionStatus(final String className, final boolean enabled) {
        throw new UnsupportedOperationException("Mock class loader can only provide resources!");
    }

    @Override
    public void setDefaultAssertionStatus(final boolean enabled) {
        throw new UnsupportedOperationException("Mock class loader can only provide resources!");
    }

    @Override
    public void setPackageAssertionStatus(final String packageName, final boolean enabled) {
        throw new UnsupportedOperationException("Mock class loader can only provide resources!");
    }

    /**
     * Strips jar: and file: protocols from the URL.
     *
     * @param url The URL.
     * @return The stripped string representation.
     */
    private String stripProtocols(final URL url) {
        String repr = url.toString();
        while (repr.startsWith("jar:") || repr.startsWith("file:")) {
            if (repr.startsWith("jar:")) {
                repr = repr.substring(4);
            }
            if (repr.startsWith("file:")) {
                repr = repr.substring(5);
            }
        }
        return repr;
    }

    /**
     * A URL enumeration that filters.
     */
    @RequiredArgsConstructor
    private class FilterURLEnumeration implements Enumeration<URL> {

        /**
         * The backend enumeration.
         */
        private final Enumeration<URL> backend;

        /**
         * The next element.
         */
        private URL nextElement;

        @Override
        public boolean hasMoreElements() {
            if (nextElement != null) {
                return true;
            }

            // Cache the next element, if possible.
            fetchNextElement();
            return nextElement != null;
        }

        @Override
        public URL nextElement() {
            hasMoreElements();
            if (nextElement != null) {
                return nextElement;
            }
            throw new NoSuchElementException();
        }

        /**
         * Fetches the next element that matches for the protection domain.
         */
        private void fetchNextElement() {
            while (true) {
                if (!backend.hasMoreElements()) {
                    // No more elements in backend: Done.
                    nextElement = null;
                    return;
                }

                // Attempt the next element.
                nextElement = backend.nextElement();
                if (stripProtocols(nextElement).startsWith(pathPrefix)) {
                    // Matching element: Done.
                    return;
                }
            }
        }
    }
}
