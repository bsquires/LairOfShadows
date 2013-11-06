import java.util.Random;

public class Warrior extends Player {
	protected int Focus;
	
	public Warrior(){
		this.Health=200;
		this.AttackForce=10;
		this.Defense=20;
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
	
	public void PowerStrike(){
		System.out.println("You delievered a critical blow!");
	}
	
	public void Block(){
		System.out.println("You have blocked the enemies attack!");
	}
}