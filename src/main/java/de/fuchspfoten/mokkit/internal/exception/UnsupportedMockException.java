package de.fuchspfoten.mokkit.internal.exception;

import org.junit.AssumptionViolatedException;

/**
 * Unsupported operations that can not be mocked (yet).
 */
public class UnsupportedMockException extends AssumptionViolatedException {

    /**
     * Constructor.
     */
    public UnsupportedMockException() {
        super("Not (yet) implemented: Can not mock operation");
    }

    /**
     * Constructor.
     *
     * @param cause The causing exception.
     */
    public UnsupportedMockException(final UnsupportedMockException cause) {
        super("Wrapped exception", cause);
    }
}
