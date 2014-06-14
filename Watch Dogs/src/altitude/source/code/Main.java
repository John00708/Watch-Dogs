package altitude.source.code;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getLogger().info("Watch-Dogs v1 has been enabled!"); // Showing when the plugin has been enabled
	}
	@Override
	public void onDisable() {
		getLogger().info("Watch-Dogs v1 has been disabled!"); // Showing when the plugin has been disabled
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("watchtest")) { // Adding a dummy command
			sender.sendMessage(ChatColor.AQUA + "The dummy command works!"); // Sending an Aqua Message back to test if it works
			return true;
		}
		return false; 
	}
}
