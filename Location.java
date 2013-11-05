public class Location {
	private String description;
	private String subZoneDescription;
	
	public Location(String d){
		this.description=d;
	}
	public void displayDescription(){
		System.out.println(this.description);
	}
}
