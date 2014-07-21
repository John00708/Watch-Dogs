package altitude.source.code;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.filoghost.holograms.api.Hologram;
import com.gmail.filoghost.holograms.api.HolographicDisplaysAPI;



public class Holograms implements Listener {
	@EventHandler
	public void PlayerChunkLoad(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand().equals(new ItemStack(Material.FEATHER))){
			ItemStack stainedglass = new ItemStack(Material.STAINED_GLASS);
			if(e.getClickedBlock().getType().getData().equals(8) && e.getPlayer().getItemInHand().equals(Material.BLAZE_ROD)){
				
			}else if(e.getClickedBlock().getType().equals(Material.TRIPWIRE_HOOK) && e.getPlayer().getItemInHand().equals(Material.BLAZE_ROD)){
				Hologram hologram = HolographicDisplaysAPI.createHologram(this, e.getClickedBlock().getLocation(), "This is a test hologram.");
				e.getPlayer().sendMessage(ChatColor.GREEN + "Tripwire hook detected and created a WIFI_HOTSPOT!");
			}
		}
	}
}
