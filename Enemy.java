package Enemy;

public class Enemy {
	int hp, str, def, expGiven;
	public Enemy(int hp, int str, int def, int expGiven) {
		this.hp = hp;
		this.str = str;
		this.def = def;
		this.expGiven = expGiven;
	}
	protected int getHp() {
		return hp;
	}
	protected void setHp(int hp) {
		this.hp = hp;
	}
	protected int getStr() {
		return str;
	}
	protected void setStr(int str) {
		this.str = str;
	}
	protected int getDef() {
		return def;
	}
	protected void setDef(int def) {
		this.def = def;
	}
	
	protected Enemy typeOfEnemy(String type) {
		Enemy enemy = null;
		switch (type) {
			case "Soldier":
				enemy = new Enemy(8, 4, 3, 10);
				break;
			case "Undead":
				enemy = new Enemy(10, 2, 1, 5);
				break;
			case "Spider":
				enemy = new Enemy(3, 2, 0, 3);
				break;
			case "Bandit":
				enemy = new Enemy(6, 3, 3, 6);
				break;
			case "Wanderer":
				enemy = new Enemy(6, 2, 3, 6);
				break;
			case "Mercenary":
				enemy = new Enemy(7, 4, 3, 9);
				break;
			default:
				System.out.println("Invalid enemy type entered.");
				enemy = new Enemy(0, 0, 0, 0);
		}
		return enemy;
	}
	
	protected Enemy boss(String area) {
		Enemy enemy = null;
		switch (area) {
		//case for each area
			default:
				System.out.println("Invalid Location entered");
				enemy = new Enemy(0, 0, 0, 0);
		}
		return enemy;
	}
	
	protected void levelScale() {
		//compare character str with enemy def, character def with enemy str.  If character str and def > enemy's, increase all enemy stats by 1
	}
}
