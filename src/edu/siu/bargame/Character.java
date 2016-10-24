package edu.siu.bargame;

import java.util.Scanner;

public class Character {
	protected int level = 1;
	protected int exp = 0;
	protected int str;
	protected int def;
	protected int maxHp;
	protected int curHp = maxHp;
	protected String gender;
	protected String playerDescription;
	protected String name;
	protected int expForLevelUp = 80;
	public Character hero;
	
	public Character() {
		
	}
	
	public Character(int strength, int defense, int hp) {
		this.str = strength;
		this.def = defense;
		this.maxHp = hp;
	}
	
	public void createCharacter() {
		hero = new Character(7, 7, 60);
		System.out.println("Enter your gender.  M or F.");
		Scanner sex = new Scanner(System.in);
		String gender = sex.next();
		if (gender == "M" || gender == "F") {
			this.gender = gender;
		}
		else {
			System.out.println("Error, try again.");
		}
		System.out.println("Briefly Describe yourself.");
		String description;
		Scanner playerDescription = new Scanner(System.in);
		description = playerDescription.next();
		this.playerDescription = description;
		System.out.println("Please enter the Hero's name.");
		Scanner name = new Scanner(System.in);
		String title = name.next();
		this.name = title;
	}
	
	public Character getHero() {
		return hero;
	}

	public void setHero(Character hero) {
		this.hero = hero;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
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
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int hp) {
		this.maxHp = hp;
	}
	public void setCurHp(int hp) {
		this.curHp = hp;
	}
	public int getCurHp() {
		return curHp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlayerDescription() {
		return playerDescription;
	}
	public void setPlayerDescription(String playerDescription) {
		this.playerDescription = playerDescription;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public int getExpForLevelUp() {
		return expForLevelUp;
	}
	public void setExpForLevelUp(int expForLevelUp) {
		this.expForLevelUp = expForLevelUp;
	}
	
	public void levelUp() {
		level++;
		if (exp > expForLevelUp) {
			exp -= expForLevelUp;
		}
		
		else {
			exp = 0;
		}
			expForLevelUp *= level;
		
	}
	
}