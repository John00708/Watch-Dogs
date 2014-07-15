package altitude.source.code.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {
	
	public void broadcast(String msg){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.sendMessage(prefix() + msg);
		}
	}
	
	public static String prefix(){
		return ChatColor.GRAY + "[Watch Dogs] ";
	}
}
