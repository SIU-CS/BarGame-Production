package edu.siu.bargame;


import java.util.Scanner;

@SuppressWarnings("serial")
public class Castle extends Story {
	
	public Castle(Character player, Inventory y) {
		player.setCastleVisited(true);
		player.setCurrentLocation("Castle");
	}
	
	public void menu(Character player, Inventory y) throws Exception {
		System.out.println("\nLocation: Castle\n\n");
		System.out.println("Entry\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Visit Shop\n2:  Speak With Survivor\n3: Story so Far\n4:  View Stats\n5:  View Inventories\n6:  Castle\n7:  Return to Overworld");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			Shop castleShop=new Shop();
			castleShop.Shopping(player, y);
			break;
		case 2:
			conversationMenu();
			break;
		case 3:
			for (int i = 0; i < getStoryCounter(); i++) {
				System.out.println(story[i]);
				System.out.println("\n\n");
			}
			break;
		case 4:
			System.out.println(player.toString() + "\n" + player.PrintStats());
			break;
		case 5:
			inventoryMenu(y);
			break;
		case 6:
			if (player.getLevel() < 15) {
				System.out.println(levelBarrier[2]);
			}
			else {
				if (storyCounter < 4) {
					System.out.println(story[3]);
					player.setCurrentLocation("Castle");
					Battle.bossBattle(y);
					System.out.println(story[4]);
					System.exit(0);
				}
			}
			
			break;
		case 7:
			System.out.println("Returning to Overworld...");
			break;
		default:
		}
		if (selection != 7) {
			menu(player,y);
		}
	}

	private void inventoryMenu(Inventory y) {
		System.out.println("\n\n1:  Check Equipment\n2:  Check Key Items\n3:  Check Battle Items");
		Scanner menuChoice = new Scanner(System.in);
		int menuSelection = menuChoice.nextInt();
		switch (menuSelection) {
		case 1:
			printEquipment();
			break;
		case 2:
			printKeyItems();
			break;
		case 3:
			printBattleItems();
			System.out.println("Press 1 to return to the previous screen or type in the item's name to use it.");
			Scanner invItem = new Scanner(System.in);
			String item = invItem.next();
			useItem(item);
		default:
		}
	}
	
	private void conversationMenu() {
		System.out.println("\nLocation: Castle\n\n");
		System.out.println("Entry\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println(player.getName()+ " sees a lone knight, battered and bruised, stumbling along the wall, wearing a look of wild fear and desperation.\n\n"
		+ "Press 1 to speak with the battered knight, press 4 to exit.");
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		switch (selection) {
		case 1:
			System.out.println(castleConversations[0]);
			conversationMenu();
			break;
		default:
		}
	}
}
