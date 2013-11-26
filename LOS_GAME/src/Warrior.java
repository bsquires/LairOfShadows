
public class Warrior extends Player {
	protected int Focus;
	
	public Warrior(){
		this.Health=200;
		this.AttackForce=10;
		this.Defense=30;
		this.Focus=100; //place holder
		this.Level=1;
		this.XP=0;
	}
	
	//used to create bot with randomly generated values comparable to our player
	public Warrior(int h, int af, int d, int f)
	{
		this.Health = h;
		this.AttackForce = af;
		this.Defense = d;
		this.Focus = f;
	}
	
	public Warrior(Warrior w){
		Health=w.Health;
		AttackForce=w.AttackForce;
		Defense=w.Defense;
		Focus=w.Focus;
		Level=w.Level;
		XP=w.XP;
	}

	public void adjFocus(int f){this.Focus += f;}
	public void setFocus(int f){this.Focus = f;}
	public int getFocus(){return this.Focus;}
	public int getSpecialStat(){return getFocus();};
	
	public void levelUp()
	{
		//If the layer has leveled, increase their attributes by 25%
		int newHealth = this.getHealth();
		newHealth *= 1.25;
		int newDefense = this.getDefense();
		newDefense*=1.25;
		int newAF = this.getAttackForce();
		newAF *=1.25;
		int newFocus = this.getFocus();
		newFocus *= 1.25;
		
		this.setHealth(newHealth);
		this.setDefense(newDefense);
		this.setAttackForce(newAF);
		this.setFocus(newFocus);
	}

}