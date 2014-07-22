package altitude.source.code;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class SettingsManager {
	private SettingsManager() {
	}
	public static Economy econ = null;
	static SettingsManager instance = new SettingsManager();

	public static SettingsManager getInstance() {
		return instance;
	}
	HashMap<String, Integer> batsortage = new HashMap<String, Integer>();

	Plugin p;

	FileConfiguration config;
	File cfile;

	FileConfiguration battery;
	File bfile;

	public void setup(Plugin p) {
		cfile = new File(p.getDataFolder(), "config.yml");
		config = p.getConfig();
		config.options().copyDefaults(true);
		saveConfig();

		if (!(p.getDataFolder().exists())) {
				p.getDataFolder().mkdir();
		}
		bfile = new File(p.getDataFolder(), "battery.yml");
		
		if(!(bfile.exists())){
			try{
				bfile.createNewFile();
			}
			catch(IOException e){
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create battery.yml!");
			}
		}
	}

	public FileConfiguration getConfig() {
		return config;
	}

	public void saveConfig() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
		}
	}

	public void reloadBattery() {
		battery = YamlConfiguration.loadConfiguration(bfile);
	}
	public FileConfiguration getBattery() {
		return battery;
	}

	public void saveBattery() {
		try {
			battery.save(bfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save battery.yml!");
		}
	}

	public void reloadConfig() {
		battery = YamlConfiguration.loadConfiguration(bfile);
	}
	@SuppressWarnings("unused")
	private boolean setupEconomy() {
		if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
			return false;
		}
		RegisteredServiceProvider<Economy> rsp= Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
		if(rsp == null){
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
	
	
}
