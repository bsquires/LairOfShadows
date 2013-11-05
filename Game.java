public class Game {

	//Select to play the game
	
	//Prompt to choose class
	int class_choice = 0;
	
	//Choose class - button choice
	switch(class_choice)
	{
	//requires initilization parameters
	case 1: Rogue player = new Rogue();
	break;
	
	case 2: Warrior player = new Warrior();
	break;
	
	case 3: Mage player = new Mage();
	break;
	
	default: System.out.println("You f***ed up");
	break;
	}
	
	//Select Location - button choice
	AI artificial_Intel_Bob = new AI();
	
	
	
}
