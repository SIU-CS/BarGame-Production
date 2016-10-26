package edu.siu.bargame;

public class Main {

	public static void main(String[] args) {
		Inventory inv = new Inventory();
		inv.initArray();
		inv.setStartItems();
		
		Character player = new Character(20,20,40);
		Enemy en1= new Enemy(20,15,15,25);//victory, 20, 15, 15, 25; victory with item, 27, 23, 14, 25; run and lose, 40, 30, 20, 80
		
		player.createCharacter();
		player.setHero(player);
		
		System.out.print(player);
		System.out.println(player.PrintStats());
		
		Battle.battle(en1);//After using an item, does not update battleItems list
	}

}