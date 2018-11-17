package de.fuchspfoten.mokkit.plugin;

import de.fuchspfoten.mokkit.internal.exception.FailureException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Executes events.
 */
@RequiredArgsConstructor
public class MokkitEventExecutor implements EventExecutor {

    /**
     * The type of the parameter of the method.
     */
    private @NonNull final Class<?> parameterType;

    /**
     * The method that is to be called.
     */
    private @NonNull final Method listenerMethod;

    @Override
    public void execute(final @NonNull Listener listener, final @NonNull Event event) {
        if (!parameterType.isAssignableFrom(event.getClass())) {
            return;
        }

        try {
            listenerMethod.invoke(listener, event);
        } catch (final IllegalAccessException ex) {
            FailureException.failIfNotMock("Failed to execute listener", ex);
        } catch (final InvocationTargetException ex) {
            FailureException.failIfNotMock("Failed to execute listener", ex.getCause());
        }
    }
}
