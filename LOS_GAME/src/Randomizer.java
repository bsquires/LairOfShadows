import java.util.Random;


public class Randomizer{

	public static int randomize(int lb, int ub)
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
