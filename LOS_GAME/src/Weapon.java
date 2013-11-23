
public class Weapon {
	String weaponName;
	private int healthStat;
	private int afStat;
	private int defenseStat;
	public Weapon(){
		weaponName=null;
		healthStat=0;
		afStat=0;
		defenseStat=0;
	}
	public Weapon(Weapon z){
		weaponName=new String(z.weaponName);
		healthStat=new Integer(z.healthStat);
		afStat=new Integer(z.afStat);
		defenseStat=new Integer(z.defenseStat);
	}
	public Weapon(String wN, int hS, int afS, int dS){
		weaponName=wN;
		healthStat=hS;
		afStat=afS;
		defenseStat=dS;
	}
	public int gethealthStat(){return new Integer(this.healthStat);}
	public int getafStat(){return new Integer(this.afStat);}
	public int getdefenseStat(){return new Integer(this.defenseStat);}
}