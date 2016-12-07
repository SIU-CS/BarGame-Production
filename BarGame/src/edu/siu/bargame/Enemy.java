package edu.siu.bargame;

import java.util.Random;

public class Enemy extends Character {
	protected int hp;
	protected int str;
	protected int def;
	protected int expGiven;
	private static String typeValue;
	
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
		int scale;
		Random random = new Random();
		if (player.getCurrentLocation() == "Forest") {
			scale = random.nextInt(3) + 1;
		}
		else if (player.getCurrentLocation() == "Town") {
			scale = random.nextInt(6) + 1;
		}
		else {
			scale = random.nextInt(9) + 1;
		}
		Enemy enemy = null;
		switch (scale) {
			case 1:
				enemy = new Enemy(8, 4, 3, 10);
				typeValue = "Soldier";
				break;
			case 2:
				enemy = new Enemy(10, 2, 1, 5);
				typeValue = "Undead";
				break;
			case 3:
				enemy = new Enemy(3, 2, 0, 3);
				typeValue = "Spider";
				break;
			case 4:
				enemy = new Enemy(6, 3, 3, 6);
				typeValue = "Bandit";
				break;
			case 5:
				enemy = new Enemy(6, 2, 3, 6);
				typeValue = "Wanderer";
				break;
			case 6:
				enemy = new Enemy(7, 4, 3, 9);
				typeValue = "Mercenary";
				break;
			case 7:
				enemy = new Enemy(20, 6, 12, 10);
				typeValue = "Golem";
				break;
			case 8:
				enemy = new Enemy(18, 9, 7, 10);
				typeValue = "Wyvern";
				break;
			case 9:
				enemy = new Enemy(15, 10, 4, 11);
				typeValue = "Sorceror";
			default:
				System.out.println("Invalid enemy type entered.");
				enemy = new Enemy(0, 0, 0, 0);
		}
		enemy.levelScale();
		return enemy;
	}
	
	protected static Enemy boss() {
		Enemy enemy = null;
		switch (player.currentLocation) {
		case "Forest":
			enemy = new Enemy(43, 23, 16, 400);
			typeValue = "Undead War Mammoth";
			break;
		case "Town":
			enemy = new Enemy(86, 49, 24, 800);
			typeValue = "Monstrous Two-Headed Snake";
			break;
		case "Castle":
			enemy = new Enemy(150, 76, 40, 1200);
			typeValue = "Fell Dragon";
			default:
				System.out.println("Invalid Location entered");
				enemy = new Enemy(0, 0, 0, 0);
		}
		return enemy;
	}
	
	public String getTypeOfEnemy(){
		return typeValue;
		
	}
	
	protected void levelScale() {
		int scale = player.getLevel();
		Random random = new Random();
		this.str = this.str + (scale * (random.nextInt(3) +1));
		this.def = this.def + (scale * (random.nextInt(2) + 1));
		this.hp = this.hp + (scale * (random.nextInt(4) + 1));
		this.expGiven = this.expGiven + (scale * (random.nextInt(5) + 1));
	}
}