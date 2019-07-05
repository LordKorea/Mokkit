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

package io.gitlab.lordkorea.mokkit.block;

import io.gitlab.lordkorea.mokkit.CancelledByEventException;
import io.gitlab.lordkorea.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.PistonBaseMaterial;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @see org.bukkit.block.Block
 */
public class MokkitBlock implements Block {

    /**
     * The control object.
     */
    private final Mokkit mokkit = new Mokkit();

    /**
     * The world this block is in.
     */
    private @Getter final World world;

    /**
     * The x position of the block.
     */
    private @Getter final int x;

    /**
     * The y position of the block.
     */
    private @Getter final int y;

    /**
     * The z position of the block.
     */
    private @Getter final int z;

    /**
     * The material of the block.
     */
    private @Getter @Setter Material type;

    /**
     * The data byte of the block.
     */
    private @Getter @Setter byte data;

    /**
     * Constructor.
     *
     * @param world The world this block is in.
     * @param x     The x position of the block.
     * @param y     The y position of the block.
     * @param z     The z position of the block.
     */
    public MokkitBlock(final @NonNull World world, final int x, final int y, final int z) {
        assert 0 <= y && y < world.getMaxHeight() : "invalid position y " + y;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        type = Material.AIR;
        data = (byte) 0;
    }

    /**
     * Fetch the control object.
     *
     * @return The control object.
     */
    public Mokkit mokkit() {
        return mokkit;
    }

    @Override
    public Block getRelative(final int modX, final int modY, final int modZ) {
        return world.getBlockAt(x + modX, y + modY, z + modZ);
    }

    @Override
    public Block getRelative(final @NonNull BlockFace face) {
        return getRelative(face, 1);
    }

    @Override
    public Block getRelative(final @NonNull BlockFace face, final int distance) {
        return getRelative(distance * face.getModX(), distance * face.getModY(),
                distance * face.getModZ());
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
    public Location getLocation() {
        return new Location(world, x, y, z);
    }

    @Override
    public Location getLocation(final Location loc) {
        if (loc != null) {
            loc.setWorld(world);
            loc.setX(x);
            loc.setY(y);
            loc.setZ(z);
        }
        return loc;
    }

    @Override
    public Chunk getChunk() {
        return world.getChunkAt(this);
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
        final Material typeBefore = this.type;
        final byte dataBefore = this.data;

        this.type = Material.getMaterial(type);
        this.data = data;
        // TODO applyPhysics

        return typeBefore != this.type || dataBefore != data;
    }

    @Override
    public BlockFace getFace(final Block block) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public BlockState getState() {
        return new MokkitBlockState(this);
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

    /**
     * The class for the control object.
     */
    public class Mokkit {

        /**
         * Extends the piston this block represents.
         */
        public void extendPiston() {
            // TODO instantaneous move, no piston moving block used.
            if (getType() != Material.PISTON_BASE && getType() != Material.PISTON_STICKY_BASE) {
                throw new IllegalStateException("not a piston");
            }
            final BlockState selfState = getState();
            final PistonBaseMaterial pbm = (PistonBaseMaterial) selfState.getData();
            if (pbm.isPowered()) {
                throw new IllegalStateException("already extended");
            }

            // Calculate the push list.
            final List<Block> pushList;
            try {
                pushList = PistonHelper.calculatePushList(getRelative(pbm.getFacing()), pbm.getFacing());
            } catch (final PistonBlockedException ex) {
                // No movement, it's blocked.
                return;
            }

            if (pushList.size() > 12) {
                // Too many, no movement.
                return;
            }

            // Call the event.
            final BlockPistonExtendEvent event = new BlockPistonExtendEvent(MokkitBlock.this,
                    Collections.unmodifiableList(pushList), pbm.getFacing());
            Bukkit.getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                throw new CancelledByEventException(event);
            }

            // Apply the operation.
            PistonHelper.moveBlocks(pushList, pbm.getFacing());

            // Add the extension part.
            pbm.setPowered(true);
            selfState.update(true);
            final BlockState exState = getRelative(pbm.getFacing()).getState();
            exState.setType(Material.PISTON_EXTENSION);
            final PistonExtensionMaterial pem = new PistonExtensionMaterial(Material.PISTON_EXTENSION);
            pem.setSticky(pbm.isSticky());
            pem.setFacingDirection(pbm.getFacing());
            exState.setData(pem);
            exState.update(true);
        }


        /**
         * Retracts the piston this block represents.
         */
        public void retractPiston() {
            // TODO instantaneous move, no piston moving block used.
            if (getType() != Material.PISTON_BASE && getType() != Material.PISTON_STICKY_BASE) {
                throw new IllegalStateException("not a piston");
            }
            final BlockState selfState = getState();
            final PistonBaseMaterial pbm = (PistonBaseMaterial) selfState.getData();
            if (!pbm.isPowered()) {
                throw new IllegalStateException("not extended");
            }

            // Take a snapshot of the extension.
            final BlockState snapshot = getRelative(pbm.getFacing()).getState();
            getRelative(pbm.getFacing()).setType(Material.AIR);

            // Only pull blocks if the piston is sticky.
            final List<Block> pullList = new ArrayList<>();
            if (pbm.isSticky()) {
                try {
                    pullList.addAll(PistonHelper.calculatePullList(getRelative(pbm.getFacing(), 2),
                            pbm.getFacing().getOppositeFace()));
                    if (pullList.size() > 12) {
                        // Too many blocks, no pulling.
                        pullList.clear();
                    }
                } catch (final PistonBlockedException ex) {
                    // No pulling.
                }
            }

            // Call the event.
            final BlockPistonRetractEvent event = new BlockPistonRetractEvent(MokkitBlock.this,
                    Collections.unmodifiableList(pullList), pbm.getFacing().getOppositeFace());
            Bukkit.getServer().getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                // Restore to the snapshot.
                snapshot.update(true);
                throw new CancelledByEventException(event);
            }

            // Unpower the block.
            pbm.setPowered(false);
            selfState.update(true);

            // Apply the operation.
            PistonHelper.moveBlocks(pullList, pbm.getFacing().getOppositeFace());
        }
    }
}
