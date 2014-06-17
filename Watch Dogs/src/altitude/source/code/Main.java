package altitude.source.code;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
		getLogger().info("Watch-Dogs v1 has been enabled!"); 
		getServer().getPluginManager().registerEvents(this, this);
		new MainPhone(this);
	}
	@Override
	public void onDisable() {
		getLogger().info("Watch-Dogs v1 has been disabled!"); // Showing when the plugin has been disabled
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("watchtest")) { // Adding a dummy command
			sender.sendMessage(ChatColor.AQUA + "The test command works! As of now."); // Sending an Aqua Message back to test if it works
			return true;
		}
		return false; 
	}
}
