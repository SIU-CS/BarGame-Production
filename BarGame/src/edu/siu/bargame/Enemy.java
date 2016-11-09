package edu.siu.bargame;

public class Enemy extends Character {
	protected int hp;
	protected int str;
	protected int def;
	protected int expGiven;
	protected static String typeValue;
	
	
	public Enemy(int hp, int str, int def, int expGiven) {
		this.hp = hp;
		this.str = str;
		this.def = def;
		this.expGiven = expGiven;
	}
	public String getTypeValue() {
		return typeValue;
	}
	public int getExpGiven() {
		return expGiven;
	}
	public void setExpGiven(int expGiven) {
		this.expGiven = expGiven;
	}
	public int getCurHp() {
		if(hp < 0)
			hp = 0;
		return hp;
	}
	public void setCurHp(int hp) {
		this.hp = hp;
	}
	@Override
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	
	public static Enemy typeOfEnemy() {
		Enemy enemy = null;
		int type = (int) (Math.random()*50);
		if (type <= 50) {
			typeValue = "Soldier";
			enemy = new Enemy(10, 2, 2, 4);
			levelScale(enemy);
		}
		/*switch (type) {
			case "Soldier":
				typeValue = "Soldier";
				enemy = new Enemy(8, 4, 3, 10);
				break;
			case "Undead":
				typeValue = "Undead";
				enemy = new Enemy(10, 2, 1, 5);
				break;
			case "Spider":
				typeValue = "Spider";
				enemy = new Enemy(3, 2, 0, 3);
				break;
			case "Bandit":
				typeValue = "Bandit";
				enemy = new Enemy(6, 3, 3, 6);
				break;
			case "Wanderer":
				typeValue = "Wanderer";
				enemy = new Enemy(6, 2, 3, 6);
				break;
			case "Mercenary":
				typeValue = "Mercenary";
				enemy = new Enemy(7, 4, 3, 9);
				break;
			/*case "Boss":
				enemy = new Enemy(20 , 5, 10, 9);
				break;
			default:
				System.out.println("Invalid enemy type entered.");
				enemy = new Enemy(0, 0, 0, 0);
		}*/
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
	
	public String getTypeOfEnemy(){
		return typeValue;
		
	}
	
	protected static void levelScale(Enemy enemy) {
		enemy.setMaxHp(enemy.getMaxHp()*player.getLevel());
		enemy.setDef(enemy.getDef()*player.getLevel()-3);
		enemy.setStr(player.getLevel()*enemy.getStr()-5);
		enemy.setExpGiven(player.getLevel() + 2*enemy.getExpGiven());
	}
}