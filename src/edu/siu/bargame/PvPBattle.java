<<<<<<< HEAD
package edu.siu.bargame;
import java.util.Scanner;
import java.util.Random;

public class PvPBattle extends Inventory{
	private int Sdiff;
	Random ran= new Random();
	Scanner kb = new Scanner(System.in);
	
	
	protected void BattlePrompt(){
		System.out.println("enemy name has challenged you to a battle and you cannot escape");
		System.out.println("The Player with the highest Strength will attack first");
		
	}
	protected void PlayerBattle(Character x, Character y){
		
		BattlePrompt();
		boolean battle = true;
		PlayerStart(x,y); 
		while(x.getCurHp() >= 0 || y.getCurHp() >=0){
			
		}
		
	}
	protected void attack(Character x, Character y){
		
			y.setCurHp(y.getCurHp()-2);
			System.out.println("");
			System.out.println(y.getName()+" current health: "+y.getCurHp());
			
	}
	protected void battleOptions(Character x, Character y){
		boolean bopt= true;
		while(bopt==true){
			System.out.println("Press 1 to attack your opponent, or 2 to use an item");
			int opt= kb.nextInt();
				if(opt==1){
					attack(x,y);
					bopt=false;
				}
				if(opt==2){
					printBattleItems();
					System.out.println("Enter the name of the item you want to use. Enter exit to return to the previous screen.");
					Scanner battleItem = new Scanner(System.in);
					String item = battleItem.next();
					useItem(item);
				}
			}
		
	}
    	
	protected void PlayerStart(Character x, Character y){
		int strn1= x.getStr();
		int strn2= y.getStr();
		if(strn1>strn2){
			System.out.println(x.getName()+"will attack first"); 
			attack(x, y);
		}
		else if(strn2>strn1){
			System.out.println(y.getName()+"will attack first");
			attack(y,x);
		}
		else{
			System.out.println("Will be chosen at random");
			int p1=1;
			int p2=2;
			int rand= ranGen();
			if(p1==rand){
				System.out.println(x.getName()+"will attack first");
				attack(x,y);
				
			}
			else
				System.out.println(y+"will attack first");
				attack(y,x);
		}
	}
	
	protected int ranGen(){
		int x= ran.nextInt(2-1+1)+1;
		return x;
	}
}
=======
package edu.siu.bargame;
import java.util.Scanner;
import java.util.Random;

public class PvPBattle extends Inventory{
	private int Sdiff;
	Random ran= new Random();
	Scanner kb = new Scanner(System.in);
	
	
	protected void BattlePrompt(){
		System.out.println("enemy name has challenged you to a battle and you cannot escape");
		System.out.println("The Player with the highest Strength will attack first");
		
	}
	protected void PlayerBattle(Character x, Character y){
		
		BattlePrompt();
		boolean battle = true;
		PlayerStart(x,y); 
		while(x.getCurHp() >= 0 || y.getCurHp() >=0){
			
		}
		
	}
	protected void attack(Character x, Character y){
		
			y.setCurHp(y.getCurHp()-2);
			System.out.println("");
			System.out.println(y.getName()+" current health: "+y.getCurHp());
			
	}
	protected void battleOptions(Character x, Character y){
		boolean bopt= true;
		while(bopt==true){
			System.out.println("Press 1 to attack your opponent, or 2 to use an item");
			int opt= kb.nextInt();
				if(opt==1){
					attack(x,y);
					bopt=false;
				}
				if(opt==2){
					printBattleItems();
					System.out.println("Enter the name of the item you want to use. Enter exit to return to the previous screen.");
					Scanner battleItem = new Scanner(System.in);
					String item = battleItem.next();
					useItem(item);
				}
			}
		
	}
    	
	protected void PlayerStart(Character x, Character y){
		int strn1= x.getStr();
		int strn2= y.getStr();
		if(strn1>strn2){
			System.out.println(x.getName()+"will attack first"); 
			attack(x, y);
		}
		else if(strn2>strn1){
			System.out.println(y.getName()+"will attack first");
			attack(y,x);
		}
		else{
			System.out.println("Will be chosen at random");
			int p1=1;
			int p2=2;
			int rand= ranGen();
			if(p1==rand){
				System.out.println(x.getName()+"will attack first");
				attack(x,y);
				
			}
			else
				System.out.println(y+"will attack first");
				attack(y,x);
		}
	}
	
	protected int ranGen(){
		int x= ran.nextInt(2-1+1)+1;
		return x;
	}
}
>>>>>>> refs/remotes/origin/master
