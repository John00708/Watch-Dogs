package altitude.source.code;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class MainPhone implements Listener{
	private Inventory inv;
	private ItemStack Camera, Info, Battery, Barrier;
	
	
	public MainPhone(Plugin p) {
		inv = Bukkit.getServer().createInventory(null, 9, "Hack Selector");
		ItemStack Barrier = new ItemStack(Material.FENCE);
		ItemStack Info = new ItemStack(Material.PAPER);
		ItemStack Camera = new ItemStack(Material.GLASS);
		ItemStack Battery = new ItemStack(Material.REDSTONE);
		ItemMeta Infom = Info.getItemMeta();
		ItemMeta Barrierm = Barrier.getItemMeta();
		ItemMeta Cameram = Camera.getItemMeta();
		ItemMeta Batterym = Battery.getItemMeta();
		Cameram.setDisplayName(ChatColor.GRAY + "Camera");
		Infom.setDisplayName(ChatColor.DARK_GREEN + "Info");
		Barrierm.setDisplayName(ChatColor.GOLD + "Barrier");
		Batterym.setDisplayName(ChatColor.RED + "Battery");
		Cameram.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "This App allows you ", "to get into any exploited ", "ctOS Camera. Just look ", "directly at the camera and then ", "choose this app!"));
		Infom.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "This App, when clicked, ", "shows you many useful information ", "about the town!"));
		Barrierm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "This App allows you ", "to retract or raise any exploited ", "ctOS Barriers. Just look ", "at the barrier and then", "choose this app!"));
		Batterym.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "This App shows you ", "the current battery level ", "and allows you to buy energy!"));
		inv.setItem(2, Camera);
		inv.setItem(4, Info);
		inv.setItem(6, Battery);
		inv.setItem(8, Barrier);
		Bukkit.getServer().getPluginManager().registerEvents(this, (Plugin) this);
	}
	public void show(Player p){
		p.openInventory(inv);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
		if(e.getCurrentItem().getItemMeta() == null) return;
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Camera")){
			e.setCancelled(true);                                    //Do things with Camera
			e.getWhoClicked().closeInventory();
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Info")){
			e.getWhoClicked().closeInventory();                      //Do things with Info
			e.setCancelled(true);
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Battery")){
			e.setCancelled(true);                                    //Do things with Battery
			e.getWhoClicked().closeInventory();
			
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Barrier")){
			e.setCancelled(true);                                    //Do things with Barrier
			e.getWhoClicked().closeInventory();
			
		}
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		show(e.getPlayer());
	}
}

