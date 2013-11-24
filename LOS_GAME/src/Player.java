//This document requires comments
public class Player {
	protected int Health=0;
	protected int AttackForce=0;
	protected int Defense=0;
	protected int XP=0;
	protected int Level=0;
	protected Weapon playerWeapon;
	
	protected boolean ranAway = false;
	
	public Player(){};
	
	//Useful for creating custom character and/or Boss characters
	public Player(int h, int aF, int d, int lvl){
		this.Health=h;
		this.AttackForce=aF;
		this.Defense=d;
		this.Level=lvl;
	}
	
	//Set methods to adjust player stats
	public void adjHealth(int h){this.Health+=h;}
	public void adjAttackForce(int a){this.AttackForce+=a;}
	public void adjDefense(int d){this.Defense+=d;}
	public void incXP(int exp){this.XP+=exp;}
	public void adjRanAway(boolean bool){this.ranAway = bool;};
	
	public void setHealth(int h){this.Health = h;}
	public void setAttackForce(int a){this.AttackForce = a;}
	public void setDefense(int d){this.Defense = d;}
	
	//Look more into this
	public void calculateLevel(){this.Level=this.XP/(100);}
	
	//Find a way to calculate level and integrate it to the getLevel command
	
	/*unnecessary methods given the form of combat
	public void engage(){System.out.println("You have chosen to Engage the enemy.");}
	*/
	public void basicAttack(){System.out.println("You strike the enemy with your weapon!");}
	public void runAway(){System.out.println("You escaped, but you did not gain any experience!");}
	public boolean getRanAway(){return this.ranAway;}
	
	//Used for game events
	public int getHealth(){return new Integer(Health);}
	public int getAttackForce(){return new Integer(AttackForce);}
	public int getDefense(){return new Integer(Defense);}
	public int getXP(){return new Integer(XP);}
	public int getLevel(){return new Integer(Level);}
	public int getSpecialStat(){return 0;};
	
	public void levelUp(){}

 	public void addWeapon(Weapon x){
		playerWeapon=new Weapon(x);
		this.Health+=x.gethealthStat();
		this.AttackForce+=x.getafStat();
		this.Defense+=x.getdefenseStat();
	}
	public void removeWeapon(Weapon x){
	playerWeapon=null;
	Health-=x.gethealthStat();
	AttackForce-=x.getafStat();
	Defense-=x.getdefenseStat();
	}
	
	public void checkLevel()
	{
		Level = this.getLevel();
		XP = this.getXP();
		
		/*
		 * Player attributes will be increased by 25% at each level
		 * To increase to a higher level, a player must increase his xp
		 * by 25% of what his current special attribute is
		 */
		
		switch(Level){
		case 1:
			if(XP>25)
			{
				System.out.println("Congratulations you have leveled up to Level 2!");
				this.Level = 2;
			}
			break;
			
		case 2:
			if(XP>56)
			{
				System.out.println("Congratulations you have leveled up to Level 3!");
				this.Level = 3;
			}
			break;
		case 3:
			if(XP>95)
			{
				System.out.println("Congratulations you have leveled up to Level 4!");
				this.Level = 4;
			}
		case 4:
			if(XP>143)
			{
				System.out.println("Congratulations you have leveled up to Level 4!");
				this.Level = 5;
			}
			break;
		case 5:
			if(XP>203)
			{
				System.out.println("Congratulations you have leveled up to Level 4!");
				this.Level = 6;
			}
			break;
		case 6:
			if(XP>278)
			{
				System.out.println("Congratulations you have leveled up to Level 4!");
				this.Level = 7;
			}
			break;
			
		case 7:
			if(XP>372)
			{
				System.out.println("Congratulations you have leveled up to Level 4!");
				this.Level = 7;
			}
			
			default:
				System.out.println("Your code is broken at player CheckLevel");
				break;

		}
	}//endchecLevel
}