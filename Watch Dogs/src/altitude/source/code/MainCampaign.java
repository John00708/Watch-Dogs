package altitude.source.code;

import java.util.Scanner;

import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCampaign extends JavaPlugin{
	
	public void onDisable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + "Has Been Disabled!");
	}
	
	public void onEnable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " Version " + pdffile.getVersion() + " Has Been Enabled!");
	}
	
		}
	}
}
