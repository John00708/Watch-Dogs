package altitude.source.code;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SkillTree extends JavaPlugin{
	public static HashMap<Player,Double> pistol = new HashMap<Player,Double>();
	public static HashMap<Player,Double> battery = new HashMap<Player,Double>();
	public static HashMap<Player,Double> blockers = new HashMap<Player,Double>();
	public static HashMap<Player,Double> hackboost = new HashMap<Player,Double>();
	public static HashMap<Player,Double> reload = new HashMap<Player,Double>();
	public static HashMap<Player,Double> pipes = new HashMap<Player,Double>();
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player p = (Player) sender;
      	if(label.equalsIgnoreCase("skill")){
      		p.sendMessage("SKILLS");
      		p.sendMessage("Pistol Expert = " + pistol.get(p));
      		p.sendMessage("Extra Battery = " + battery.get(p));
      		p.sendMessage("The Rapid Reload = " + reload.get(p));
      		p.sendMessage("The Blockers = " + blockers.get(p));
      		p.sendMessage("The ATM Hack Boost = " + hackboost.get(p));
      		p.sendMessage("The Steam Pipes = " + pipes.get(p));
      	}
      return false;
      }
    }
