package de.fuchspfoten.mokkit;

import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

/**
 * @see org.bukkit.OfflinePlayer
 */
public class MokkitOfflinePlayer implements OfflinePlayer {

    /**
     * The UUID of the player.
     */
    private @Getter final UUID uniqueId;

    /**
     * Constructor.
     *
     * @param uniqueId The UUID of the player.
     */
    public MokkitOfflinePlayer(final UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public boolean isOnline() {
        return Bukkit.getPlayer(getUniqueId()) != null;
    }

    @Override
    public String getName() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBanned() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isWhitelisted() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setWhitelisted(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Player getPlayer() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getFirstPlayed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public long getLastPlayed() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasPlayedBefore() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Location getBedSpawnLocation() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Map<String, Object> serialize() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isOp() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setOp(final boolean value) {
        // TODO
        throw new UnsupportedMockException();
    }
}
