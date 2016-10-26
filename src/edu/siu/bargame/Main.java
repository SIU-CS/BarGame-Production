package edu.siu.bargame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Character player = new Character(7,10,10);
		player.createCharacter();
		player.setHero(player);
		//Enemy opponent = Enemy.typeOfEnemy("Mercenary");
		
		System.out.println("");
		System.out.println(player + "");
		System.out.println(player.PrintStats());
		
		
		Inventory inventory = new Inventory();
		inventory.setStartItems();
	    inventory.printBattleItems();
	    inventory.printEquipment();
	    inventory.printKeyItems();
		
		Battle.battle("Undead");
		Battle.battle("Mercenary");
		//Battle.attack(opponent);
	}

}
