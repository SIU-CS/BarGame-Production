package edu.siu.bargame;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Forest extends Story {//if issues arise, extend inventory and change how story is accessed
	boolean visited = false;
	boolean currentLocation = true;
	
	public Forest() {
		visited = true;//try forestVisited, townVisited, etc in Character for serialization.
	}
	
	public void menu() {
		System.out.println("\nLocation: Silanger\n\n");
		System.out.println("Entrance\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Current Hp: " + player.getCurHp());
		System.out.println("\n\n1 to enter shop district\t2 to examine location\t3 to enter treehouses\t4 to travel to a different location\t5 for story so far\t6 to view stats\n7 to view inventories\t8 Search for battles");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			shopDistrict();
			break;
		case 2:
			System.out.println(forestExaminations[0]);
			break;
		case 3:
			secondaryArea();//treehouses
			break;
		case 4:
			//travel to a new location
			break;
		case 5:
			//story so far
			break;
		case 6:
			System.out.println(player.toString() + "\n" + player.PrintStats());
			break;
		case 7:
			inventoryMenu();
			break;
		case 8:
			Battle.battle("Soldier");
			break;
		default:
		}
		if (selection != 4) {
			menu();
		}
	}

	private void inventoryMenu() {
		System.out.println("\n\n1 to check equipment\t2 to check key items\t3 to check battle items");
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
			//removeBattleItem(item);
		default:
		}
	}

	private void secondaryArea() {
		//set up examinations, item finds, people to speak with
		System.out.println("\nLocation: Salinger\n\n");
		System.out.println("Treehouses\n\n\n");
		System.out.println("----------Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Current Hp: " + player.getCurHp());
		System.out.println("\n\n1 to return to previous location\t2 to examine location\t3 for story so far\t4 to view stats\t5 to view inventories\t6 to speak with locals\t7 ???");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(forestExaminations[2]);
			break;
		case 3:
			//STORY SO FAR
			break;
		case 4:
			System.out.println(player.toString() + "\n" + player.PrintStats());
			break;
		case 5:
			inventoryMenu();
			break;
		case 6:
			conversationMenu();
			break;
		case 7:
			if (player.getLevel() < 5) {
				System.out.println(levelBarrier[0]);
			}
			//if (keyItems[1] == "PLACEHOLDER") {
				//System.out.println("");//Story piece with key item*/
				//boss battle
			else {
				System.out.println(story[1]);
				storyCounter++;
			}
			break;
		default:
		}
		if (selection != 1) {
			secondaryArea();
		}
	}
	
	private void conversationMenu() {
		System.out.println("\nLocation: Salinger\n\n");
		System.out.println("Treehouses\n\n\n");
		System.out.println("----------Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Current Hp: " + player.getCurHp());
		System.out.println(player.getName()+ " sees an old man, two young children, and a man with a war axe strung across his back.\n\n"
				+ "Press 1 to speak with the old man, 2 to speak with the children, 3 to speak with the man, or 4 to exit." );
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		switch (selection) {
		case 1:
			//if else for if the book is in inventory for system.out, if will be [1]
			System.out.println(forestConversations[0]);
			conversationMenu();
			break;
		case 2:
			System.out.println(forestConversations[2]);
			conversationMenu();
			break;
		case 3:
			System.out.println(forestConversations[3]);
			conversationMenu();
			break;
		case 4:
			break;
		default:
		}
	}

	private void shopDistrict() {
		System.out.println("\nLocation: Salinger\n\n");
		System.out.println("Shop District\n\n\n");
		System.out.println("----------Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Current Hp: " + player.getCurHp());
		System.out.println("\n\n1 to return to previous location\t2 to examine location\t3 for story so far\t4 to view stats\t5 to view inventories\t6 to visit shop");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(forestExaminations[1]);
			break;
		case 3:
			//STORY SO FAR
			break;
		case 4:
			System.out.println(player.toString() + "\n" + player.PrintStats());
			break;
		case 5:
			inventoryMenu();
			break;
		case 6:
			//visit shop
			break;
		default:
		}
		if (selection != 1) {
			shopDistrict();
		}
	}
}
