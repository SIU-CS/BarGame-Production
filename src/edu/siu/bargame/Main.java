package edu.siu.bargame;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {

		
		
		
		
		
		Shop myShop = new Shop();
		Character player = new Character(7,10,10);
		player.createCharacter();
		player.setHero(player);
		Inventory inventory = new Inventory();
		inventory.setStartItems();
		player.setGold(500);
		//myShop.Shopping(player, inventory);
		
		
		inventory.printBattleItems();
		
		
		
		
	//	/Character player1 = new Character(8,11,11);
	// * int x= ran.nextInt(2-1+1)+1;
		
		
		//player1.createCharacter();
	//	player1.setHero(player1);
		//Enemy opponent = Enemy.typeOfEnemy("Mercenary");
		
	//	PvPBattle b = new PvPBattle();
		
	//	b.PlayerBattle(player,player1);
		//Inventory inventory = new Inventory();
		//inventory.setStartItems();
	    //inventory.printBattleItems();
	    //inventory.printEquipment();
	    //inventory.printKeyItems();
		
			Battle.battle("Undead",inventory);
		//Battle.battle("Mercenary");
		//Battle.battle("Boss");
		//Battle.attack(opponent);
	}

}
