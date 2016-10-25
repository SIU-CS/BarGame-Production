package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory{

	protected static void battle() {
		//Enemy opponent = new Enemy(7,4,3,9);
		Enemy opponent = Enemy.typeOfEnemy("Mercenary");//new Enemy(7, 4, 3, 9);
		
		System.out.println("HP: "+ player.getCurHp() + " Attack: "+ player.getStr() + " Defense: "+ player.getDef());
		
		System.out.println("A mercenary challenges you!");
		System.out.println("Mercenary's stats: "+" HP: "+ opponent.getCurHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("");
		
		int battleChoice;
		Scanner option = new Scanner(System.in);
		
		
		while (player.getCurHp() >= 0 || opponent.getCurHp() >= 0){
			
			
			System.out.println("\nPress 1 to attack.\tPress 2 to use an item.\nPress 3 to run.\n");
			battleChoice = option.nextInt();
			
		if (battleChoice == 1) {
			System.out.println("-------------------------fight----------------------------\n");
			
			attack(opponent);
			
			if (opponent.getCurHp() <= 0) {
				player.setExp(player.getExp() + opponent.getExpGiven());
				//gold determined by battle location, specific
				player.levelUp();
				System.out.println("Player Victory!");
				break;
			}
			
			else if (player.getCurHp() <= 0) {
				System.out.println("Player Loss.");
				break;
				//game reset method
			}
			
			
			
		}
		
		else if (battleChoice == 3) {
			Random random = new Random();
				if (random.nextInt(100) <= 50) {
					System.out.println("Unable to Escape!");
				}
				
				else {
					//battle exit method
					System.out.println("Successfully escaped!");
				}
		}
		
		else if (battleChoice == 2) {
			printBattleItems();
			System.out.println("Enter the name of the item you want to use.  Enter 1 to return to the previous screen.");//method to use item
			Scanner battleItem = new Scanner(System.in);
			String item = battleItem.next();
			useItem(item);
			battle();
		}
	}
		System.out.println("Game over");
	}
	
	
	
	protected static void attack(Character opponent){
		
		if (player.getStr() > opponent.getStr()) {
			System.out.println("You attack first ");
			
			opponent.setCurHp(opponent.getCurHp() - (player.getStr() - opponent.getDef()) );
			System.out.println("Opponent's health is " + opponent.getCurHp());
		}
		
		if (opponent.getStr() > player.getStr()) {
			System.out.println(((Enemy) opponent).getTypeOfEnemy() + " Is Stronger and attacks first ");
			player.setCurHp(player.getCurHp() - (opponent.getStr() - player.getDef()));
			System.out.println("You're current health is "+player.getCurHp());
		}
	}
}
