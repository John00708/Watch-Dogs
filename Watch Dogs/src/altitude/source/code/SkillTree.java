package altitude.source.code;

import java.util.logging.logger;[]

public class SkillTree extends JavaPlugin{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static Watch-Dogs plugin;
  
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      Player player = (Player) sender;
      if(commandLabel.equalsIgnoreCase("st")){
        if(args.length == 0){
          player.sendMessage(ChatColor.DARK_RED + "/sk <Skill>");
        }
      }
    }
    

}
