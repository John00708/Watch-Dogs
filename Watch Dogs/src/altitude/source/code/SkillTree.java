<<<<<<< HEAD
package altitude.source.code;å

public class SkillTree extends JavaPlugin{
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      Player player = (Player) sender;
      if(commandLabel.equalsIgnoreCase("skill")){
        player.sendMessage(ChatColor.DARK_RED + "This works!å")
        }
      }
    }
    
=======
package altitude.source.code;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SkillTree {
  public final Logger logger = Logger.getLogger("Minecraft");
  public static Main plugin;
  private Inventory inv;
  private ItemStack c, s, a;
  
  public Menu() {
  	inv = Bukkit.getServer().createInventory(null, InventoryType)
  }
  
>>>>>>> FETCH_HEAD

}
