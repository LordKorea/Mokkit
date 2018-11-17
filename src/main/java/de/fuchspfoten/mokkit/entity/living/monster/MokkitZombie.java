package de.fuchspfoten.mokkit.entity.living.monster;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import lombok.NonNull;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;

import java.util.UUID;

/**
 * @see org.bukkit.entity.Zombie
 */
public class MokkitZombie extends MokkitMonster implements Zombie {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitZombie(final @NonNull MokkitServer server, final @NonNull Location location,
                        final @NonNull UUID uuid) {
        super(server, "Zombie", location, uuid, 20.0);
    }

    /**
     * Constructor.
     *
     * @param server           The server this entity is in.
     * @param name             The name of the entity.
     * @param location         The location the entity is at.
     * @param uuid             The UUID of the entity.
     * @param defaultMaxHealth The default max health of the entity.
     */
    protected MokkitZombie(final @NonNull MokkitServer server, final @NonNull String name,
                           final @NonNull Location location, final @NonNull UUID uuid, final double defaultMaxHealth) {
        super(server, name, location, uuid, defaultMaxHealth);
    }

    @Override
    public EntityType getType() {
        return EntityType.ZOMBIE;
    }

    @Override
    public Villager.Profession getVillagerProfession() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setVillagerProfession(final Villager.Profession profession) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBaby() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setBaby(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isVillager() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setVillager(final boolean flag) {
        // TODO
        throw new UnsupportedMockException();
    }
}
