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
