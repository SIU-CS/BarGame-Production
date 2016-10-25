package edu.siu.bargame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory inv = new Inventory();
		inv.setStartItems();
		Character player = new Character(20,20,40);
		Enemy en1= new Enemy(20,20,40,50);
		player.createCharacter();
		player.setHero(player);
		
		System.out.print(player);
		System.out.println(player.PrintStats());
		
		Battle.battle(en1);
	}

}
