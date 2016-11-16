package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Enemy extends Character {
	protected int hp;
	protected int strength;
	protected int defense;
	protected int expGiven;
	private static String typeValue;
	protected String Loot;
	Random rn = new Random();
	Scanner kb = new Scanner(System.in);
	String [] dropItems={"Gold","Sword","Potion"};
	
	
	
	public Enemy(int hp, int str, int def, int expGiven) {
		this.hp = hp;
		this.strength = str;
		this.defense = def;
		this.expGiven = expGiven;
	
	}
	public int genRandom(){
		int i =rn.nextInt(3);
		return i;
		
	}
	public void getDrop(){
		Loot=dropItems[genRandom()];
		System.out.println("The enemy dropped"+Loot+"Would you like to pick it up?");
		String x=kb.nextLine();
		if(x.equalsIgnoreCase("yes"))
		{
			//add item to inventory
		}
		else
		{
			//exit battle menu
		}
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
		return strength;
	}
	public void setStr(int str) {
		this.strength = str;
	}
	public int getDef() {
		return defense;
	}
	public void setDef(int def) {
		this.defense = def;
	}
	
	public static Enemy typeOfEnemy(String type) {
		typeValue = type;
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
			case "Boss":
				enemy = new Enemy(20 , 5, 10, 9);
				break;
			default:
				System.out.println("Invalid enemy type entered.");
				enemy = new Enemy(0, 0, 0, 0);
		}
		return enemy;
	}
	
/*	protected Enemy boss(String area) {
		Enemy enemy = null;
		switch (area) {
		//case for each area
			default:
				System.out.println("Invalid Location entered");
				enemy = new Enemy(0, 0, 0, 0);
		}
		return enemy;
	}*/
	
	public String getTypeOfEnemy(){
		return typeValue;
		
	}
	
	protected void levelScale() {
		//compare character str with enemy def, character def with enemy str.  If character str and def > enemy's, increase all enemy stats by 1
	}
}
