package edu.siu.bargame;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Castle extends Story {
	
	public Castle() {
		player.setCastleVisited(true);
		player.setCurrentLocation("Castle");
	}
	
	public void menu() throws Exception {
		System.out.println("\nLocation: Castle\n\n");
		System.out.println("Entry\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Visit Shop\n2:  Speak With Survivor\n3:  Travel to a different location\n4:  Story so Far\n5:  View Stats\n6:  View Inventories\n7:  Search For Battles\n8:  Castle\n9:  Save");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			//shop
			break;
		case 2:
			conversationMenu();
			break;
		case 3:
			int dest;
			if (player.forestVisited) {
				System.out.println("Would you like to travel to Salinger?  Press 1 for yes and 2 for no.");
				Scanner travel = new Scanner(System.in);
				dest = travel.nextInt();
				if (dest == 1) {
					Forest forest = new Forest();
					forest.menu();
				}
			}
			if (player.castleVisited) {
				System.out.println("Would you like to travel to the Ferop?  Press 1 for yes and 2 for no.");
				Scanner travel = new Scanner(System.in);
				dest = travel.nextInt();
				if (dest == 1) {
					Town town = new Town();
					town.menu();
				}
			}
			break;
		case 4:
			for (int i = 0; i < getStoryCounter(); i++) {
				System.out.println(story[i]);
				System.out.println("\n\n");
			}
			break;
		case 5:
			System.out.println(player.toString() + "\n" + player.PrintStats());
			break;
		case 6:
			inventoryMenu();
			break;
		case 7:
			Battle.battle();
			break;
		case 8:
			if (player.getLevel() < 15) {
				System.out.println(levelBarrier[2]);
			}
			else {
				if (storyCounter < 4) {
					System.out.println(story[3]);
					Battle.bossBattle();
					System.out.println(story[4]);
					System.exit(0);
				}
			}
			break;
		case 9:
			System.out.println("Saving Game...");
			GameSave.save("save1.save");
			System.out.println("Game Saved.  save1.save");
			break;
		default:
		}
		if (selection != 3) {
			menu();
		}
	}

	private void inventoryMenu() {
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