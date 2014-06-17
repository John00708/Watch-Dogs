package altitude.source.code;

public class MainPlayer {
	//This is the class for Nathan to work on
	private String name;
	private int health;
	private double money;
	
	public Player(String n) {
		name = n;
		health = 10;
		money = 19.99;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setHealth(int h) {
		health = h;
	}
	
	public void setMoney(double m) {
		moeny = m;
	}
	
	public void modifyHealth (int h) {
		health += h;
	}
	
	public void modifyMoney(double m) {
		money += m;
	}
}
