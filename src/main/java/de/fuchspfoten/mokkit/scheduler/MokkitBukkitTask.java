package de.fuchspfoten.mokkit.scheduler;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

/**
 * @see org.bukkit.scheduler.BukkitTask
 */
@RequiredArgsConstructor
public class MokkitBukkitTask implements BukkitTask {

    /**
     * The target tick.
     */
    private @Getter final long targetTick;

    /**
     * The task's runnable.
     */
    private @NonNull @Getter final Runnable runnable;

    /**
     * The task's ID.
     */
    private @Getter final int taskId;

    /**
     * The task's owner.
     */
    private @NonNull @Getter final Plugin owner;

    /**
     * Whether the task is running sync or not.
     */
    private @Getter final boolean sync;

    /**
     * Whether the task is cancelled or not.
     */
    private @Getter boolean cancelled;

    @Override
    public void cancel() {
        cancelled = true;
    }
}
