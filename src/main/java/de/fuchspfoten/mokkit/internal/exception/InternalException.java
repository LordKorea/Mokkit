package de.fuchspfoten.mokkit.internal.exception;

/**
 * Represents an internal exception.
 */
public class InternalException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param message The exception message.
     */
    public InternalException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message The exception message.
     * @param cause   The cause of the exception.
     */
    public InternalException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
