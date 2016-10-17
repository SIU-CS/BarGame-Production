/*
 * Mage Class inherits constructor from super class
 * Character
 * 
 */
public class Mage extends Character{
	protected int gold;
	
	protected int CURRHEALTH;
	
	
	public Mage( int level, int exp, String gender, String Name, int defense, int health, int strength, int g,  int currH) {
		super( level, exp, gender, Name, defense, health, strength);
		gold=g;
	
		CURRHEALTH=currH;
	}

	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getCURRHEALTH() {
		return CURRHEALTH;
	}
	public void setCURRHEALTH(int cURRHEALTH) {
		CURRHEALTH = cURRHEALTH;
	}
	protected int reduceGold(int x){
		gold=gold-x;
		return gold;
	}
}
