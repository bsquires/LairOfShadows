import java.util.Random;

public class AI {
	//reference to the player character
	//playing the game
	Player user;
	
	private int randomizer;
	
	public AI(Player player1)
	{
		this.user = player1;
	}
	
	public void createEvent(){
		
		
		int rdm=randomize(0, 7);
		
		switch(rdm){
		case 0:
			System.out.println("Random Encounter!");
			break;
		case 1:
			System.out.println("Enemy Encounter!");
			Player bot = createEnemy(user);
			Combat fight = new Combat(user, bot);
			//Combat method must instantiate an enemy to fight with
			//via create enemy
			//fighting loops until someone runs out of life
			fight.fighting();
			break;
		case 2:
			System.out.println("Random Item Is Found!");
			break;
		default:
			System.out.println("Catostraphic Disaster!!!!!!!");
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
			//create a boss enemy
			break;
			
		case 1:
			//create a warrior enemy
			//Special Attribute Focus will be a product 1/2 the bots health
			Warrior bot = new Warrior(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			return bot;
			break;
			
		case 2:
				//create a rouge enemy
				
			break;
		case 3:
			while(eN<n){
				//create a mage enemy
				}
			break;
		case 4:
			//create a sub-boss
			break;
		default:
			//create a random or cannon fodder enemy
			break;
		}
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
	
	/*
	public int randomize(int lb, int i){
		int rdm=0;
		Random random= new Random();
		
		switch(i){
		case 4:
			rdm=random.nextInt(i);
			while(rdm<lb){
				rdm=random.nextInt(i);
			}
			break;
		case 6:
			rdm=random.nextInt(i);
			while(rdm<lb){
				rdm=random.nextInt(i);
			}
			break;
		case 8:
			rdm=random.nextInt(i);
			while(rdm<lb){
				rdm=random.nextInt(i);
			}
			break;
		case 10:
			rdm=random.nextInt(i);
			while(rdm<lb){
				rdm=random.nextInt(i);
			}
			break;
		case 12:
			rdm=random.nextInt(i);
			while(rdm<lb){
				rdm=random.nextInt(i);
			}
			break;
		case 20:
			rdm=random.nextInt(i);
			while(rdm<lb){
				rdm=random.nextInt(i);
			}
			break;
		default:
			break;
		}
		return rdm;	
	}
	*/
}
