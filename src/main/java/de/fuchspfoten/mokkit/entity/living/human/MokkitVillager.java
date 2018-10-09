package de.fuchspfoten.mokkit.entity.living.human;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.entity.living.MokkitAgeable;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;
import java.util.UUID;

/**
 * @see org.bukkit.entity.Villager
 */
public class MokkitVillager extends MokkitAgeable implements Villager {

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitVillager(final MokkitServer server, final Location location, final UUID uuid) {
        super(server, "Villager", location, uuid, 20.0);
    }

    @Override
    public EntityType getType() {
        return EntityType.VILLAGER;
    }

    @Override
    public Profession getProfession() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setProfession(final Profession profession) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Career getCareer() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCareer(final Career career) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCareer(final Career career, final boolean resetTrades) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Inventory getInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getRiches() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRiches(final int riches) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public List<MerchantRecipe> getRecipes() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRecipes(final List<MerchantRecipe> recipes) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public MerchantRecipe getRecipe(final int i) throws IndexOutOfBoundsException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setRecipe(final int i, final MerchantRecipe recipe) throws IndexOutOfBoundsException {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getRecipeCount() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isTrading() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public HumanEntity getTrader() {
        // TODO
        throw new UnsupportedMockException();
    }
}
