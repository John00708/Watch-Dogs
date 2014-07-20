package altitude.source.code;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static Plugin plugin;

	@Override
	public void onEnable() {
		plugin = this;
		getConfig().options().copyDefaults(true);
		saveConfig();
		getLogger().info("Watch-Blocks v1.1 has been enabled!");
		if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
			getLogger()
					.severe("*** HolographicDisplays is not installed or not enabled. ***");
			getLogger().severe("*** This plugin will be disabled. ***");
			this.setEnabled(false);
			return;
		}
		getServer().getPluginManager().registerEvents(new MainPhone(), this);
		getServer().getPluginManager().registerEvents(new Holograms(), this);
	}

	@Override
	public void onDisable() {
		plugin = null;
		getLogger().info("Watch-Blocks v1.1 has been disabled!"); // Showing when the plugin has been disabled
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("watchtest")) { // Adding a dummy command
			sender.sendMessage(ChatColor.AQUA
					+ "The test command works! As of now."); // Sending an Aqua Message back to test if it works
			return true;
		}
		if (!(p instanceof Player)) {
			p.sendMessage(ChatColor.RED + "This command is only for players!");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (p.hasPermission("watchblocks.setspawn") || p.isOp()) {
				getConfig().set("spawn.world",
						p.getLocation().getWorld().getName());
				getConfig().set("spawn.x", p.getLocation().getX());
				getConfig().set("spawn.y", p.getLocation().getY());
				getConfig().set("spawn.z", p.getLocation().getZ());
				saveConfig();
				p.sendMessage(ChatColor.GREEN + "Spawn set!");
			} else {
				p.sendMessage(ChatColor.BLUE + "Altitude>> You don't have enough permissions!");
			}
			if (cmd.getName().equalsIgnoreCase("spawn")) {
				if (getConfig().getConfigurationSection("spawn") == null) {
					p.sendMessage(ChatColor.RED + "Spawn has not been set yet!");
					return true;
				}
				World w = Bukkit.getServer().getWorld(getConfig().getString("spawn.world"));
				double x = getConfig().getDouble("spawn.x");
				double y = getConfig().getDouble("spawn.y");
				double z = getConfig().getDouble("spawn.z");
				p.teleport(new Location(w, x, y, z));
			}
		}

		return false;
	}
	
	ItemStack bandage = new ItemStack(Material.PAPER);
	ItemMeta bandagem = bandage.getItemMeta();
	
}
