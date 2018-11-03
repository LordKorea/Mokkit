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
