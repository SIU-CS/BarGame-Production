package edu.siu.bargame;

import java.util.InputMismatchException;
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
	public static Character player;
	
	public Character() {
		
	}
	
	public Character(int strength, int defense, int hp) {
		this.str = strength;
		this.def = defense;
		this.maxHp = hp;
		this.curHp = hp;//set current to max at start
	}
	
	public void createCharacter() {
		//player = new Character(); // created at initiation
		System.out.println("Enter your gender.  M or F.");
		Scanner sex = new Scanner(System.in);
		
		String gender = sex.nextLine();
		boolean genderSet = false;
		do{//loop to ensure that inputs are a "m" or "f"
			try{
				
				if (gender.equalsIgnoreCase("M")  || gender.equalsIgnoreCase("F")) {//ignores case
					this.gender = gender;
					genderSet = true;
					break;
				}
				else{
					System.out.println("Invalid gender type, try again ");
					gender = sex.nextLine();
				}
			}
			catch(Exception e){
				System.out.println(e);
				System.out.println("Try again");
			}
			}
		 while(genderSet == false);
		

		
		System.out.println("Briefly Describe yourself.");
		String description;
		Scanner playerDescription = new Scanner(System.in);
		description = playerDescription.nextLine();
		this.playerDescription = description;
		System.out.println("Please enter the Hero's name.");
		Scanner name = new Scanner(System.in);
		String title = name.next();
		this.name = title;
	}
	
	public Character getHero() {
		return player;
	}

	public void setHero(Character hero) {
		this.player = hero;
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
		this.name = name;
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
	
	public int HealthDiff( Character player, Character opponent){
		int healthDiff;
		
		if((healthDiff = opponent.getStr() - player.getDef()) < 0){
			System.out.println("The attack was weak");
			return healthDiff = 1;
		}
		else 
			return healthDiff = opponent.getStr()- player.getDef();
		//player.setCurHp(player.getCurHp() - (opponent.getStr() - player.getDef()));
	}
	
	public String PrintStats(){ // print notable stats
		return "Attack: " + getStr() + " Defense: "+ getDef() + " HP: " + getCurHp() + "/" + getMaxHp() +
					" Current Level: " + getLevel();  
	}
	
	@Override
	public String toString(){//print player details
		return "Name: " + getName() + "\n" + "Gender: " + getGender() + " \n" + "Bio: " + getPlayerDescription() + "\n" ;
			
	}
	
}