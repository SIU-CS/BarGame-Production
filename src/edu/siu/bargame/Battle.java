package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory {

	public static String Target;
	private String items[]= {"gold","jewel","food","potion","gun"};
	
	protected static void battle(String enemy, Inventory x) {
		//Enemy opponent = new Enemy(7,4,3,9);
		Enemy opponent = Enemy.typeOfEnemy(enemy);//new Enemy(7, 4, 3, 9);
		levelScale(player,opponent);
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
			//System.out.println(((Enemy) opponent).getTypeOfEnemy() + " attacks first "
			if (player.getStr() > opponent.getStr()) {
				System.out.println("You attack first ");
			
			    attack(opponent, "npc");
			    System.out.println(" ");
			    
			    if (opponent.getCurHp() <= 0 ){
			    	System.out.println();
			    	
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
				break;
				
			}
		}
			
				
				
			
			
		else if (battleChoice == 3) {
			Random random = new Random();
				if (random.nextInt(100) <= 50) {
					System.out.println("Unable to Escape!");
					attack(opponent, "player");
				}
				
				else {
					//battle exit method
					System.out.println("Successfully escaped!");
					break;
				}
		}
		
		else if (battleChoice == 2) {
			option2(enemy);
		}
	}
		Battleloot(x);
		
		System.out.println("Game over");
	
	}
	protected static void Battleloot(Inventory x){
		System.out.println("Would you like to search your opponent for possible items?");
		Scanner kb = new Scanner(System.in);
		boolean set = true;
		boolean set2= true;
		String ranIt= randomItem();
		while(set==true){
			String opt = kb.nextLine();
			if(opt.equalsIgnoreCase("yes")){
				while(set2==true){
				System.out.println("Item found: "+ranIt);
				System.out.println("Would you like to take this item?");
				String opt2 = kb.nextLine();
				if(opt2.equalsIgnoreCase("yes")){
						x.CheckitemType(ranIt);
						set2=false;
				}
				if(opt2.equalsIgnoreCase("no")){
					set2=false;
					
				}
				else{
					System.out.println("Please enter a valid response");
				}
				}
				
			}
			if(opt.equalsIgnoreCase("no")){
				System.out.println("back to exploring area");
				set=false;
			}
			else{
				System.out.println("Please enter a valid response");
			}
			
		}
		
		
	}
	
	protected static String randomItem(){
		Random ran = new Random();
		String items[]= {"gold","jewel","food","potion","elixir"};
		int x= ran.nextInt(5-0);
		return items[x];
	}
//<javac includeantruntime="false" srcdir="${src.dir}" destdir="${classes.dir}">

	private static void option2(String enemy) {
		printBattleItems();
		System.out.println("Enter the name of the item you want to use.  Enter exit to return to the previous screen.");//method to use item
		Scanner battleItem = new Scanner(System.in);
		String item = battleItem.next();
		useItem(item);
		//battle(enemy);
	}
	
	
	
	protected static void attack(Character target, String type){
		
		
		Target = type;
		if (Target == "npc"){

			System.out.println("Your attack: " + player.getStr() + " " + ((Enemy) target).getTypeOfEnemy() + " Defence: " + target.getDef());
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
	public static void levelScale(Character x, Enemy y) {
		//compare character str with enemy def, character def with enemy str.  If character str and def > enemy's, increase all enemy stats by 1
		int cStr, cDef, eStr, eDef;
		int attC=0;
		cStr= x.getStr();
		cDef= x.getDef();
		eStr= y.getStr();
		eDef= y.getDef();
		if(cStr>eStr &&  cDef > eDef){
			++attC;
		}
		y.setDef(y.getDef()+attC);
		y.setStr(y.getStr()+attC);
		y.setMaxHp(y.getMaxHp()+attC);
		
	}
	}

