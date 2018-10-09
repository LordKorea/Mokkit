package de.fuchspfoten.mokkit.internal.debug;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.broadcastMessage(
                "§cYou are running a plugin that ONLY EXISTS FOR DEVELOPING MOKKIT. IF YOU ARE NOT A DEVELOPER, YOU "
                        + "MIGHT BE DOING SOMETHING BAD."), 60 * 20L, 600 * 20L);
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

            orwell = ((Player) sender).getUniqueId();
            sender.sendMessage("You are now receiving mokkit debug-information.");
        }
        return true;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        report("%1$s -> %2$s (%3$f)", event.getDamager().getType().name(), event.getEntity().getType().name(),
                event.getDamage());
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

    /**
     * Issues a debug action.
     *
     * @param issuer The player that issues the action.
     */
    private void debugAction(final Player issuer) {
        issuer.getWorld().spawn(issuer.getLocation(), Pig.class);
    }
}