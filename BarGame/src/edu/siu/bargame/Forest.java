package edu.siu.bargame;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Forest extends Story {
	
	public Forest() {
		player.setCurrentLocation("Forest");
	}
	
	public void menu() {
		System.out.println("\nLocation: Silanger\n\n");
		System.out.println("Entrance\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Enter Shop District\n2:  Examine Location\n3:  Enter Treehouse Section\n4:  Story So Far\n5:  View Stats\n6:  View Inventories\n7:  Overworld");
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
			secondaryArea();
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
			System.out.println("Returning to the Overworld...");
		
		default:
		}
		if (selection != 7) {
			menu();
		}
	}

	private void inventoryMenu() {
		System.out.println("\n\n1:  Check Equipment\n2:  Check Key Items\n3:  Check Battle Items\n4:  Exit Menu");
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
		case 4:
			break;
		default:
		}
	}

	private void secondaryArea() {
		System.out.println("\nLocation: Salinger\n\n");
		System.out.println("Treehouses\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Return to Previous Location\n2:  Examine Location\n3:  Story so Far\n4:  View Stats\n5:  View Inventories\n6:  Speak With Locals\n7:  Tall Tree");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(forestExaminations[2]);
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
			inventoryMenu();
			break;
		case 6:
			conversationMenu();
			break;
		case 7:
			if (player.getLevel() < 5) {
				System.out.println(levelBarrier[0]);
			}
			else {
				if (storyCounter < 2) {
					System.out.println(story[1]);
					setStoryCounter(getStoryCounter() + 1);
					Battle.bossBattle();
					player.setTownVisited(true);
					System.out.println("You can now visit Ferop.  Go to the Overworld and try it out!");
				}
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
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println(player.getName()+ " sees an old man, two young children, and a man with a war axe strung across his back.\n\n"
		+ "1: Speak With The Old Man, 2: Speak With The Children, 3: Speak With The Man, 4: Exit." );
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		switch (selection) {
		case 1:
			if (searchKeyItems("Ancient Book")) {
				System.out.println(forestConversations[1]);
				player.setBookDecipher(0);
				conversationMenu();
			}
			else {
				System.out.println(forestConversations[0]);
				conversationMenu();
			}
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
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Return to Previous Location\n2:  Examine Location\n3:  Story so Far\n4:  View Stats\n5:  View Inventories\n6:  Visit Shop");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(forestExaminations[1]);
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