/*
 * Hunter class inherits constructor from superclass
 * Characters
 * 
 */
public class Hunter extends Character {
	
	int gold;
	int CURRHEALTH;
	private float PercentH;
	
	public Hunter(int level, int exp, String gender, String Name, int defense, int health, int strength, int g, int currH) {
		super(level, exp, gender, Name, defense, health, strength);
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
}

