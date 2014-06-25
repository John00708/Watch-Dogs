package altitude.source.code;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SkillTree extends JavaPlugin{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static Main plugin;
  
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      Player player = (Player) sender;
      if(commandLabel.equalsIgnoreCase("st")){
      	if(commandLabel.equalsIgnoreCase("driving")){
      		player.sendMessage("accesing...");
      	}else if(commandLabel.equalsIgnoreCase("hacking")){
      		player.sendMessage("accesing...");
      	}else if(commandLabel.equalsIgnoreCase("combat")){
      		player.sendMessage("accesing...");
      	}else if(commandLabel.equalsIgnoreCase("crafting")){
      		player.sendMessage("accesing...");
      	}else if(commandLabel.equalsIgnoreCase("weaponry")){
      		player.sendMessage("accesing...");
      	}
        
        }
      }
	return true;
    }
    

}
