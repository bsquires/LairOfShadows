import java.util.Random;

public class AI {
	//reference to the player character
	//playing the game
	Player user;
	
	
	public AI(Player player1)
	{
		this.user = player1;
	}
	
	
	public void createEvent(){
		
		int rdm=randomize(0, 3);
		
		switch(rdm){
		case 0:
			System.out.println("Enemy Encounter!");
			Player bot = createEnemy(user);
			Combat fight = new Combat(user, bot);
			//via create enemy
			//fighting loops until someone runs out of life
			fight.fighting();
			break;
		case 1:
			System.out.println("Enemy Encounter!");
			Player bot1 = createEnemy(user);
			Combat fight1 = new Combat(user, bot1);
			//via create enemy
			//fighting loops until someone runs out of life
			fight1.fighting();
			break;
		case 2:
			System.out.println("Enemy Encounter!");
			Player bot2 = createEnemy(user);
			Combat fight2 = new Combat(user, bot2);
			//via create enemy
			//fighting loops until someone runs out of life
			fight2.fighting();
			break;
		case 3:
			//random encounter
			createRandomEcounter(user);
		default:
			System.out.println("Catostraphic Disaster!!!!!!!");
			break;
		}
	}
	
	public void createRandomEcounter(Player player1)
	{
		int rdm=randomize(0, 3);
		
		switch(rdm)
		{
		case 0:
			System.out.println("You met a farmer who would like you to stay for Dinner.");
			player1.adjHealth( (int) (player1.getHealth()*.05));
			break;
		case 1:
			System.out.println("A troll snuck into your camp over night and blunted!"
					+ "\nyour weapon");
			player1.adjAttackForce((int) (player1.getAttackForce()*.05)*-1);
			break;
		case 2:
			System.out.println("You found a health potion hidden behind a rock");
			player1.adjHealth( (int) (player1.getHealth()*.10));
			break;
		case 3:
			System.out.println("A local armorer has heard tales of your struggle"
					+ "\nand wants to help. He fine tunes your weapon!");
			player1.adjAttackForce((int) (player1.getAttackForce()*.03));
			break;
		case 4:
			System.out.println("You find and eat some bad mushrooms."
					+ "\nYou fall and ill and your Defense falls as a result");
			player1.adjDefense((int) (player1.getDefense()*.05)*-1);
			break;
		case 5:
			System.out.println("Ralph the shield maker upgrades your defensive"
					+ "\nequipment in exchange for pint of local ale!");
			player1.adjDefense((int) (player1.getDefense()*.05));
			break;
		case 6: System.out.println("A fairy appears out of nowhere and heals your wounds!");
			player1.adjHealth( (int) (player1.getHealth()*.025));
			break;
		case 7: System.out.println("A satyr at play throws a rock at your head while you sleep! Ouch!");
			player1.adjHealth( (int) (player1.getHealth()*.05)*-1);
			break;
		default:
			System.out.println("Your random encounter code is broken");
			break;
			
			
		}
	}
	//Create an enemy combatant
	public Player createEnemy(Player player1){
		int e = randomize(0, 4);
		//Generate a random multiple between 25% and 100%
		int botStatsMultiplier = randomize(25, 75)/100;
		
		//The bot stats will be used as the initial stats for our bots
		//created by the following switch statement.
		int botHealth = botStatsMultiplier*player1.getHealth();
		int botDefense = botStatsMultiplier*player1.getDefense();
		int botAttackForce = botStatsMultiplier*player1.getAttackForce();
		
		switch(e){
		case 0:
			//create a warrior enemy
			//Special Attribute Focus will be a product 1/2 the bots health
			Warrior warBot = new Warrior(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			return warBot;
			
		case 2:
			//create a rogue enemy
			//Special Attribute Agility will be a product 1/2 the bots health
			Rogue rogueBot = new Rogue(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			return rogueBot;
		case 3:
			//create a mage enemy
			//Special Attribute Mana will be a product 1/2 the bots health
			Mage mageBot = new Mage(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			return mageBot;
		
		default:
			System.out.println("You should not reach this code in create an enemy");
			return player1;
			
		}
	}
	
	public void bossFight()
	{
		//Create a boss bot that is a mirror of the player
		int botHealth = user.getHealth();
		int botDefense = user.getDefense();
		int botAttackForce = user.getAttackForce();
		Player bossBot = new Player(botHealth, botAttackForce, botDefense, 0);
		//The boss and the player fight until one are dead
		Combat fight = new Combat(user, bossBot);
		fight.fighting();
	}
	
	public void FinalbossFight()
	{
		//Create a boss bot that is a mirror of the player
		int botHealth = (int) (user.getHealth()*1.1);
		int botDefense = (int) (user.getDefense()*1.1);
		int botAttackForce = (int) (user.getAttackForce()*1.1);
		Player bossBot = new Player(botHealth, botAttackForce, botDefense, 0);
		//The boss and the player fight until one are dead
		Combat fight = new Combat(user, bossBot);
		fight.fighting();
	}
	
	//Generate a number between lower bound lb
	//and upperbound ub
	public int randomize(int lb, int ub)
	{
		Random random = new Random();
		int result = -1;
		//loop until you receive a result
		//that falls within the specified bounds
		while(result<lb)
		{
		result = random.nextInt(ub+1);
		}
		
		return result;
	}
	
	
}
