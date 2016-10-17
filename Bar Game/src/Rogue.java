/*
 * Rogue class inherits constructor from superclass 
 * Character
 */
public class Rogue extends Character {
	int gold;
	int CURRHEALTH;
	public Rogue(int level, int exp, String gender, String Name, int defense, int health, int strength, int g, int currH) {
		super(level, exp, gender, Name, defense, health, strength);
		
		CURRHEALTH=currH;
		gold =g;
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
	
}
