package edu.siu.bargame;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Random ran= new Random();
		for(int i=0; i<+15; i++){
		int x= ran.nextInt(6-0);
		System.out.println(x);
		}*/
	//		Character player2
		
		Character player = new Character(7,10,10);
		Character player1 = new Character(8,11,11);
	// * int x= ran.nextInt(2-1+1)+1;
		player.createCharacter();
		player.setHero(player);
		
		player1.createCharacter();
		player1.setHero(player1);
		//Enemy opponent = Enemy.typeOfEnemy("Mercenary");
		
		PvPBattle b = new PvPBattle();
		
		b.PlayerBattle(player,player1);
		//Inventory inventory = new Inventory();
		//inventory.setStartItems();
	    //inventory.printBattleItems();
	    //inventory.printEquipment();
	    //inventory.printKeyItems();
		
		//Battle.battle("Undead");
		//Battle.battle("Mercenary");
		//Battle.battle("Boss");
		//Battle.attack(opponent);
	}

}
