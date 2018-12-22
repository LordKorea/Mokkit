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

package de.fuchspfoten.mokkit.internal.exception;

/**
 * Represents a failure.
 */
public class FailureException extends RuntimeException {

    /**
     * Throws a failure exception if the cause is no {@link UnsupportedMockException}.
     * Otherwise the unsupported mock exception is wrapped and thrown.
     *
     * @param message The message.
     * @param cause   The cause of the exception.
     */
    public static void failIfNotMock(final String message, final Throwable cause) {
        //noinspection InstanceofConcreteClass
        if (cause instanceof UnsupportedMockException) {
            throw new UnsupportedMockException((UnsupportedMockException) cause);
        } else {
            throw new FailureException(message, cause);
        }
    }

    /**
     * Constructor.
     *
     * @param message The exception message.
     */
    public FailureException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message The exception message.
     * @param cause   The cause of the exception.
     */
    private FailureException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
