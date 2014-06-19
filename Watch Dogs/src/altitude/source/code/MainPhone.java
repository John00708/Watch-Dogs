package altitude.source.code;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class MainPhone implements Listener{
	public MainPhone(Main plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Hack Selector");
		
		ItemStack camera = new ItemStack(Material.GLASS);
		ItemMeta cameraMeta = camera.getItemMeta(); //MetaData for camera item
		ItemStack info = new ItemStack(Material.PAPER);
		ItemMeta infoMeta = info.getItemMeta(); //MetaData for info item
		
		cameraMeta.setDisplayName(ChatColor.DARK_GREEN + "Security Camera"); //Setting the name of the block
		camera.setItemMeta(cameraMeta);
		
		infoMeta.setDisplayName(ChatColor.DARK_BLUE + "Personal Info"); //Setting the name of the item
		info.setItemMeta(cameraMeta);
		
		inv.setItem(3, camera); //Putting the items inside the inv
		inv.setItem(4, info);
		
		player.openInventory(inv);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Action a = event.getAction();
		ItemStack is = event.getItem();
		
		if(a == Action.PHYSICAL || is == null || is.getType()==Material.AIR){
			return;
		}
		if(is.getType()==Material.COMPASS);{
			openGUI(event.getPlayer());
		}
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Hack Selector")){		
			e.setCancelled(true);
			if(e.getCurrentItem()==null || e.getCurrentItem().getType()==Material.AIR || !e.getCurrentItem().hasItemMeta());{
				Player player = (Player) e.getWhoClicked();
				player.closeInventory();
				return;
			}
		}
		switch (e.getCurrentItem().getType()) {
		case GLASS: //Do stuff when the look at the glass (Camera) Cursor
	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent e) {
				 
			 	Player player = e.getPlayer();
			 	
			 	player.sendMessage(ChatColor.DARK_GREEN + "When clicking the camera, you must look directly at it");
			 	
			 	Block targetblock = player.getTargetBlock(null, 150);
			 	if (targetblock.getType() == Material.GLASS){
			 		
			 		Location beforeloc = player.getLocation();
			 		Location location = targetblock.getLocation();
			 		player.getWorld().spawnCreature(beforeloc, EntityType.ZOMBIE);
			 		player.teleport(location);
			 		boolean freeze = true;
			 		player.setVelocity(new Vector(player.getVelocity().getX(), 0, player.getVelocity().getZ()));
			 		public void OnPlayerMove(PlayerMoveEvent e){
			 			if (freeze == true){
			 				e.setCancelled(true);
			 			}
			 		}
			 		
			      }
			 	}
			 	
			 	//Every thing I have tried doesn't work with the tp code
			 


			break;
		case PAPER:
			public void onPlayerClickInv(InventoryClickEvent e) {
				
			}
			//Do stuff when they click the info ()

			break;
		}
	}
	
	


}
