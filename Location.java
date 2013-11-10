public class Location {
	private String description;
	private String subZoneDescription;
	
	public Location(String d){
		this.description=d;
	}
	public void displayDescription(){
		System.out.println(this.description);
	}
	
	public void BigLocation()
	{
		//Buttons X, Y, Z;
		switch (Buttons)
		{
		case X: System.out.println("You are traveling to the Desert");
				Player.adjLocation = 1.0;
			break;
		case Y: System.out.println("You are traveling to the Forest");
				Player.adjLocation = 2.0;
			break;
		case Z: System.out.println("You are traveling to the Lake");
				Player.adjLocation = 3.0;
			break;
		default: System.out.println("Please choose a different location");
			break;
		}
	}
	
	public void DesertLocations()
	{
		//Buttons X, Y, Z;
		switch(Buttons)
		{
		case X: System.out.println("You are traveling to the Mountains");
				Player.adjLocation = 1.1;
			break;
		case Y: System.out.prinltn("You are traveling to the Dunes");
				Player.adjLocation = 1.2;
			break;
		case Z: System.out.println("You are traveling to the Canyon");
				Player.adjLocation = 1.3;
			break;
		default: System.out.println("Please choose a different Location");
			break;
		}
	}
	public void ForestLocations()
	{
		//Buttons X, Y, Z;
		switch(Buttons)
		{
		case X: System.out.println("You are traveling to the Mountains")
				Player.adjLocation = 2.1;
			break;
		case Y: System.out.prinltn("You are traveling to the Dunes")
				Player.adjLocation = 2.2;
			break;
		case Z: System.out.println("You are traveling to the Canyon")
				Player.adjLocation = 2.3;
			break;
		default: System.out.println("Please choose a different Location")
			break;
		}
	}
	
	public void LakeLocations()
	{
		//Buttons X, Y, Z;
		switch(Buttons)
		{
		case X: System.out.println("You are traveling to the Mountains");
				Player.adjLocation = 3.1;
			break;
		case Y: System.out.prinltn("You are traveling to the Dunes");
				Player.adjLocation = 3.2;
			break;
		case Z: System.out.println("You are traveling to the Canyon");
				Player.adjLocation = 3.3;
			break;
		default: System.out.println("Please choose a different Location");
			break;
		}
	}
}
