package de.fuchspfoten.mokkit.plugin;

import de.fuchspfoten.mokkit.internal.exception.FailureException;
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
    private final Class<?> parameterType;

    /**
     * The method that is to be called.
     */
    private final Method listenerMethod;

    @Override
    public void execute(final Listener listener, final Event event) {
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
