package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory{

	public static String Target;
	
	protected static void battle() {
		//Enemy opponent = new Enemy(7,4,3,9);
		Enemy opponent = Enemy.typeOfEnemy("Mercenary");//new Enemy(7, 4, 3, 9);
		
		System.out.println("A " + opponent.getTypeOfEnemy() + " challenges you!");
		System.out.println(opponent.getTypeOfEnemy() +" "+" HP: "+ opponent.getCurHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("");
		
		int battleChoice;
		Scanner option = new Scanner(System.in);
		
		
		while (player.getCurHp() >= 0 || opponent.getCurHp() >= 0){
			
			
			System.out.println("\nPress 1 to attack.\tPress 2 to use an item.\nPress 3 to run.\n");
			battleChoice = option.nextInt();
			
		if (battleChoice == 1) {
			System.out.println("-------------------------fight----------------------------\n");
			//System.out.println(((Enemy) opponent).getTypeOfEnemy() + " attacks first ");

			if (player.getStr() > opponent.getStr()) {
				System.out.println("You attack first ");
			
			    attack(opponent, "npc");
			    
			    if (opponent.getCurHp() <= 0 ){
			    	break;
			    }
			    
			    else
			    	System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    	attack(player, "player");
			    	
			    
				}
			
			    else {
			    System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    attack(player, "player");
			    attack(opponent,"npc");
			    }
			
			
			if(player.getCurHp() <= 0){
				System.out.println(player.getCurHp() + " You lose ");
				break;
				
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
					break;
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
	
	
	
	protected static void attack(Character opponent, String type){
		
		
		Target = type;
		if (Target == "npc"){
		
			System.out.println("Your attack: " + player.getStr() + " " + ((Enemy) opponent).getTypeOfEnemy() + " Defence: " + opponent.getDef());
			System.out.println("Total damage: " + opponent.HealthDiff(opponent, player)) ;
			opponent.setCurHp(opponent.getCurHp() - opponent.HealthDiff(opponent, player) );
			System.out.println("Opponent's health is " + opponent.getCurHp());
		
		}
			else if (Target == "player"){
				
			System.out.println(  " Enemy attack: " + opponent.getStr() + " " +  " Your Defence: " + player.getDef());
			System.out.println("Total damage: " + player.HealthDiff(player, opponent));	
			player.setCurHp(player.getCurHp() - player.HealthDiff(player, opponent));
			System.out.println("You're current health is "+ player.getCurHp());
			}
		}
	}

