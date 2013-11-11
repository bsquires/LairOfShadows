
public class Game {

	public static void main(String[] args) {
		String player_class = "this";
		Player player;
		
		//Prompt the user to see if they want to play the game
		boolean play = false;
		while(!play){
		System.out.println("Welcome to Lair Of Shadows!"
				+ "\nWould you like to paly the game?"
				+ "\nPress X to Play");
		
		//Use the GUI to see if X is clicked
		//if x is clicked, play = true;
		}
		
		System.out.println("You've made a wise decision.");
		
		boolean classChosen = false;
		while(!classChosen)
		{
			System.out.println("Please choose a class.");
			System.out.println("**********************");
			System.out.println("Rogue: A stealthy thief known for "
					+ "\ntheir ability put an enemy down before their"
					+ "\npresence is know.");
			System.out.println("Warrior: A brave soldier revered"
					+ "\n for their power and defensive abilities");
			System.out.println("Mage: A powerful adventurer whose"
					+ "versed in the ways of magic and sourcery");
			
			int choice = 0;
			System.out.println("Click X to choose the Rogue");
			System.out.println("Click Y to choose the Warrior");
			System.out.println("Click Z to choose the Mage");
			
			//use GUI to get the class choice
			
			switch(choice)
			{
			case 1:
				player = new Rogue();
				player_class = "rogue";
				break;
			case 2:
				player = new Warrior();
				player_class = "warrior";
				break;
			case 3:
				player = new Mage();
				player_class = "mage";
				break;
			default:
				System.out.println("Your code is broken at the class choice");
				break;
			}//end switch
			
			System.out.println("Welcome "+player_class+" to the Lair of Shadows");
			
		}//end class choice while loop
		
		
		

	}//end main

}
