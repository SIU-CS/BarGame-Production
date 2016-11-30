package edu.siu.bargame;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Town extends Story {//if issues arise, extend inventory and change how story is accessed
	//boolean visited = false;
	//boolean currentLocation = true;
	
	public Town() {
		player.setTownVisited(0);//try forestVisited, townVisited, etc in Character for serialization.
		menu();
	}
	
	public void menu() {
		System.out.println("\nLocation: Ferop\n\n");
		System.out.println("Front\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1 to enter shop district\t2 to examine location\t3 to enter treehouses\t4 to travel to a different location\t5 for story so far\t6 to view stats\n7 to view inventories\t8 Search for battles");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			shopDistrict();
			break;
		case 2:
			System.out.println(townExaminations[0]);
			break;
		case 3:
			secondaryArea();//residential road
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

	private void secondaryArea() {
		System.out.println("\nLocation: Ferop\n\n");
		System.out.println("Residential Road\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Return to previous Location\n2:  Examine Location\n3:  Story so Far\n4:  View Stats\n5:  View Inventories\n6:  Speak With Locals\n7 Swamp");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(townExaminations[2]);
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
			if (player.getLevel() < 10 || !searchKeyItems("Machete")) {
				System.out.println(levelBarrier[0]);
			}
			else if (player.getLevel() >= 10 && searchKeyItems("Machete")) {
				System.out.println(story[2]);
				storyCounter++;
				//boss battle
				Castle castle = new Castle();
			}
			break;
		default:
		}
		if (selection != 1) {
			secondaryArea();
		}
	}
	
	private void conversationMenu() {
		System.out.println("\nLocation: Ferop\n\n");
		System.out.println("Treehouses\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println(player.getName()+ " spots a few individuals nearby who are not busy.  Among them are a middle-aged woman with a sunhat, a man looking towards"
				+ "the swamp, and a man with glasses staring at the cover of a book with a thoughtful expression.  Determine who to speak to, it's a great chance to gather information!\n\n"
		+ "1:  Speak With The Woman, 2:  Speak With The Man, 3:  Speak With The Professor, 4:  Exit.");
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		switch (selection) {
		case 1:
			System.out.println(townConversations[0]);
			conversationMenu();
			break;
		case 2:
			System.out.println(townConversations[2]);
			conversationMenu();
			break;
		case 3:
			System.out.println(townConversations[3]);
			//if inventory for sidequest, get book
			conversationMenu();
			break;
		case 4:
			break;
		default:
		}
	}

	private void shopDistrict() {
		System.out.println("\nLocation: Ferop\n\n");
		System.out.println("Main Street\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Return to Previous Location\n2:  Examine Location\n3:  Story so Far\n4:  View Stats\n5:  View Inventories\n6:  Visit Shop");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(townExaminations[1]);
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