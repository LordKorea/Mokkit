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
