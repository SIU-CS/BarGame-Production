package edu.siu.bargame;

public class Main {

	public static void main(String[] args) throws Exception {

	
		Character player = new Character(5, 5, 15);
		player.createCharacter();
		player.setHero(player);
		System.out.println(player.PrintStats() + "\n");
		System.out.println(player.toString() + "\n");

		Inventory inv = new Inventory();
		inv.setStartItems();
		Inventory.printBattleItems();
		inv.printKeyItems();
		inv.printEquipment();
		
		GameSave.save("save1.txt");
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
		
		Battle.battle("Soldier");
		//Forest forest = new Forest();
		//forest.menu();
		
	}

}