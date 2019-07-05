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

package io.gitlab.lordkorea.mokkit.internal.exception;

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
