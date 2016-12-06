package edu.siu.bargame;
import java.util.Scanner;
import java.util.Random;

public class PvPBattle extends Inventory{
	private int Sdiff;
	Random ran= new Random();
	Scanner kb = new Scanner(System.in);
	
	
	protected void BattlePrompt(){
		System.out.println("enemy name has challenged you to a battle and you cannot escape");
		System.out.println("The Player with the highest Strength will attack first, or if equal will be chosen at random");
		
	}
	protected void PlayerBattle(Character x, Character y){
		
		BattlePrompt();
		int q=PlayerStart(x,y);
		if(q==1){
			System.out.println(x.getName()+"will attack first"); 
			while(x.getCurHp() >= 0 || y.getCurHp() >=0){
				battleOptions(x,y);
				battleOptions(y,x);
				if(x.getCurHp()==0){
					System.out.println(y.getName()+" has won. gold won: "+x.getGold());
					y.setGold(y.getGold()+x.getGold());
					x.setGold(0);
				}
				if(y.getCurHp()==0){
					System.out.println(x.getName()+" has won. gold won: "+y.getGold());
					x.setGold(x.getGold()+y.getGold());
					y.setGold(0);
				}
		}
		}
		if(q==2){
			System.out.println(y.getName()+"will attack first");
			while(x.getCurHp() >= 0 || y.getCurHp() >=0){
				battleOptions(y,x);
				battleOptions(x,y);
				if(x.getCurHp()==0){
					System.out.println(y.getName()+" has won. gold won: "+x.getGold());
					y.setGold(y.getGold()+x.getGold());
					x.setGold(0);
				}
				if(y.getCurHp()==0){
					System.out.println(x.getName()+" has won. gold won: "+y.getGold());
					x.setGold(x.getGold()+y.getGold());
					y.setGold(0);
				}
		}
			
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
				else
					System.out.println("Please enter valid response");
			}
		
	}
    	
	protected int PlayerStart(Character x, Character y){
		int start;
		int strn1= x.getStr();
		int strn2= y.getStr();
		if(strn1>strn2){
			System.out.println(x.getName()+"will attack first"); 
			start=1;
		}
		else if(strn2>strn1){
			System.out.println(y.getName()+"will attack first");
			start=2;
		}
		else{
			System.out.println("Will be chosen at random");
			int p1=1;
			int p2=2;
			int rand= ranGen();
			if(p1==rand){
				System.out.println(x.getName()+"will attack first");
				start=1;
				
			}
			else
				System.out.println(y+"will attack first");
				start=2;
		}
		return start;
	}
	
	protected int ranGen(){
		int x= ran.nextInt(2-1+1)+1;
		return x;
	}
}
