package de.fuchspfoten.mokkit;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.event.Event;

/**
 * Thrown when an action is cancelled by an event.
 */
public class CancelledByEventException extends RuntimeException {

    /**
     * The event that cancelled the action.
     */
    private @Getter final Event cancelledEvent;

    /**
     * Constructor.
     *
     * @param cancelledEvent The event that cancelled the action.
     */
    public CancelledByEventException(final @NonNull Event cancelledEvent) {
        super("Action cancelled by event: " + cancelledEvent.getEventName());
        this.cancelledEvent = cancelledEvent;
    }
}
