package altitude.source.code;

import java.util.Arrays;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractListener implements Listener{
	
	SettingsManager settings = SettingsManager.getInstance();
	Economy econ = SettingsManager.econ;
	
	public void ShopGUI(){
		Inventory inv = Bukkit.getServer().createInventory(null, 27, ChatColor.GOLD + "WatchBlocks Shop");
		ItemStack returni = new ItemStack(Material.ENDER_PEARL);
		ItemMeta returnim = returni.getItemMeta();
		returnim.setDisplayName(ChatColor.RED + "Return");
		ItemStack bandage = new ItemStack(Material.PAPER);
		ItemMeta bandagem = bandage.getItemMeta();
		bandagem.setDisplayName(ChatColor.GREEN + "Bandage");
		bandagem.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this bandage", "to heal yourself."));
		ItemStack smeal = new ItemStack(Material.PAPER);
		ItemMeta smealm = smeal.getItemMeta();
		smealm.setDisplayName(ChatColor.GOLD + "Small Meal");
		smealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this small meal", "to feed yourself."));
		ItemStack mmeal = new ItemStack(Material.PAPER);
		ItemMeta mmealm = mmeal.getItemMeta();
		mmealm.setDisplayName(ChatColor.GOLD + "Medium Meal");
		mmealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this medium meal", "to feed yourself."));
		ItemStack bmeal = new ItemStack(Material.PAPER);
		ItemMeta bmealm = bmeal.getItemMeta();
		bmealm.setDisplayName(ChatColor.GOLD + "Big Meal");
		bmealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this big meal", "to feed yourself."));
		ItemStack battery = new ItemStack(Material.REDSTONE);
		ItemMeta batterym = battery.getItemMeta();
		batterym.setDisplayName(ChatColor.DARK_RED + "Battery");
		batterym.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to open the batter menu."));
		battery.setItemMeta(batterym);
		returni.setItemMeta(returnim);
		bandage.setItemMeta(bandagem);
		smeal.setItemMeta(smealm);
		mmeal.setItemMeta(mmealm);
		bmeal.setItemMeta(bmealm);
		inv.setItem(27, battery);
		inv.setItem(19, returni);
		inv.setItem(5, bandage);
		inv.setItem(12, smeal);
		inv.setItem(14, mmeal);
		inv.setItem(16, bmeal); //NOT DONE.
	}
	public void BatteryShopGUI(Player p){ //Battery Shop
		Inventory batinv = Bukkit.getServer().createInventory(null, 9, ChatColor.DARK_RED + "WatchBlocks Battery Shop");
		
		
		p.openInventory(batinv);
		
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public boolean onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals(Material.PAPER) && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Bandage")) {
				p.setHealth(20);
				p.sendMessage(ChatColor.GREEN + "You have been sucessfully healed!");
				p.getItemInHand().setType(Material.AIR);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				return true;

		}
		if (e.getPlayer().getItemInHand().getType().equals(Material.PAPER) && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Small Meal")) {
			p.setFoodLevel(4);
			p.sendMessage(ChatColor.GREEN + "Food Level increased By 2 bars!");
			p.getItemInHand().setType(Material.AIR);
			p.playSound(p.getLocation(), Sound.BURP, 1, 1);
			return true;
		}
		if (e.getPlayer().getItemInHand().getType().equals(Material.PAPER) && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Medium Meal")) {
			p.setFoodLevel(10);
			p.sendMessage(ChatColor.GREEN + "Food Level increased By 5 bars!");
			p.getItemInHand().setType(Material.AIR);
			p.playSound(p.getLocation(), Sound.BURP, 1, 1);
			return true;
		}
		if (e.getPlayer().getItemInHand().getType().equals(Material.PAPER) && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Big Meal")) {
			p.setFoodLevel(20);
			p.sendMessage(ChatColor.GREEN + "Food Level increased By 10 bars!");
			p.getItemInHand().setType(Material.AIR);
			p.playSound(p.getLocation(), Sound.BURP, 1, 1);
			return true;
		}
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) 
			return true;
		if(e.getClickedBlock().getState() instanceof Sign){ //Sign Event for the Shop
			Sign si = (Sign) e.getClickedBlock().getState();
			if(si.getLine(0).equalsIgnoreCase("[Shop]")){
				ShopGUI();
			}
			
		}
		return false;
		
	}
	public boolean onSignChange(SignChangeEvent e){
		if(e.getLine(0).equalsIgnoreCase("[Shop]")){
			e.setLine(0, "[Shop]");
			e.setLine(1, "Click this");
			e.setLine(2, "sign to open");
			e.setLine(3, "the shop!");
			e.getPlayer().sendMessage(ChatColor.GREEN + "Shop Successfully Created!");
			return true;
		}
		return false;
		
	}
	public boolean onInventoryClick(InventoryClickEvent e){ //Click the items
		Player p = (Player) e.getWhoClicked();
		Inventory pi = p.getInventory();
		if(!e.getInventory().getName().contains("WatchBlocks Shop") || e.getInventory().getName().contains("WatchBlocks Battery Shop"))
			return true;
		if(e.getCurrentItem().getItemMeta() == null)
			return true;
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Bandage")){
			ItemStack bandage = new ItemStack(Material.PAPER);
			ItemMeta bandagem = bandage.getItemMeta();
			bandagem.setDisplayName(ChatColor.GREEN + "Bandage");
			bandagem.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this bandage", "to heal yourself."));
			e.setCancelled(true);
			EconomyResponse r = econ.withdrawPlayer(p.getName(), settings.getConfig().getInt("watchblocks.prices.Bandage"));
			if(r.transactionSuccess()){
				pi.addItem(bandage);
			}else{
				p.sendMessage(ChatColor.RED + "You do not have enough money!");
			}
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Small Meal")){
			ItemStack smeal = new ItemStack(Material.PAPER);
			ItemMeta smealm = smeal.getItemMeta();
			smealm.setDisplayName(ChatColor.GOLD + "Small Meal");
			smealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this small meal", "to feed yourself."));
			e.setCancelled(true);
			EconomyResponse r = econ.withdrawPlayer(p.getName(), settings.getConfig().getInt("watchblocks.prices.smeal"));
			if(r.transactionSuccess()){
				pi.addItem(smeal);
			}else{
				p.sendMessage(ChatColor.RED + "You do not have enough money!");
			}
		}
		
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Medium Meal")){
			ItemStack mmeal = new ItemStack(Material.PAPER);
			ItemMeta mmealm = mmeal.getItemMeta();
			mmealm.setDisplayName(ChatColor.GOLD + "Medium Meal");
			mmealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this medium meal", "to feed yourself."));
			e.setCancelled(true);
			EconomyResponse r = econ.withdrawPlayer(p.getName(), settings.getConfig().getInt("watchblocks.prices.mmeal"));
			if(r.transactionSuccess()){
				pi.addItem(mmeal);
			}else{
				p.sendMessage(ChatColor.RED + "You do not have enough money!");
			}
		}
		
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Big Meal")){
			ItemStack bmeal = new ItemStack(Material.PAPER);
			ItemMeta bmealm = bmeal.getItemMeta();
			bmealm.setDisplayName(ChatColor.GOLD + "Big Meal");
			bmealm.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Use this big meal", "to feed yourself."));
			EconomyResponse r = econ.withdrawPlayer(p.getName(), settings.getConfig().getInt("watchblocks.prices.bmeal"));
			e.setCancelled(true);
			if(r.transactionSuccess()){
				pi.addItem(bmeal);
			}else{
				p.sendMessage(ChatColor.RED + "You do not have enough money!");
			}
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Return")){
			p.closeInventory();
			return true;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Battery")){
			BatteryShopGUI(p);
		}
		return false;
	}
}
