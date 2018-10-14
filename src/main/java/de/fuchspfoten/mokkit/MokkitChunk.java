package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.block.MokkitBlock;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
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
    public MokkitChunk(final World world, final int x, final int z) {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    @Override
    public Block getBlock(final int x, final int y, final int z) {
        if (y < 0 || y >= world.getMaxHeight()) {
            return null;
        }

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
    public boolean isSlimeChunk() {
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

    /**
     * Creates a block at the given position.
     *
     * @param x The x position.
     * @param y The y position.
     * @param z The z position.
     * @return The block.
     */
    protected Block createBlock(final int x, final int y, final int z) {
        // TODO create empty block.
        return new MokkitBlock(getWorld(), x + 16 * getX(), y, z + 16 * getZ());
    }

    /**
     * Provides the data array index.
     *
     * @param x The x position, 0 <= x < 16.
     * @param y The y position, 0 <= y < 16.
     * @param z The z position, 0 <= z < 16.
     * @return The index.
     */
    private int index(final int x, final int y, final int z) {
        return y * 16 * 16 + x * 16 + z;
    }
}
