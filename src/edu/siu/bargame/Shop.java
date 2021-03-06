package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;

public class Shop extends Inventory {
	Random ran= new Random();
	ShopKeeper nShkp = new ShopKeeper(30,30,30,30);
	Scanner kb= new Scanner(System.in);
	
	int battleItemPrices[] = {15,25,40};
	String battleItems[] = {"Potion","Strong Potion","Elixir"};
	String bItemsD[]={"a weak potion with minimal health boost","a strong potion with decent health boost","The Strongest elixir with maximal health boost"};
	
	String keyItems[] = {"Food","Diamond"};
	int KPrices[]={5,60};
	String keyD[]={"Small meal for miminal health boost","An expensive gem"};
	
	String equipment[] = {"Leather Armor","Iron Armor","Dragon Armor"};
	int equipPrices[] = {50,75,100};
	String equipD[]={"Weak armor but will help in battle","Strong sturdy armor","Rare armor seems to be unknown origin"};
	
	protected void displayBItems(){ 
		System.out.println("___________Battle_Items___________");
		for(int i= 0; i<3; i++){
			System.out.println(battleItemPrices[i]+" gold: "+battleItems[i]+" description: "+bItemsD[i]);
		}
	}
	protected void displayKItems(){
		System.out.println("_____________Key_Items_____________");
		for(int i= 0; i<2; i++){
			System.out.println(KPrices[i]+" gold: "+keyItems[i]+" description: "+keyD[i]);
		}
	}
	protected void displayEquip(){
		System.out.println("_____________Equipment_____________");
		for(int i=0; i<3; i++){
			System.out.println(equipPrices[i]+" gold: "+equipment[i]+" description: "+equipD[i]);
		}
	}
	
	
	protected void brawl(Character x, ShopKeeper y){
		int strn=x.getStr();
		int SKstrn=y.getStr();
		if(strn>SKstrn){
			int randomSteal=rand();
			if(randomSteal>55){
				System.out.println("You knock the Shop Keeper out, however local guards are coming so you\ndecide to leave without the item");
			}
			else{
				System.out.println("The Shop Keeper has stopped you, better luck next time");
			}
		}
		else{
			int randSteal=rand();
			if(randSteal>80){
				System.out.println("You knock the Shop Keeper out, however local guards are coming so you\ndecide to leave without the item");
			}
			else{
				System.out.println("The Shop Keeper has stopped you, better luck next time");
			}
		}
	}	
	
	protected void Shopping(Character x, Inventory q){
		boolean open=true;
		boolean BN=true;
		System.out.println("Welcome to the general store!\n feel free to look at our items or purchase any of our items.");
		boolean buy=true;
		boolean open2=true;
		boolean space=true;
		while(open==true){
			System.out.println("1) view items for sale \n\n2) buy items \n\n3)to steal items \n\n4)to exit\n");
			int opt= kb.nextInt();
				if(opt==1){
					displayShopItems();
				}
				else if(opt==2){
					while(buy==true){
					displayShopItems();
					System.out.println("What type of item would you like to buy?\nType 1 for key items\nType 2 for Battle items\nType 3 for equipment");
					int buying= kb.nextInt();
					if(buying==1){
						boolean menu=false;
						while(menu==false){
						displayKItems();
						System.out.println("what item would you like to purchase");
						displayKItems();  
						System.out.println("1 for food, 2 for diamond");
						
						int item = kb.nextInt();
						space=q.checkBItems();
						if(space==false){
							System.out.println("insufficient space in inventory please come back when space is free");
							menu=true;
							buy=false;
							open=false;
						}
						else if(x.getGold()<KPrices[item-1]){
							System.out.println("Please come back when you have sufficient gold");
							menu = true;
							buy=false;
							open=false;
						}
						else
							System.out.println("item purchased, please come again");
							q.addKeyItem(keyItems[item-1]);
							int y=KPrices[item-1];
							x.setGold(x.getGold()-y);
							menu=true;
							buy=false;
							open=false;
						}
							
					}
					if(buying==2){
						boolean menu2=false;
						while(menu2==false){
						displayBItems();
						System.out.println("what item would you like to purchase");
						System.out.println("1 for potion, 2 for strong potion, 3 for elixir");
						int item=kb.nextInt();
						space=q.checkBItems();
						if(space==false){
							System.out.println("insufficient space in inventory please come back when space is free");
							menu2=true;
							buy=false;
							open=false;
						}
						else if(x.getGold()<battleItemPrices[item-1]){
							System.out.println("Please come back when you have sufficient funds");
							menu2=true;
							buy=false;
							open=false;
						}
						else
							
							q.addBattleItem(battleItems[item-1]);
							x.setGold(x.getGold()-battleItemPrices[item-1]);
							menu2=true;
							buy=false;
							open=false;
						}
						
					}
					if(buying==3){
						boolean menu3=false;
						while(menu3==false){
						displayEquip();
						System.out.println("what item would you like to purchase");
						displayKItems();
						System.out.println("1 for Leather Armor, 2 for Iron Armor, 3 for Dragon Armor");
						int item = kb.nextInt();
						space=q.checkBItems();
						if(space==false){
							System.out.println("insufficient space in inventory please come back when space is free");
							open=false;
							buy=false;
							open=false;
						} 
						else if(x.getGold()<equipPrices[item-1]){
							System.out.println("please come back when you have sufficient funds");
							menu3=true;
							buy=false;
							open=false;
						}
						else
							System.out.println("item purchased, please come again");
							q.addEquipment(equipment[item-1]);
							menu3=true;
							buy=false;
							open=false;
					}
					}
					}
				}
				else if(opt==3){
					String item="Potion";
					steal(x,item);
					open=false;
				}
				else if(opt==4){
					open=false;
				}
				else 
					System.out.println("Please enter a valid response");
				}
	}
		
	//if( !opt.equalsIgnoreCase("steal")||!opt.equalsIgnoreCase("buy")||!opt.equalsIgnoreCase("sell")||!opt.equalsIgnoreCase("view")||!opt.equalsIgnoreCase("exit")
	private void displayShopItems() {
		displayBItems();
		displayKItems();
		displayEquip();
	}
	
	
	protected void steal(Character x, String item){
		
		//make sure it checks inventory available space, allows user to remove item if necessary or try to resell it to the shop keeper 
		  
		int val=rand();
		if(val>80){
			System.out.println("Item successfully stolen");
			CheckitemType(item);
		}
		else if(val<=80){
			System.out.println("Theft attempt unsuccesful");
			System.out.println("Now engaged in a brawl with the Shop Keeper");
				brawl( x, nShkp);
			}
			
		}

	protected int rand(){
		int x= ran.nextInt(100-1+1)+1;
		return x;
	} 
	
	 
}

class ShopKeeper{
	int hp;
	int str;
	int def;
	int CurHp;
	public ShopKeeper(int health,int curHp, int strength, int defense ){
		hp=health;
		str=strength;
		def=defense;
		CurHp=curHp;
	}
	

	public int getCurHp() {
		return CurHp;
	}


	public void setCurHp(int curHp) {
		CurHp = curHp;
	}


	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	
}