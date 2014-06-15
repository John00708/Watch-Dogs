package altitude.source.code

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class MainPhone extends JavaPlugin implements Listener{
	
	private void openGUI(Player, player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.ORANGE + "Hack Selector");
		
		ItemStack camera = new ItemStack(Material.GLASS_BLOCK);
		ItemMeta cameraMeta = camera.getItemMeta();
		ItemStack info = new ItemStack(Material.PAPER);
		ItemMeta infoMeta = info.getInfoMeta();
		
		cameraMeta.setDisplayName(ChatColor.DARK_GREEN + "Security Camera");
		camera.setItemMeta(cameraMeta);
		
		infoMeta.setDisplayName(ChatColor.DARK_BLUE + "Personal Info");
		info.setItemMeta(itemMeta);
		
		inv.setItem(3, camera);
		inv.setItem(4, info);
		
		player.openInventory(inv);
	}
	
	@EventHander
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().addItem(new ItemStack(Material.FLINT));
	}
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Action a = event.getAction();
		ItemStack is = event.getItem();
		
		if(a == Action.PHYSICAL || is == null || is.getType()==Material.AIR)
			return;
		
		if(is.getType()==Material.FLINT)
			openGUI(event.getPlayer());
	}
	
	
	
	
}
