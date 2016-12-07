package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory{

	protected static String Target;
	private String items[]= {"gold","jewel","food","potion"};
	
	protected static void battle(Inventory x) {
		Enemy opponent = Enemy.typeOfEnemy();
		System.out.print(player.PrintStats());
		System.out.println("A " + opponent.getTypeOfEnemy() + " challenges you!");
		System.out.println(opponent.getTypeOfEnemy() +" "+" HP: "+ opponent.getCurHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("");
		
		int battleChoice;
		Scanner option = new Scanner(System.in);
		int opponentChoice = (int)(Math.random() * ((5) + 1));
		
		
		while (player.getCurHp() >= 0 || opponent.getCurHp() >= 0){
			
			System.out.println("\nPress 1 to attack.\tPress 2 to use an item.\nPress 3 to run.\n");
			battleChoice = option.nextInt();
			
		if (battleChoice == 1) {
			System.out.println("-------------------------fight----------------------------\n");

			if (player.getStr() > opponent.getStr()) {
				System.out.println("You attack first ");
			
			    attack(opponent, "npc");
			    System.out.println(" ");
			    
			    if (opponent.getCurHp() <= 0 ){
					battleLoot(x);
					player.setGold(player.getGold() + 4);
					player.setExp(player.getExp() + opponent.getExpGiven());
					player.levelUp();
			    	break;
			    }
			    
			    else{
			    	System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    	attack(opponent, "player");
			    }
			    
				}
			
			    else {
			    	if (opponentChoice <= 3) {
			    		System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    		attack(opponent, "player");
			    		attack(opponent,"npc");
			    	}
			    	else if (opponentChoice == 4 && opponent.getCurHp() < opponent.getMaxHp() - 3) {
			    		System.out.println(opponent.getTypeOfEnemy() + " Uses a potion!");
			    		opponent.setCurHp(opponent.getCurHp() + 3);
			    		System.out.println("Opponent's Current health " + opponent.getCurHp());
			    		attack(opponent, "npc");
			    	}
			       	else if (opponentChoice == 5){
			    		System.out.println(opponent.getTypeOfEnemy() +" ran with fear!");
			    		break;
			       	}
			    }
			
			
			if(player.getCurHp() <= 0){
				System.out.println( "You lose ");
				System.out.println("Game Over");
				System.exit(0);
				
			}

		}	
			
		else if (battleChoice == 3) {
			Random random = new Random();
				if (random.nextInt(100) <= 50) {
					System.out.println("Unable to Escape!");
					attack(opponent, "player");
				}
				
				else {
					System.out.println("Successfully escaped!");
					break;
				}
		}
		
		else if (battleChoice == 2) {
			option2(opponent);
		}
	}
	}

	private static void battleLoot(Inventory x) {
		System.out.println("Would you like to search your opponent for possible items?");
		Scanner kb = new Scanner(System.in);
		
				boolean set = true;
				boolean set2= true;
				String ranIt= randomItem();
				while(set){
					String opt = kb.nextLine();
					if(opt.equalsIgnoreCase("yes")){
						while(set2){
						System.out.println("Item found: "+ranIt);
						System.out.println("Would you like to take this item?");
						Scanner kb2 = new Scanner(System.in);
						String opt2 = kb2.nextLine();
						if(opt2.equalsIgnoreCase("yes")){
								x.CheckitemType(ranIt);
								set2=false;
								set = false;
						}
						else if(opt2.equalsIgnoreCase("no")){
							set2=false;
							set = false;
						}
						else{
							System.out.println("Please enter a valid response");
						}
						}
						
					}
					if(opt.equalsIgnoreCase("no")){
						System.out.println("Back to Overworld");
						set=false;
					}
					
				}
				
				
			}
			
			protected static String randomItem(){
				Random ran = new Random();
				String items[]= {"gold","jewel","food","potion","elixir"};
				int x= ran.nextInt(5-0);
				return items[x];
			}

	private static void option2(Enemy enemy) {
		printBattleItems();
		System.out.println("Enter the name of the item you want to use.  Enter exit to return to the previous screen.");
		Scanner battleItem = new Scanner(System.in);
		String item = battleItem.next();
		useItem(item);
	}
	
	
	
	protected static void attack(Character target, String type){
		
		
		Target = type;
		if (Target == "npc"){

			System.out.println("Your attack: " + player.getStr() + " " + ((Enemy) target).getTypeOfEnemy() + " Defence: " + target.getDef());
			typeAttack();
			System.out.println("Total damage: " + target.HealthDiff(target, player)) ;
			target.setCurHp(target.getCurHp() - target.HealthDiff(target, player) );
			System.out.println("Opponent's health is " + target.getCurHp());
			
		
		}
		else {
				
			System.out.println(  "Enemy attack: " + target.getStr() + " " +  " Your Defence: " + player.getDef());
			System.out.println("Total damage: " + player.HealthDiff(player, target));	
			player.setCurHp(player.getCurHp() - player.HealthDiff(player, target));
			System.out.println("You're current health is "+ player.getCurHp());
			}
		}
	
	private static void typeAttack() {
		String type = player.getPlayerClass();
		switch(type){
			case "Rogue":
				System.out.println( player.getName() +" uses Backstab");
				break;
			case "Wizard":
				System.out.println( player.getName() +" uses Pyroblast");
				break;
			case "Warrior":
				System.out.println( player.getName() +" uses Brawl");
				break;
			case "Hunter":
				System.out.println( player.getName() +" uses Poison Arrow");
				break;
			default:	
		}
		
	}
	protected static void bossBattle() {
		Enemy opponent = Enemy.boss();
		
		System.out.println("A " + opponent.getTypeOfEnemy() + " Stands Proud!");
		System.out.println(opponent.getTypeOfEnemy() +" "+" HP: "+ opponent.getCurHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("");
		
		int battleChoice;
		Scanner option = new Scanner(System.in);
		
		
		while (player.getCurHp() >= 0 || opponent.getCurHp() >= 0){
			
			System.out.println("\nPress 1 to attack.\tPress 2 to use an item.\n");
			battleChoice = option.nextInt();
			
		if (battleChoice == 1) {
			System.out.println("-------------------------fight----------------------------\n");

			if (player.getStr() > opponent.getStr()) {
				System.out.println("You attack first ");
			
			    attack(opponent, "npc");
			    System.out.println(" ");
			    
			    if (opponent.getCurHp() <= 0 ){
			    	break;
			    }
			    
			    else{
			    	System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    	attack(opponent, "player");
			    }
			    
				}
			
			    else {
			    System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    attack(opponent, "player");
			    attack(opponent,"npc");
			    }
			
			
			if(player.getCurHp() <= 0){
				System.out.println( "You lose ");
				System.out.println("Game Over");
				System.exit(0);
				
			}
			//drops, gold,
			player.levelUp();
		}			
				
		else if (battleChoice == 2) {
			option2(opponent);
		}
	}	
	}
}