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

package de.fuchspfoten.mokkit.block;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * @see org.bukkit.block.BlockState
 */
public class MokkitBlockState implements BlockState {

    /**
     * The backing block.
     */
    private @Getter
    final Block block;

    /**
     * The data of the block state.
     */
    private @Getter
    @Setter
    MaterialData data;

    /**
     * Constructor.
     *
     * @param block The block of this state.
     */
    public MokkitBlockState(final @NonNull Block block) {
        this.block = block;
        this.data = block.getType().getNewData(block.getData());
    }

    @Override
    public Material getType() {
        return getData().getItemType();
    }

    @Override
    public void setType(final @NonNull Material type) {
        this.data = type.getNewData((byte) 0);
    }

    @Override
    public boolean setTypeId(final int type) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean update() {
        return update(false, true);
    }

    @Override
    public boolean update(final boolean force) {
        return update(force, true);
    }

    @Override
    public boolean update(final boolean force, final boolean applyPhysics) {
        if (!isPlaced()) {
            return true;
        }

        if (data.getItemType() != block.getType()) {
            if (!force) {
                return false;
            }
        }

        // Update the block.
        block.setTypeIdAndData(data.getItemType().getId(), data.getData(), applyPhysics);
        return true;
    }

    @Override
    public byte getRawData() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRawData(final byte data) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isPlaced() {
        return block != null;
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
