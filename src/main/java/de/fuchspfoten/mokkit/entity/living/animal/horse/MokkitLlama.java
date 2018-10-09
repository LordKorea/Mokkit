package de.fuchspfoten.mokkit.entity.living.animal.horse;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;
import org.bukkit.inventory.LlamaInventory;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Llama
 */
public class MokkitLlama extends MokkitChestedHorse implements Llama {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitLlama(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Llama", location, uuid, 15.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.LLAMA;
    }

    @Override
    public Color getColor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setColor(final Color color) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getStrength() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setStrength(final int strength) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public LlamaInventory getInventory() {
        // TODO
        throw new UnsupportedMockException();
    }
}
