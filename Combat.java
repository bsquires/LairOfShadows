
public class Combat {
	Player player1;
	Player bot;
	
	public Combat(Player player1, Player bot)
	{
		this.player1 = player1;
		this.bot = bot;
	}
	
	public void fighting()
	{
		int actionCount = 0;
		int damage = 0;
		int Run = 0;
		//continue the fight until someone dies
		int XP = bot.getHealth * randomizer(20, 30)/100;
		while(player1.getHealth() > 0 && bot.getHealth() > 0)
		{
			
			if(actionCount%2==0)
			{
				//player1 action
					//attack
				if(attackButton)//attack
				{
					System.out.println("You swing your weapon at the enemy...");
					damage = (player1.getAttackPower * randomizer(50, 100)/100) - (bot.getDefense * randomizer(80, 100)/100);
					bot.adjHealth = bot.adjHealth - damage;
				}
				
				if else(RunButton)//run button pushed
				{
					System.out.println("You turn tail and run!");
					Run ++;
				}
				
				if else (Special 1)
				{
					
				}
				
				if else (Special 2)
				{
					
				}
				
			}
			else 
			{
				//bot action
				System.out.println("The Enemy swings their weapon at you!")
				damage = (bot.getAttackPower * randomizer(50, 100)/100) - (player1.getDefense * randomizer(80, 100));
				player1.adjHealth = player1.adjHealth - damage;
			}
			
			actionCount++;//increments to allow each person to attack on after the other
			
		}
		
		if(player1.getHealth == 0)
		{
			// go to the main menu
		}
		else if(bot.getHealth == 0)
		{
			if(Run == 0)
			{
				player1.incXP = player1.incXP + XP;
			}
		}
			
	}
	public void Run()
	{
		
	}
	
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
