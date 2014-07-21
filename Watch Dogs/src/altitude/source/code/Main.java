package altitude.source.code;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static Plugin plugin;

	SettingsManager settings = SettingsManager.getInstance();

	@Override
	public void onEnable() {
		settings.setup(this);
		getLogger().info("Watch-Blocks v1.1 has been enabled!");
		if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
			getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
			getLogger().severe("*** This plugin will be disabled. ***");
			this.setEnabled(false);
			return;
		}
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new MainPhone(), this);
		getServer().getPluginManager().registerEvents(new Holograms(), this);
		Recipes(); // Recipes.
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Bukkit.broadcastMessage(ChatColor.YELLOW + "Player " + e.getPlayer() + " has joined the game!"); // Some basic Events.
	}

	public void onPlayerLeave(PlayerQuitEvent e) {
		Bukkit.broadcastMessage(ChatColor.YELLOW + "Player " + e.getPlayer() + "has left the game!");
	}

	@Override
	public void onDisable() {
		plugin = null;
		getLogger().info("Watch-Blocks v1.1 has been disabled!"); // Showing when the plugin has been disabled
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("watchtest")) { // Adding a dummy command
			sender.sendMessage(ChatColor.AQUA + "The test command works! As of now."); // Sending an Aqua Message back to test if it works
			return true;
		}
		if (!(p instanceof Player)) {
			p.sendMessage(ChatColor.RED + "This command is only for players!");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (p.hasPermission("watchblocks.setspawn") || p.isOp()) {
				getConfig().set("spawn.world", p.getLocation().getWorld().getName());
				getConfig().set("spawn.x", p.getLocation().getX());
				getConfig().set("spawn.y", p.getLocation().getY());
				getConfig().set("spawn.z", p.getLocation().getZ());
				saveConfig();
				p.sendMessage(ChatColor.GREEN + "Spawn set!");
			} else {
				p.sendMessage(ChatColor.BLUE + "Altitude>> You don't have enough permissions!");
				return true;
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
			if (cmd.getName().equalsIgnoreCase("confreload")) {
				if (p.hasPermission("watchblocks.reload")) {
					settings.reloadConfig();
				} else {
					p.sendMessage(ChatColor.BLUE + "Altitude>> You don't have enough permissions!");
					return true;
				}
			}
		}

		return false;
	}

	public void Recipes() {
		/*
		 * Added food and bandages that the player will use. More talk need to
		 * be done about this section.
		 */
		ItemStack bandage = new ItemStack(Material.PAPER);
		ItemMeta bandagem = bandage.getItemMeta();
		bandagem.setDisplayName(ChatColor.GREEN + "Bandage");
		bandagem.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this bandage", "to heal yourself."));
		ItemStack smeal = new ItemStack(Material.PAPER);
		ItemMeta smealm = smeal.getItemMeta();
		smealm.setDisplayName(ChatColor.GOLD + "Small Meal");
		smealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this small meal", "to feed yourself."));
		ItemStack mmeal = new ItemStack(Material.PAPER);
		ItemMeta mmealm = mmeal.getItemMeta();
		mmealm.setDisplayName(ChatColor.GOLD + "Medium Meal");
		mmealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this medium meal", "to feed yourself."));
		ItemStack bmeal = new ItemStack(Material.PAPER);
		ItemMeta bmealm = bmeal.getItemMeta();
		bmealm.setDisplayName(ChatColor.GOLD + "Big Meal");
		bmealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this big meal", "to feed yourself."));

		ShapedRecipe rbandage = new ShapedRecipe(bandage);
		rbandage.shape(
				"PP ",
				"PP ", 
				"   ");
		rbandage.setIngredient('P', Material.PAPER);
		ShapedRecipe rsmeal = new ShapedRecipe(smeal);
		rsmeal.shape("   ", 
				"PP ", 
				"PP "
				);
		rsmeal.setIngredient('P', Material.CARROT);
		ShapedRecipe rmmeal = new ShapedRecipe(mmeal);
		rmmeal.shape(
				"   ", 
				"PP ",
				"PP ");
		rmmeal.setIngredient('P', Material.BAKED_POTATO);
		ShapedRecipe rbmeal = new ShapedRecipe(bmeal);
		rbmeal.shape(
				"   ", 
				"PP ", 
				"PP ");
		rbmeal.setIngredient('P', Material.PORK);
		Bukkit.addRecipe(rbmeal);
		Bukkit.addRecipe(rmmeal);
		Bukkit.addRecipe(rsmeal);
		Bukkit.addRecipe(rbandage);

	}
}
