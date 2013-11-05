public class AI {
	private int randomizer;
	
	public AI(){}
	
	public void createEvent(){
		
		
		int rdm=randomize(0, 7);
		
		switch(rdm){
		case 0:
			System.out.println("Random Encounter!");
			break;
		case 1:
			System.out.println("Enemy Encounter!");
			Combat fight = new Combat(Player player1);
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
	
	public void createEnemy(int e, int n){
		int eN=0;
		
		switch(e){
		case 0:
			//create a boss enemy
			break;
		case 1:
			while(eN<n){
			//create a warrior enemy
			}
			break;
		case 2:
			while(eN<n){
				//create a rouge enemy
				}
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
