package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;
public class Battle extends Inventory {

	public static String Target;
	private String items[]= {"gold","jewel","food","potion"};
	
	protected static void battle( Inventory x) {
		//Enemy opponent = new Enemy(7,4,3,9);
		Enemy opponent = Enemy.typeOfEnemy();//new Enemy(7, 4, 3, 9);
		levelScale(player,opponent);
		player.setBatCounter(player.getBatCounter()+1);
		System.out.println("A " + opponent.getTypeOfEnemy() + " challenges you!");
		System.out.println(opponent.getTypeOfEnemy() +" "+" HP: "+ opponent.getCurHp() + " Attack: "+ opponent.getStr() + " Defense: "+ opponent.getDef());
		System.out.println("");
		
		int battleChoice;
		int opponentChoice = (int)(Math.random() * ((5) + 1));
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
			    	if(opponentChoice<=3){
			    	System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    	attack(opponent, "player");
			    	}
			    	else if (opponentChoice == 4 && opponent.getCurHp() != opponent.getMaxHp()){
			    		System.out.println(opponent.getTypeOfEnemy() + " Uses a potion!");
			    		opponent.setCurHp(opponent.getCurHp() + 5);
			    		System.out.println("Opponent's Current health " + opponent.getCurHp());
			    	
			    	}
			    	else if (opponentChoice == 5 && !opponent.getTypeOfEnemy().equals("Boss")){
			    		System.out.println(opponent.getTypeOfEnemy() +" ran with fear!");
			    		break;
			    	}
			    
					}
				}
			
			    else{
			    System.out.println(opponent.getTypeOfEnemy() + " attacks!");
			    attack(opponent, "player");
			    attack(opponent,"npc");
			    }
			
			
			if(player.getCurHp() <= 0){
				System.out.println( "You lose ");
				System.out.println("Game Over");
				System.exit(0);
				player.setGold(0);
			}
		
			
		player.setExp(player.getExp() + opponent.getExpGiven());
		player.levelUp();
				
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
			option2(opponent);
		}
	}
		player.levelUpCheck();
		player.setExp(player.getExp()+opponent.getExpGiven());
		System.out.println("Exp gained: "+opponent.getExpGiven());
		int exptill=(player.getExpForLevelUp()-player.getExp());
		System.out.println("Exp till level up: "+exptill);
		Battleloot(x);
		
	
	
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
						if(ranIt.equalsIgnoreCase("Gold")){
							player.setGold(player.getGold()+25);
							set2=false;
						}
						else 
							x.CheckitemType(ranIt);
							System.out.println("back to exploring");
							set2=false;
						
				}
				else if(opt2.equalsIgnoreCase("no")){
					set2=false;
					
				}
				else{
					System.out.println("Please enter a valid response");
				}
				}
				set=false;
				
			}
			else if(opt.equalsIgnoreCase("no")){
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

	private static void option2(Enemy enemy) {
		printBattleItems();
		System.out.println("Enter the name of the item you want to use.  Enter exit to return to the previous screen.");//method to use item
		Scanner battleItem = new Scanner(System.in);
		String item = battleItem.next();
		useItem(item);
		
	}
	public static void typeAttack(){
		String typeAttack = player.getplayerClass();
		switch(typeAttack){
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
				
		}
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
			System.out.println("Total damage: " + player.HealthDiff(target, player));	
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
	protected static void bossBattle(Inventory x) {
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
		if(opponent.getCurHp()<=0){
			System.out.println(opponent.getTypeOfEnemy()+" has been defeated and dropped gold");
			player.setGold(player.getGold()+100);
			player.levelUpCheck();
			player.setExp(player.getExp()+opponent.getExpGiven());
			System.out.println("Exp gained: "+opponent.getExpGiven());
			int exptill=(player.getExpForLevelUp()-player.getExp());
			System.out.println("Exp till level up: "+exptill);
			System.out.println("100 gold added, current gold: "+player.getGold());
		}
	}
	
	
}

