public class Rogue extends Player {
	protected int Agility;
	
	public Rogue(){
		this.Health=110;
		this.AttackForce=30;
		this.Defense=10;
		this.Agility=100; //place holder
		this.Level=0;
		this.XP=0;
	}
	
	public Rogue(Rogue m){
		Health=m.Health;
		AttackForce=m.AttackForce;
		Defense=m.Defense;
		Agility=m.Agility;
		Level=m.Level;
		XP=m.XP;
	}
	
	public Rogue(int h, int af, int d, int a)
	{
		this.Health = h;
		this.AttackForce = af;
		this.Defense = d;
		this.Agility = a;
	}
	
	public void CritStrike(){
		System.out.println("You have landed a critical strike!");
	}
	
	public void Disarm(){
		System.out.println("You have disarmed your opponent!");
	}
}