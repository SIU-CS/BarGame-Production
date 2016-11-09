package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory{
	
	static boolean escape = true;
	
	protected static void battle(Enemy opponent) {
		/*Enemy opponent = Enemy.typeOfEnemy("Mercenary");*///new Enemy(7, 4, 3, 9);
		
		System.out.println(player.getName() + " HP: "+player.getCurHp() + " Attack: "+ player.getStr() + " Defense: "+ player.getDef());
		
		System.out.println("A mercenary challenges you!");
		System.out.println("Enemy HP: "+opponent.getHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("\nPress 1 to attack.\tPress 2 to use an item.\nPress 3 to run.\n");
		int battleChoice;
		Scanner option = new Scanner(System.in);
		battleChoice = option.nextInt();
		
		if (battleChoice == 1) {
			option1(opponent);
		}
		else if (battleChoice == 2) {
			option2(opponent);
		}
		else if (battleChoice == 3) {
			if (escape = true) {
			option3(opponent);
			}
			else {
				System.out.println("There is no escape.");
				battle(opponent);
			}
		}
	}

	private static void option2(Enemy opponent) {
		printBattleItems();
		System.out.println("Enter the name of the item you want to use.  Enter 1 to return to the previous screen.");
		Scanner battleItem = new Scanner(System.in);
		String item = battleItem.next();
		useItem(item.toLowerCase());
		battle(opponent);
	}

	private static void option3(Enemy opponent) {
		Random random = new Random();
			if (random.nextInt(100) <= 50) {
				System.out.println("Unable to Escape!");
				escape = false;
				battle(opponent);
			}
			
			else {
				System.out.println("Successfully escaped!");
			}
	}

	private static void option1(Enemy opponent) {
		attack(opponent);
		if (opponent.getHp() <= 0) {
			player.setExp(player.getExp() + opponent.getExpGiven());
			//gold determined by battle location, specific
			player.levelUp();
			if (escape = false) {
				escape = true;
			}
			System.out.println("Player Victory!");
		}
		
		else if (player.getCurHp() <= 0) {
			if (escape = false) {
				
			}
			System.out.println("Player Loss.");
			//game reset method
		}
		
		else {
			battle(opponent);
		}
	}
	
	protected static void attack(Enemy opponent){
		
		if (player.getStr()>opponent.getDef()) {
			opponent.setHp(opponent.getHp()-(player.getStr() - opponent.getDef()));
		}
		else {
			opponent.setHp(opponent.getHp() - 1);
		}
		
		
		if (opponent.getStr() > player.getDef()) {
			player.setCurHp(player.getCurHp()-(opponent.getStr() - player.getDef()));
			
		}
	}
}