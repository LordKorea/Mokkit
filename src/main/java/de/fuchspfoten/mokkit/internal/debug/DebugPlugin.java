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

package de.fuchspfoten.mokkit.internal.debug;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

/**
 * Debugging plugin.
 */
public class DebugPlugin extends JavaPlugin implements Listener {

    /**
     * The player that receives notifications.
     */
    private UUID orwell;

    /**
     * Issues a debug action.
     *
     * @param issuer The player that issues the action.
     */
    @SuppressWarnings("TypeMayBeWeakened")
    private void debugAction(final Player issuer) {
        issuer.getWorld().spawn(issuer.getLocation(), Pig.class);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.broadcastMessage(
                "§cYou are running a plugin that ONLY EXISTS FOR DEVELOPING MOKKIT. IF YOU ARE NOT A DEVELOPER, YOU "
                        + "MIGHT BE DOING SOMETHING BAD."), 60 * 20L, 600 * 20L);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        report("%1$s -> %2$s (%3$f)", event.getDamager().getType().name(), event.getEntity().getType().name(),
                event.getDamage());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDeath(final EntityDeathEvent event) {
        report("%1$s dies", event.getEntity().getType().name());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityExplode(final EntityExplodeEvent event) {
        report("%1$s explodes", event.getEntity().getType().name());
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label,
                             final String[] args) {
        if (command.getName().equals("mokkit")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("can only use as player!");
                return true;
            }

            if (args.length == 1) {
                sender.sendMessage("Issuing debug action.");
                debugAction((Player) sender);
                return true;
            }

            orwell = ((Entity) sender).getUniqueId();
            sender.sendMessage("You are now receiving mokkit debug-information.");
        }
        return true;
    }

    /**
     * Reports a message.
     *
     * @param fmt  The message format.
     * @param data The formatting arguments.
     */
    private void report(final String fmt, final Object... data) {
        final String msg = String.format(fmt, data);
        if (orwell != null) {
            final Player orwellPlayer = Bukkit.getPlayer(orwell);
            if (orwellPlayer != null && orwellPlayer.isOnline()) {
                orwellPlayer.sendMessage(msg);
            }
        }
        getLogger().info(msg);
    }
}
