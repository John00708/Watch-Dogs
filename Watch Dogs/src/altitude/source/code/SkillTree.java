package altitude.source.code;å

public class SkillTree extends JavaPlugin{
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      Player player = (Player) sender;
      if(commandLabel.equalsIgnoreCase("skill")){
        player.sendMessage(ChatColor.DARK_RED + "This works!å")
        }
      }
    }
    

}
