package edu.siu.bargame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Character player = new Character(7,7,60);
		player.createCharacter();
		player.setHero(player);
		System.out.print(player);
		System.out.println(player.PrintStats());
		
		Battle.battle();
	}

}
