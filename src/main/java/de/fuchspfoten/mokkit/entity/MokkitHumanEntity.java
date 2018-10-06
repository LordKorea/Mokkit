package de.fuchspfoten.mokkit.entity;

import de.fuchspfoten.mokkit.MokkitServer;
import de.fuchspfoten.mokkit.internal.exception.UnsupportedMockException;
import de.fuchspfoten.mokkit.inventory.MokkitPlayerInventory;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

/**
 * @see org.bukkit.entity.HumanEntity
 */
public abstract class MokkitHumanEntity extends MokkitLivingEntity implements HumanEntity {

    /**
     * The inventory of the human entity.
     */
    private @Getter final PlayerInventory inventory = new MokkitPlayerInventory();

    /**
     * The game mode of the human entity.
     */
    private @Getter @Setter GameMode gameMode = GameMode.SURVIVAL;

    /**
     * Constructor.
     *
     * @param server   The server this entity is in.
     * @param name     The name of the entity.
     * @param location The location the entity is at.
     * @param uuid     The UUID of the entity.
     */
    public MokkitHumanEntity(final MokkitServer server, final String name, final Location location, final UUID uuid) {
        super(server, name, location, uuid, 20.0);
    }

    @Override
    public ItemStack getItemInHand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItemInHand(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Inventory getEnderChest() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public MainHand getMainHand() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean setWindowProperty(final InventoryView.Property prop, final int value) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView getOpenInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openInventory(final Inventory inventory) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openWorkbench(final Location location, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openEnchanting(final Location location, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void openInventory(final InventoryView inventory) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openMerchant(final Villager trader, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public InventoryView openMerchant(final Merchant merchant, final boolean force) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void closeInventory() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public ItemStack getItemOnCursor() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setItemOnCursor(final ItemStack item) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean hasCooldown(final Material material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getCooldown(final Material material) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setCooldown(final Material material, final int ticks) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isSleeping() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getSleepTicks() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isBlocking() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public boolean isHandRaised() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public int getExpToLevel() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getShoulderEntityLeft() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShoulderEntityLeft(final Entity entity) {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public Entity getShoulderEntityRight() {
        // TODO
        throw new UnsupportedMockException();
    }

    @Override
    public void setShoulderEntityRight(final Entity entity) {
        // TODO
        throw new UnsupportedMockException();
    }
}
