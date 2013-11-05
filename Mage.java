public class Mage extends Player {
	protected int Mana;
	
	public Mage(){
		this.Health=105;
		this.AttackForce=10;
		this.Defense=20;
		this.Mana=100; //place holder
		this.Level=0;
		this.XP=0;
	}
	
	public Mage(Mage m){
		Health=m.Health;
		AttackForce=m.AttackForce;
		Defense=m.Defense;
		Mana=m.Mana;
		Level=m.Level;
		XP=m.XP;
	}
	
	public void Cast(){
		System.out.println("You have cast a Spell!");
	}
	
	public void Heal(){
		System.out.println("You have healed yourself!");
	}
}