package altitude.source.code;

public class MainCampaign {
	// This is the class that we can make the campaign in
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		print("What is your name?");
		
		String name = s.nextLine();
		
		Player player = new Player(name);
		
		print("Welcome to Watch_Blocks, " + name + "!");
		
		int input;
		
		do {
			System.out.println("[0] Quit. ");
			System.out.println("[1] Shoot Maurice.");
			System.out.println("[2] Sneak past the Police.");
			System.out.println("[3] Hack the camera to unlock the door.");
			System.out.println("[2] Lure the cops away");
			//Actions? "1" System.out.read("1") then do some thing? -Ice 
			//Didn't know were you guys were at on this currently.
		}
	}
}
