package theLairOfShadowsGame;

public class Game {
	public static void main(String[] args) {
		
		String player_class = "this";
		Player player = null;
		char locationChoice =' ';
		AI Bob_the_AI = new AI(player);
		int curLevel = 0;
		
		Location location1;
		char loc1 = ' ';
		Location location2;
		char loc2 = ' ';
		Location location3;
		char loc3 = ' ';
		/*
		 * SAGE: Set the zone descriptions
		 * Each area will be composed of one main area and a sub area
		 * that will be traversed in that order
		 * The final boss location will be the Lair of the beast
		 * add appropriate story
		 * 
		 */
		
		Location desert = new Location("Desert");
		desert.setDescription("");
		desert.setSubZoneDescription("");
		desert.setZoneBoss("");
		
		Location swamp = new Location("Swamp");
		swamp.setDescription("");
		swamp.setSubZoneDescription("");
		swamp.setSubZoneDescription("");
		
		Location forest = new Location("Forest");
		forest.setDescription("");
		forest.setSubZoneDescription("");
		forest.setZoneBoss("");
		
		Location LairOfTheBeast = new Location("Lair of the Beast");
		LairOfTheBeast.setDescription("");
		LairOfTheBeast.setZoneBoss("");
		
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
				classChosen = true;
				break;
			case 2:
				player = new Warrior();
				player_class = "warrior";
				classChosen = true;
				break;
			case 3:
				player = new Mage();
				player_class = "mage";
				classChosen = true;
				break;
			default:
				System.out.println("Your code is broken at the class choice");
				break;
			}//end switch
			
			
		}//end class choice while loop
	
		
		/*
		  SAGE: Add the initial story here
		 */
		System.out.println("Welcome "+player_class+" to the Lair of Shadows");
		
		
		/*
		 * Choose the first location. You will stay here until you reach level 2
		 */
		System.out.println("In what location would you like to begin your journey?");
		System.out.println("Click X to choose the desert"
				+ "\nClick Y to choose the Swamp"
				+ "\nClick Z to choose the Forest");
		
		/*
		 * Need the GUI TO GET THE CHOICE HERE
		 * locationChoice -- This is char variable declared at the top
		 */
		
		
		
		switch(locationChoice)
		{
		case 'X':
			location1 = desert;
			loc1 = 'd';
			break;
		case 'Y':
			location1 = swamp;
			loc1 = 's';
			break;
		case 'Z':
			location1 = forest;
			loc1 = 'f';
			break;
		default:
			System.out.println("You code is broken at location choice 1");
			location1 = new Location("broken");
			break;
			
		}
		
		//Give the player back story on this location
		System.out.println("You are now entering the ");
		location1.displayDescription();
		
		//loop through the level until the player levels up
		curLevel = player.getLevel();
		boolean location1_mainAreaComplete = false;
		while(!location1_mainAreaComplete)
		{
			Bob_the_AI.createEvent();
			if(curLevel<player.getLevel())location1_mainAreaComplete=true;
		}
		//Player has leveled up, time to enter the subzone area
		System.out.println("Good Job, you now are venturing further into the ");
		location1.displaySubZoneDescription();
		
		curLevel = player.getLevel();
		boolean location1_subAreaComplete = false;
		while(!location1_subAreaComplete)
		{
			Bob_the_AI.createEvent();
			if(curLevel<player.getLevel())location1_subAreaComplete=true;
		}
		System.out.println("You are ready to fight the boss of this area!");
		location1.displayZoneBoss();
		System.out.println("The Master of the ");
		location1.displayDescription();
		System.out.println("Challenges you!");
		
		//fight the boss of location 1
		Bob_the_AI.bossFight();
		
		System.out.println("CONGRATULATIONS! You have freed the");
		location1.displayDescription();
		System.out.println("of the vulgar creatures that have so long plagued it!");
		
		/*
		 * PROMPT THE USER TO ENTER LOCATION2
		 */
		System.out.println("It's time to move on. . .");
		if(loc1=='d')
		{
			System.out.println("click X to choose the Swamp"
					+ "click Y to choose the Forest");
			
			/*
			 * Need the GUI TO GET THE CHOICE HERE
			 * locationChoice -- This is char variable declared at the top
			 */
			if(locationChoice == 'X') {location2 = swamp; loc2='s'; loc3= 'f';}
			else{ location2 = forest; loc2='f'; loc3 = 's';}
		}
		else if(loc1=='s')
		{
			System.out.println("click X to choose the Desert"
					+ "click Y to choose the Forest");
			
			/*
			 * Need the GUI TO GET THE CHOICE HERE
			 * locationChoice -- This is char variable declared at the top
			 */
			if(locationChoice == 'X'){ location2 = desert; loc2 = 'd'; loc3 = 'f';}
			else {location2 = forest; loc2 = 'f'; loc3 = 'd';}
		}
		else
		{
			System.out.println("click X to choose the Desert"
					+ "click Y to choose the Swamp");
			/*
			 * Need the GUI TO GET THE CHOICE HERE
			 * locationChoice -- This is char variable declared at the top
			 */
			if(locationChoice == 'X'){ location2 = desert; loc2 = 'd'; loc3 ='s';}
			else {location2 = swamp; loc2 = 's'; loc3 = 'd';}
		}
		
		
		//Begin location 2
		
		//Give the player back story on this location
				System.out.println("You are now entering the ");
				location1.displayDescription();
				
				//loop through the level until the player levels up
				curLevel = player.getLevel();
				boolean location2_mainAreaComplete = false;
				while(!location2_mainAreaComplete)
				{
					Bob_the_AI.createEvent();
					if(curLevel<player.getLevel())location2_mainAreaComplete=true;
				}
				//Player has leveled up, time to enter the subzone area
				System.out.println("Good Job, you now are venturing further into the ");
				location1.displaySubZoneDescription();
				
				curLevel = player.getLevel();
				boolean location2_subAreaComplete = false;
				while(!location2_subAreaComplete)
				{
					Bob_the_AI.createEvent();
					if(curLevel<player.getLevel())location2_subAreaComplete=true;
				}
				System.out.println("You are ready to fight the boss of this area!");
				location2.displayZoneBoss();
				System.out.println("The Master of the ");
				location2.displayDescription();
				System.out.println("Challenges you!");
				
				//fight the boss of location 2
				Bob_the_AI.bossFight();
				
				System.out.println("CONGRATULATIONS! You have freed the");
				location2.displayDescription();
				System.out.println("of the vulgar creatures that have so long plagued it!");
				
				//ENTER LOCATION 3
				if(loc3=='d')location3=desert;
				else if(loc3=='f')location3=forest;
				else location3=swamp;
				
				System.out.println("It is now time to enter the ");
				location3.displayDescription();
				
				//Begin location 3
				
				//loop through the level until the player levels up
				curLevel = player.getLevel();
				boolean location3_mainAreaComplete = false;
				while(!location3_mainAreaComplete)
				{
					Bob_the_AI.createEvent();
					if(curLevel<player.getLevel())location3_mainAreaComplete=true;
				}
				//Player has leveled up, time to enter the subzone area
				System.out.println("Good Job, you now are venturing further into the ");
				location1.displaySubZoneDescription();
				
				curLevel = player.getLevel();
				boolean location3_subAreaComplete = false;
				while(!location3_subAreaComplete)
				{
					Bob_the_AI.createEvent();
					if(curLevel<player.getLevel())location3_subAreaComplete=true;
				}
				System.out.println("You are ready to fight the boss of this area!");
				location3.displayZoneBoss();
				System.out.println("The Master of the ");
				location3.displayDescription();
				System.out.println("Challenges you!");
				
				//fight the boss of location 3
				Bob_the_AI.bossFight();
				
				System.out.println("CONGRATULATIONS! You have freed the");
				location3.displayDescription();
				System.out.println("of the vulgar creatures that have so long plagued it!");
				
				//ENTER THE FINAL BOSS AREA
				
				//loop through the level until the player levels up
				curLevel = player.getLevel();
				boolean LairOfTheBeast_AreaComplete = false;
				while(!LairOfTheBeast_AreaComplete)
				{
					Bob_the_AI.createEvent();
					if(curLevel<player.getLevel())LairOfTheBeast_AreaComplete=true;
				}
				//Player has leveled up, time to face the final boss
				
				
				System.out.println("Your adventures have lead you here! Your time is now!"
						+ "\nYou must face the beast and free our world of evil!");
				LairOfTheBeast.displayZoneBoss();
				System.out.println("Emerges, weapon in hand. TAKE HIM DOWN!");
				
				//fight the boss of location 2
				Bob_the_AI.FinalbossFight();
				
				System.out.println("THE WORLD IS SAVED THANKS TO YOU!");
	}//end main
}