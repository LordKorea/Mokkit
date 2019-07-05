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

package io.gitlab.lordkorea.mokkit;

import io.gitlab.lordkorea.mokkit.block.MokkitBlock;
import lombok.NonNull;
import org.bukkit.World;
import org.bukkit.block.Block;

/**
 * A flat chunk.
 */
public class MokkitSuperflatChunk extends MokkitChunk {

    /**
     * Constructor.
     *
     * @param world The world of the chunk.
     * @param x     The x position of the chunk.
     * @param z     The z position of the chunk.
     */
    public MokkitSuperflatChunk(final @NonNull World world, final int x, final int z) {
        super(world, x, z);
    }

    @Override
    protected Block createBlock(final int x, final int y, final int z) {
        assert 0 <= y && y < getWorld().getMaxHeight() : "invalid y position " + y;
        // TODO create block for the given position.
        return new MokkitBlock(getWorld(), x + 16 * getX(), y, z + 16 * getZ());
    }
}
