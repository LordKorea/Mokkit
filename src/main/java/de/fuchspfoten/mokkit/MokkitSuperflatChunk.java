package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.block.MokkitBlock;
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
    public MokkitSuperflatChunk(final World world, final int x, final int z) {
        super(world, x, z);
    }

    @Override
    protected Block createBlock(final int x, final int y, final int z) {
        // TODO create block for the given position.
        return new MokkitBlock(getWorld(), x + 16 * getX(), y, z + 16 * getZ());
    }
}
