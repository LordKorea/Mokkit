package de.fuchspfoten.mokkit.scheduler;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @see org.bukkit.scheduler.BukkitScheduler
 */
public class MokkitBukkitScheduler implements BukkitScheduler {

    /**
     * The current tick.
     */
    private long currentTick = 0L;

    /**
     * The next task ID.
     */
    private int taskId = 0;

    /**
     * The scheduler's queue.
     */
    private final PriorityQueue<MokkitBukkitTask> schedulerQueue =
            new PriorityQueue<>(Comparator.comparingLong(MokkitBukkitTask::getTargetTick));

    /**
     * The tasks that are scheduled.
     */
    private final Map<Integer, MokkitBukkitTask> tasks = new HashMap<>();

    @Override
    public <T> Future<T> callSyncMethod(final Plugin plugin, final Callable<T> task) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void cancelAllTasks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void cancelTask(final int taskId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void cancelTasks(final Plugin plugin) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<BukkitWorker> getActiveWorkers() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<BukkitTask> getPendingTasks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isCurrentlyRunning(final int taskId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isQueued(final int taskId) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTask(final Plugin plugin, final Runnable task) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTask(final Plugin plugin, final BukkitRunnable task) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskAsynchronously(final Plugin plugin, final Runnable task) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskAsynchronously(final Plugin plugin,
                                            final BukkitRunnable task) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskLater(final Plugin plugin, final Runnable task,
                                   final long delay) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskLater(final Plugin plugin, final BukkitRunnable task,
                                   final long delay) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(final Plugin plugin, final Runnable task,
                                                 final long delay) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(final Plugin plugin, final BukkitRunnable task,
                                                 final long delay) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskTimer(final Plugin plugin, final Runnable task, final long delay,
                                   final long period) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskTimer(final Plugin plugin, final BukkitRunnable task, final long delay,
                                   final long period) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(final Plugin plugin, final Runnable task, final long delay,
                                                 final long period) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(final Plugin plugin, final BukkitRunnable task, final long delay,
                                                 final long period) throws IllegalArgumentException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int scheduleAsyncDelayedTask(final Plugin plugin, final Runnable task, final long delay) {
        // Just do it in sync.
        return scheduleSyncDelayedTask(plugin, task, delay);
    }

    @Override
    public int scheduleAsyncDelayedTask(final Plugin plugin, final Runnable task) {
        // Just do it in sync.
        return scheduleSyncDelayedTask(plugin, task);
    }

    @Override
    public int scheduleAsyncRepeatingTask(final Plugin plugin, final Runnable task, final long delay,
                                          final long period) {
        // Just do it in sync.
        return scheduleSyncRepeatingTask(plugin, task, delay, period);
    }

    @Override
    public int scheduleSyncDelayedTask(final Plugin plugin, final Runnable task, final long delay) {
        final MokkitBukkitTask internTask = new MokkitBukkitTask(currentTick + delay, task, taskId, plugin,
                true);
        schedulerQueue.add(internTask);
        tasks.put(taskId, internTask);
        return taskId++;
    }

    @Override
    public int scheduleSyncDelayedTask(final Plugin plugin, final BukkitRunnable task, final long delay) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task, delay);
    }

    @Override
    public int scheduleSyncDelayedTask(final Plugin plugin, final Runnable task) {
        return scheduleSyncDelayedTask(plugin, task, -1);
    }

    @Override
    public int scheduleSyncDelayedTask(final Plugin plugin, final BukkitRunnable task) {
        return scheduleSyncDelayedTask(plugin, (Runnable) task);
    }

    @Override
    public int scheduleSyncRepeatingTask(final Plugin plugin, final Runnable task, final long delay,
                                         final long period) {
        return scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                task.run();
                scheduleSyncDelayedTask(plugin, this, period);
            }
        }, delay);
    }

    @Override
    public int scheduleSyncRepeatingTask(final Plugin plugin, final BukkitRunnable task, final long delay,
                                         final long period) {
        return scheduleSyncRepeatingTask(plugin, (Runnable) task, delay, period);
    }
}
