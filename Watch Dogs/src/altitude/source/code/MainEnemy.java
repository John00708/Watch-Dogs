package altitude.source.code;

public class Enemy extends Entity {
  
  privatae int level;
  
  public Monster(int level) {
    setHealth(level * 2);
    
  }
  
  public int getLevel() {
    return level;
  }
}
