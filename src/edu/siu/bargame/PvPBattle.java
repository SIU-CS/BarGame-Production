
package edu.siu.bargame;
import java.util.Scanner;
import java.util.Random;

public class PvPBattle extends Inventory{
	Random ran= new Random();
	Scanner kb = new Scanner(System.in);
	private boolean bat1=true;
	private boolean bat2=true;
	private boolean cont=true;
	private int damage;
	protected void BattlePrompt(Character x, Character y){
		System.out.println( x.getName()+" has challenged you to a battle and you cannot escape");
		System.out.println("The Player with the highest Strength will attack first, or if equal will be chosen at random");
		
	}
	protected void damageCalc(Character x, Character y){
		int p1=(x.getStr()+x.getDef());
		int p2=(y.getStr()+y.getStr());
		int diff1=p1-p2;
		int diff2=p2-p1;
		if(diff1>0 & diff2<=0){
			setDamage1(diff1);
			
		}
		
		else
			setDamage1(ranGen()*3);
			
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage1(int damage) {
		this.damage = damage;
	}
	protected void PlayerBattle(Character x, Character y){
		
		BattlePrompt(x,y);
		int q=PlayerStart(x,y);
		if(q==1){
			while(bat1==true){
				
				if(y.getCurHp()<=0){
					System.out.println(y.getName()+" has been defeated");
					System.out.println(x.getName()+" has won, gold won: "+y.getGold());
					x.setGold(x.getGold()+y.getGold());
					y.setGold(0);
					
					bat1=false;
				}
				else if(y.getCurHp()>0){
					battleOptions(x,y);
					
						
				}
				else if(x.getCurHp()<=0){
					System.out.println(x.getName()+"has been defeated");
					System.out.println(y.getName()+" has won. gold won: "+x.getGold());
					y.setGold(x.getGold()+y.getGold());
					x.setGold(0);
					bat1=false;
				}
				
				else if(x.getCurHp()>0){
					battleOptions(y,x);
			
				}
		}
		}
		else if(q==2){
			while(bat2==true){
				if(x.getCurHp()<=0)	{
					System.out.println(y.getName()+" has won. gold won: "+x.getGold());
					y.setGold(y.getGold()+x.getGold());
					x.setGold(0);
					bat2=false;
				}
				else if(x.getCurHp()>0){
					battleOptions(y,x);
					
				}
				else if(y.getCurHp()<=0)
				{
					System.out.println(x.getName()+" has won. gold won: "+y.getGold());
					x.setGold(x.getGold()+y.getGold());
					y.setGold(0);
					bat2=false;
					
				}
				
				else if(y.getCurHp()>0){
							battleOptions(x,y);
				}
				
		}
		}
		
	}
	protected void attack(Character x, Character y){
			System.out.println(x.getName()+" strength: "+x.getStr()+" defense: "+x.getDef());
			damageCalc(x,y);
			y.setCurHp(y.getCurHp()-getDamage());
			System.out.println("Damage done: "+getDamage());
			System.out.println(y.getName()+" current health: "+y.getCurHp());
			
	}
	protected void battleOptions(Character x, Character y){
		boolean bopt= true;
		while(bopt==true){
			System.out.println("Currently Attacking: "+x.getName()+" Strength: "+x.getStr()+" Defense: "+x.getDef()+" HP: "+x.getCurHp());
			System.out.println("Currently Defending: "+y.getName()+" strength: "+y.getStr()+" defense "+y.getDef()+" HP: "+y.getCurHp());
			System.out.println("Press 1 to attack your opponent, or 2 to use an item");
			int opt= kb.nextInt();
				if(opt==1){
					attack(x,y);
					bopt=false;
				}
				else if(opt==2){
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
		int start = 0;
		int strn1= x.getStr();
		int strn2= y.getStr();
		if(strn1>strn2){
			System.out.println(x.getName()+" will attack first"); 
			start=1;
		}
		else if(strn2>strn1){
			System.out.println(y.getName()+" will attack first");
			start=2;
		}
		else if(strn2==strn1){
			System.out.println(x.getName()+" will attack first");
		}
		return start;
	}
	
	protected int ranGen(){
		int x= ran.nextInt(2-1+1)+1;
		return x;
	}
}
