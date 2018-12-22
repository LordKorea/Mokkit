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

package de.fuchspfoten.mokkit.scheduler;

import de.fuchspfoten.mokkit.Mokkit;

/**
 * Something that listens to ticks.
 */
public interface TickListener {

    /**
     * Called once per tick.
     * <p>
     * This should not be called by hand.
     *
     * @param tick The tick number.
     * @see Mokkit#simulateTick()
     * @see Mokkit#simulateTicks(int)
     */
    void tick(final long tick);
}
