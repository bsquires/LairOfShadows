package theLairOfShadowsGame;

public class Rogue extends Player{
	protected int Agility;
	
	public Rogue(){
		this.Health=140;
		this.AttackForce=30;
		this.Defense=20;
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
	
	public int getAgility(){return this.Agility;}
	
	public void adjAgility(int amount){this.Agility += amount;}
	
	public void setAgility(int amount){this.Agility = amount;}
	public int getSpecialStat(){return getAgility();};

	public void levelUp()
	{
		//If the layer has leveled, increase their attributes by 25%
		int newHealth = this.getHealth();
		newHealth *= 1.25;
		int newDefense = this.getDefense();
		newDefense*=1.25;
		int newAF = this.getAttackForce();
		newAF *=1.25;
		int newAgility = this.getAgility();
		newAgility *= 1.25;
		
		this.setHealth(newHealth);
		this.setDefense(newDefense);
		this.setAttackForce(newAF);
		this.setAgility(newAgility);
	}	
}