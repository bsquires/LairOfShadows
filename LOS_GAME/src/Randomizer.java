import java.util.Random;


public class Randomizer{
	static Random random = new Random();
	static int result;
	
	public Randomizer(){}
	public static int randomize(int lb, int ub)
	{
		result = -1;
		//loop until you receive a result
		//that falls within the specified bounds
		while(result<lb)
		{
		result = random.nextInt(ub+1);
		}
		
		return result;
	}

}
