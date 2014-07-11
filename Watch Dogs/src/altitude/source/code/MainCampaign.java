package altitude.source.code;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class MainCampaign extends JavaPlugin implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e){
	Player player = e.getPlayer();
	player.sendRawMessage("Welcome to Watch_Blocks");
		}
	}

