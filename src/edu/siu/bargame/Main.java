package edu.siu.bargame;

public class Main {

	public static void main(String[] args) {
		
		
		MenuUI UInterface = new MenuUI();
		
		
		Character player = new Character(7,10,10);
		player.createCharacter();
		player.setHero(player);
		//Enemy opponent = Enemy.typeOfEnemy("Mercenary");
		
		System.out.println("");
		System.out.println(player + "");
		
		
		Inventory inventory = new Inventory();
		inventory.setStartItems();
		
		//UInterface.Interface();
		//UInterface.getChoice();
		
		Boolean game = true;
		
		while(game){
			
			UInterface.Interface();
			//UInterface.getChoice();
			switch (UInterface.getChoice()) {
				case 1:
					// Converse with nearby npc's
					// Explore surrounding
					// Can put any enemy we want here 
					Battle.battle("Undead");
					break;
				case 2:
					inventory.printBattleItems();
				    inventory.printEquipment();
				    inventory.printKeyItems();
				    break;
				case 3:
					System.out.println(player.PrintStats());
					break;
				case 4:
					//game save
					break;
				case 5:
					game = false;
					System.out.println("Game Over, thanks for playing. ");
					break;
						
		}
			
		}
	    
		
		//Battle.battle("Undead");
		//System.out.println(player.PrintStats());
		//inventory.printBattleItems();
	    //inventory.printEquipment();
	    //inventory.printKeyItems();
		//Battle.battle("Mercenary");
		//Battle.battle("Boss");
		//Battle.attack(opponent);
	}

}
