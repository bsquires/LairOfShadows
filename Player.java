//This document requires comments
public class Player {
	protected int Health=0;
	protected int AttackForce=0;
	protected int Defense=0;
	protected int XP=0;
	protected int Level=0;
	protected Weapon playerWeapon;
	protected int KEYS = 0;
	protected int PlayerLocation;
	
	public Player(){};
	
	//Useful for creating custom character and/or Boss characters
	public Player(int h, int aF, int d, int lvl){
		this.Health=h;
		this.AttackForce=aF;
		this.Defense=d;
		this.Level=lvl;
	}
	public void adjHealth(int h){this.Health+=h;}
	public void adjAttackForce(int a){this.AttackForce+=a;}
	public void adjDefense(int d){this.Defense+=d;}
	public void incXP(int exp){this.XP+=exp;}
	
	//This method needs to be expanded upon
	public void incLevel(int lvl){this.Level=this.XP/(100);}
	public void engage(){System.out.println("You have chosen to Engage the enemy.");}
	public void basicAttack(){System.out.println("You launch your Basic Attack");}
	public int getHealth(){return new Integer(Health);}
	public int getAttackForce(){return new Integer(AttackForce);}
	public int getDefense(){return new Integer(Defense);}
	public int getXP(){return new Integer(XP);}
	public int getLevel(){return new Integer(Level);}
	
	public double getLocation(){return new Double(PlayerLocation)}//Determines Player location
	//to keep them from moving out of a certain location until they obtain their KEY
	public void adjLocation(double l){this.PlayerLocation;}//Allows the player to change
	//where they are located in the game
	
	public void addWeapon(Weapon x){
		playerWeapon=new Weapon(x);
		Health+=x.gethealthStat();
		AttackForce+=x.getafStat();
		Defense+=x.getdefenseStat();
	}
	public void removeWeapon(Weapon x){
	playerWeapon=null;
	Health-=x.gethealthStat();
	AttackForce-=x.getafStat();
	Defense-=x.getdefenseStat();
	}
}