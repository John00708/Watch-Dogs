package altitude.source.code;

public class MainPlayer extends Entity {
	//This is the class for Nathan to work on
	private String name;
	private int health;
	private double money;
	
	public void Player(String n) {
		name = n;
		health = 10;
		money = 19.99;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double m) {
		money = m;
	}
	
	public void modifyMoney(double m) {
		money += m;
	}
}
