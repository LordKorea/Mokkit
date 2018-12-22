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
