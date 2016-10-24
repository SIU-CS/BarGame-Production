package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory{

	protected static void battle() {
		Enemy opponent = Enemy.typeOfEnemy("Mercenary");//new Enemy(7, 4, 3, 9);
		opponent = new Enemy(7,4,3,9);
		System.out.println("HP: "+player.getCurHp() + " Attack: "+ player.getStr() + " Defense: "+ player.getDef());
		
		System.out.println("A mercenary challenges you!");
		System.out.println("HP: "+opponent.getHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("\nPress 1 to attack.\tPress 2 to use an item.\nPress 3 to run.\n");
		String battleChoice;
		Scanner option = new Scanner(System.in);
		battleChoice = option.next();
		
		if (battleChoice == "1") {
			attack(opponent);
			if (opponent.getHp() <= 0) {
				player.setExp(player.getExp() + opponent.getExpGiven());
				//gold determined by battle location, specific
				player.levelUp();
				System.out.println("Player Victory!");
			}
			
			else if (player.getCurHp() <= 0) {
				System.out.println("Player Loss.");
				//game reset method
			}
			
			else {
				battle();
			}
		}
		
		else if (battleChoice == "3") {
			Random random = new Random();
				if (random.nextInt(100) <= 50) {
					System.out.println("Unable to Escape!");
				}
				
				else {
					//battle exit method
					System.out.println("Successfully escaped!");
				}
		}
		
		else if (battleChoice == "2") {
			printBattleItems();
			System.out.println("Enter the name of the item you want to use.  Enter 1 to return to the previous screen.");//method to use item
			Scanner battleItem = new Scanner(System.in);
			String item = battleItem.next();
			useItem(item);
			battle();
		}
	}
	
	protected static void attack(Enemy opponent){
		
		if (player.getStr() > opponent.getDef()) {
			opponent.setHp(player.getStr() - opponent.getDef() - 1);
			System.out.println(opponent.getHp());
		}
		
		if (opponent.getStr() > player.getDef()) {
			player.setCurHp(opponent.getStr() - player.getDef());
			System.out.println(player.getCurHp());
		}
	}
}
