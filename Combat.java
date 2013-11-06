
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
		//continue the fight until someone dies
		while(player1.getHealth()>0&&bot.getHealth()>0)
		{
			actionCount++;
			if(actionCount%2==0)
			{
				//player1 action
			}
			else
			{
				//bot action
			}
			
		}
	}

}
