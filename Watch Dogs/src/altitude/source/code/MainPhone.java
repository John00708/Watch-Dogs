package altitude.source.code;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MainPhone implements Listener{
	private Inventory inv;
	private ItemStack Camera, Info, Battery, Barrier;
	ArrayList<Location> playerlocarray = new ArrayList<Location>();
	
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
			Location plocation = e.getWhoClicked().getLocation();
			Block tblock = e.getWhoClicked().getTargetBlock(null, 500);
			Location tblockloc = tblock.getLocation();
			playerlocarray.add(plocation);
			if(tblock.getType().equals(Material.GLASS)){
				Zombie z = plocation.getWorld().spawn(plocation, Zombie.class);
				
				EntityEquipment arm = e.getWhoClicked().getEquipment();
				z.getEquipment().setHelmet(e.getWhoClicked().getEquipment().getHelmet());
				z.getEquipment().setLeggings(e.getWhoClicked().getEquipment().getLeggings());
				z.getEquipment().setChestplate(e.getWhoClicked().getEquipment().getChestplate());
				z.getEquipment().setBoots(e.getWhoClicked().getEquipment().getBoots());
				z.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000000, 500));
				z.setTarget(null);
				z.setFireTicks(0);
				e.getWhoClicked().teleport(tblockloc);
				ItemStack returnitem = new ItemStack(Material.BLAZE_ROD, 1);
				ItemMeta returnitemmeta = returnitem.getItemMeta();
				returnitemmeta.setDisplayName(ChatColor.RED + "Return");
				e.getWhoClicked().getInventory().setItem(8, returnitem);
			}
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
	@EventHandler
	public void onPlayerInventoryClick(InventoryClickEvent e){
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Return")){
			
		}else{
			return;
		}
	}
}

