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
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

/**
 * @see org.bukkit.Chunk
 */
public class MokkitChunk implements Chunk {

    /**
     * Provides the data array index.
     *
     * @param x The x position, 0 <= x < 16.
     * @param y The y position, 0 <= y < 16.
     * @param z The z position, 0 <= z < 16.
     * @return The index.
     */
    private static int index(final int x, final int y, final int z) {
        assert 0 <= x && x < 16 : "invalid x position " + x;
        assert 0 <= y && y < 16 : "invalid y position " + y;
        assert 0 <= z && z < 16 : "invalid z position " + z;
        return y * 16 * 16 + x * 16 + z;
    }

    /**
     * The world of this chunk.
     */
    private @Getter final World world;

    /**
     * The x position.
     */
    private @Getter final int x;

    /**
     * The z position.
     */
    private @Getter final int z;

    /**
     * The data of this chunk.
     */
    private final Block[][] chunkData = new Block[16][];

    /**
     * Constructor.
     *
     * @param world The world of the chunk.
     * @param x     The x position of the chunk.
     * @param z     The z position of the chunk.
     */
    public MokkitChunk(final @NonNull World world, final int x, final int z) {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    /**
     * Creates a block at the given position.
     *
     * @param x The x position.
     * @param y The y position.
     * @param z The z position.
     * @return The block.
     */
    protected Block createBlock(final int x, final int y, final int z) {
        assert 0 <= y && y < world.getMaxHeight() : "invalid y position " + y;
        // TODO create empty block.
        return new MokkitBlock(world, x + 16 * this.x, y, z + 16 * this.z);
    }

    @Override
    public Block getBlock(final int x, final int y, final int z) {
        assert 0 <= y && y < world.getMaxHeight() : "invalid y coordinate " + y;

        // Get the correct section.
        final int ySection = y >> 4;
        final int yOffset = y - 16 * ySection;
        if (chunkData[ySection] == null) {
            chunkData[ySection] = new Block[16 * 16 * 16];
        }

        // Get the correct block.
        final int idx = index(x, yOffset, z);
        if (chunkData[ySection][idx] == null) {
            final Block block = createBlock(x, y, z);
            chunkData[ySection][idx] = block;
            return block;
        }
        return chunkData[ySection][idx];
    }

    @Override
    public ChunkSnapshot getChunkSnapshot() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ChunkSnapshot getChunkSnapshot(final boolean includeMaxblocky, final boolean includeBiome,
                                          final boolean includeBiomeTempRain) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity[] getEntities() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockState[] getTileEntities() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isLoaded() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean load(final boolean generate) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean load() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unload(final boolean save, final boolean safe) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unload(final boolean save) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean unload() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSlimeChunk() {
        // TODO
        throw new UnsupportedMockException();
    }
}
