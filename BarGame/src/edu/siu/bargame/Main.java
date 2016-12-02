package edu.siu.bargame;

public class Main {

	public static void main(String[] args) throws Exception {

	
/*		Character player = new Character(5, 4, 10);
		player.createCharacter();
		player.setHero(player);
		
		System.out.println(Story.story[0]);
		System.out.println(player.PrintStats() + "\n");
		System.out.println(player.toString() + "\n");

		Inventory inv = new Inventory();
		inv.setStartItems();
		Inventory.printBattleItems();
		inv.printKeyItems();
		inv.printEquipment();*/
		
		/*GameSave.save("save1.txt");
		GameSave.load("save1.txt");
		
		inv.addBattleItem("Test");
		Inventory.removeBattleItem("potion");
		player.setLevel(50);
		player.setCurHp(2);
		player.setStr(15);
		
		GameSave.save("save1.txt");
		GameSave.load("save1.txt");
		
		System.out.println(player.PrintStats() + "\n");
		System.out.println(player.toString() + "\n");
		Inventory.printBattleItems();
		inv.printKeyItems();
		inv.printEquipment();
		
		Battle.battle("Soldier");*/
		//Forest forest = new Forest();
		//forest.menu();
		//player.setLevel(3);
		//Battle.battle();
		
		
		

	 				MenuUI UInterface = new MenuUI();
	 				Character player = new Character(2, 2, 2);
	 				player.createCharacter();
	 				System.out.println("");
	 				System.out.println(player + "");
	 				Inventory inv = new Inventory();
	 				inv.setStartItems();
	 				
	 				Boolean game = true;
	 				
	 				while (game) {
	 					int temp = 0;
	 					UInterface.Interface();
	 					temp = UInterface.getChoice();

			switch (temp) 
{
				case 1:
					// Converse with nearby npc's
					// Explore surrounding
					// Can put any enemy we want here 
					Battle.battle();
					break;
				case 2:
					inv.printBattleItems();
				    inv.printEquipment();
				    inv.printKeyItems();
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
}
}