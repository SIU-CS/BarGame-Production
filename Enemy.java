package edu.siu.bargame;

public class Enemy {
	protected int hp;
	protected int str;
	protected int def;
	protected int expGiven;
	Enemy en1;
	
	public Enemy() {
		
	}
	
	public Enemy(int hp, int str, int def, int expGiven) {
		this.hp = hp;
		this.str = str;
		this.def = def;
		this.expGiven = expGiven;
	}
	
	
	public int getExpGiven() {
		return expGiven;
	}
	public void setExpGiven(int expGiven) {
		this.expGiven = expGiven;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
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
	public Enemy createEnemy(){
		this.en1=typeOfEnemy("Mercenary");
		return en1;
	}
	
	public Enemy getEn1() {
		return en1;
	}


	public void setEn1(Enemy en1) {
		this.en1 = en1;
	}


	public static Enemy typeOfEnemy(String type) {
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