public class Location {
	private String description;
	private String subZoneDescription;
	private String zoneBoss;
	
	public Location(String d){
		this.description=d;
	}
	
	public void setDescription(String d)
	{
		this.description = d;
	}
	
	public void setSubZoneDescription(String d)
	{
		this.subZoneDescription = d;
	}
	
	public void setZoneBoss(String d)
	{
		this.zoneBoss=d;
	}
	
	public void displayDescription(){
		System.out.println(this.description);
	}
	
	public void displaySubZoneDescription(){
		System.out.println(this.subZoneDescription);
	}
	
	public void displayZoneBoss()
	{
		System.out.println(this.zoneBoss);
	}
}
