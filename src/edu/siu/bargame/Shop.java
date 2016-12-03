package edu.siu.bargame;
import java.util.Random;
import java.util.Scanner;

public class Shop extends Inventory {
	Random ran= new Random();
	Scanner kb= new Scanner(System.in);
	int battleItemPrices[] = {15,25,40};
	String battleItems[] = {"Potion","Strong Potion","Elixir"};
	
	String keyItems[] = {"Food","Diamond"};
	int KPrices[]={5,40};
	
	String equipment[] = {"Leather Armor","Iron Armor","Dragon Armor"};
	int equipPrices[] = {50,75,100};
	
	
	protected void displayBItems(){ 
		for(int i= 0; i<3; i++){
			System.out.println(battleItemPrices[i]+" gold: "+battleItems[i]);
		}
	}
	protected void displayKItems(){
		for(int i= 0; i<3; i++){
			System.out.println(KPrices[i]+" gold: "+keyItems[i]);
		}
	}
	protected void displayEquip(){
		for(int i=0; i<3; i++){
			System.out.println(equipPrices[i]+" gold: "+equipment[i]);
		}
	}
	protected void itemDscrp(){
		
	}
	protected void buyItem(Character x){
		
	}
	protected void brawl(Character x, ShopKeeper y){
		boolean brawling=true;
		while(brawling==true){
		int i= 0;
		System.out.println("Connected on a punch to the shop keeper, several more shots and he will be KO'd");
		int g = brawlGen();
		if(g>=5){
			y.setHp(y.getHp()-5);
		}
		else
			System.out.println("Weak attack on Shop keeper, virtually no damage way to be a wimp");
				y.setHp(y.getHp()-1);
		}
		int j= brawlGen();
		if(j>=5){
			System.out.println("Shop Keeper landed several combos on you, decent damage");
			x.setCurHp(x.getCurHp()-5);
		
		}
		else
			System.out.println("Shop keep landed some punches but no significant damage");
			x.setCurHp(x.getCurHp()-1));
			
			
			
	}
	protected int brawlGen(){
		int x= ran.nextInt(10-1+1)+1;
		
	}
	proteacted void sellItem(Character x){
		
	}
	protected void Shopping(Character x){
		boolean open=true;
		System.out.println("Welcome to the general store!\n feel free to look at our items or purchase any of our items.");
		System.out.println("To view items for sale press view, to buy items press 2, to sell items in your inventory type sell,n  to attempt to steal an item press 3.");
		String opt= kb.nextLine();
		while(open==true){
				if(opt.equalsIgnoreCase("View")){
					displayShopItems();
				}
				if(opt.equalsIgnoreCase("Buy")){
					displayShopItems();
					System.out.println("What item would you like to buy?");
				}
				if(opt.equalsIgnoreCase("Steal")){
					//call steal method which includes random but highly likely event of getting caught and brawl
				}
				else
					System.out.println("Please enter a valid response");
			
		}
	}
	private void displayShopItems() {
		displayBItems();
		displayKItems();
		displayEquip();
	}
	
	protected void steal(Character x){
		//make sure it checks inventory available space, allows user to remove item if necessary or try to resell it to the shop keeper 
		String stolen;
		System.out.println("The shop keeper isn't looking would you like to try and steal an item?");
		System.out.println("What item would you like to try and steal?");
		displayShopItems();
		stolen= kb.nextLine();
		int val=rand();
		if(val>90){
			System.out.println("Item successfully stolen");
			CheckitemType(stolen);
		}
		else if(val<=90){
			System.out.println("Theft attempt unsuccesful");
			ShopKeeper nShkp = new ShopKeeper(x.getCurHp(),x.getStr(),x.getDef());
			System.out.println("Now engaged in a brawl with the Shop Keeper, square up");
			while (x.getCurHp()>10 || nShkp.getHp()>10){
				brawl(Character x, ShopKeeper y);
			}
			
		}
		
		
	}
	protected int rand(){
		int x= ran.nextInt(100-1+1)+1;
		return x;
	} 
	
	
	
	
}
class ShopGaurd{
	
}
class ShopKeeper{
	int hp;
	int str;
	int def;
	
	public ShopKeeper(int health, int strength, int defense ){
		hp=health;
		str=strength;
		def=defense;
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