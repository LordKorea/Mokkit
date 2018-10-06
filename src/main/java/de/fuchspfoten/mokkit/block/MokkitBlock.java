package de.fuchspfoten.mokkit.block;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

/**
 * @see org.bukkit.block.Block
 */
public class MokkitBlock implements Block {

    @Override
    public byte getData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setData(final byte data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getRelative(final int modX, final int modY, final int modZ) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getRelative(final BlockFace face) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Block getRelative(final BlockFace face, final int distance) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Material getType() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setType(final Material type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getTypeId() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public byte getLightLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public byte getLightFromSky() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public byte getLightFromBlocks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public World getWorld() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getX() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getY() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getZ() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getLocation(final Location loc) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Chunk getChunk() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setData(final byte data, final boolean applyPhysics) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setType(final Material type, final boolean applyPhysics) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setTypeId(final int type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setTypeId(final int type, final boolean applyPhysics) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setTypeIdAndData(final int type, final byte data, final boolean applyPhysics) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockFace getFace(final Block block) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockState getState() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Biome getBiome() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBiome(final Biome bio) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBlockPowered() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBlockIndirectlyPowered() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBlockFacePowered(final BlockFace face) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBlockFaceIndirectlyPowered(final BlockFace face) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getBlockPower(final BlockFace face) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getBlockPower() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isEmpty() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isLiquid() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getTemperature() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public double getHumidity() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean breakNaturally() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean breakNaturally(final ItemStack tool) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Collection<ItemStack> getDrops() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Collection<ItemStack> getDrops(final ItemStack tool) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setMetadata(final String metadataKey, final MetadataValue newMetadataValue) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<MetadataValue> getMetadata(final String metadataKey) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasMetadata(final String metadataKey) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void removeMetadata(final String metadataKey, final Plugin owningPlugin) {
        // TODO
        throw new UnsupportedMockException();
    }
}
