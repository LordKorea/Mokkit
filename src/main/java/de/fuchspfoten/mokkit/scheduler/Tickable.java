package de.fuchspfoten.mokkit.scheduler;

import de.fuchspfoten.mokkit.Mokkit;

/**
 * Something that can be ticked.
 */
public interface Tickable {

    /**
     * Require a tickable control object.
     *
     * @return The control object that is also tickable.
     */
    TickListener mokkit();

    /**
     * Ticks this tickable.
     * <p>
     * This should not be called by hand.
     *
     * @param tick The tick number.
     * @see Mokkit#simulateTick()
     * @see Mokkit#simulateTicks(int)
     */
    default void tick(final long tick) {
        mokkit().tick(tick);
    }
}
