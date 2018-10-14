package de.fuchspfoten.mokkit.entity.living.animal;

import de.fuchspfoten.mokkit.MokkitServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Animals
 * @see org.bukkit.entity.Tameable
 */
public abstract class MokkitTameableAnimals extends MokkitAnimals implements Tameable {

    /**
     * The UUID of the tameable owner.
     */
    private UUID ownerUUID;

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    public MokkitTameableAnimals(final MokkitServer server, final String name, final Location location, final UUID uuid,
                                 final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public AnimalTamer getOwner() {
        if (!isTamed()) {
            return null;
        }

        final Player onlineOwner = Bukkit.getPlayer(ownerUUID);
        if (onlineOwner == null || !onlineOwner.isOnline()) {
            return Bukkit.getOfflinePlayer(ownerUUID);
        }
        return onlineOwner;
    }

    @Override
    public void setOwner(final AnimalTamer tamer) {
        ownerUUID = tamer.getUniqueId();
    }

    @Override
    public boolean isTamed() {
        return ownerUUID != null;
    }

    @Override
    public void setTamed(final boolean tame) {
        if (!isTamed()) {
            ownerUUID = UUID.randomUUID();
        }
    }
}
