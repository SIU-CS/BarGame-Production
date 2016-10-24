package Battle;
import java.util.Random;
import java.util.Scanner;
import Characters.Inventory;
import Enemy.Enemy;
public class Battle extends Inventory{

	protected void battle() {
		Enemy opponent = Enemy.typeOfEnemy("Mercenary");//new Enemy(7, 4, 3, 9);
		System.out.println("A mercenary challenges you!\nPress 1 to attack.\tPress 2 to use an item.\nPress 3 to run.\n");
		String battleChoice;
		Scanner option = new Scanner(System.in);
		battleChoice = option.next();
		
		if (battleChoice == "1") {
			attack(opponent);
			if (opponent.getHp() <= 0) {
				hero.setExp(hero.getExp() + opponent.getExpGiven());
				//gold determined by battle location, specific
				hero.levelUp();
				System.out.println("Player Victory!");
			}
			
			else if (hero.getCurHp() <= 0) {
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
	
	protected void attack(Enemy opponent) {
		if (hero.equipBonus().getStr() > opponent.getDef()) {
			opponent.setHp(hero.getStr() - opponent.getDef() - 1);
		}
		
		if (opponent.getStr() > hero.getDef()) {
			hero.setCurHp(opponent.getStr() - hero.getDef());
		}
	}
}
