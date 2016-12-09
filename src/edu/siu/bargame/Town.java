package edu.siu.bargame;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Town extends Story {
	
	public Town(Character player, Inventory y) {
		player.setTownVisited(true);
		player.setCurrentLocation("Town");
	}
	
	public void menu(Character player, Inventory y) throws Exception {
		System.out.println("\nLocation: Ferop\n\n");
		System.out.println("Front\n\n\n");
		System.out.println("              Name: "+ player.getName() + "----------Level "+player.getLevel()+ "----------Hp: " + player.getCurHp() + "/" + player.getMaxHp());
		System.out.println("\n\n1:  Shop District\n2:  Examine Location\n3:  Residential Road\n4: Story so Far\n5:  View Stats\n6: View Inventories\n7: Return to Overworld");
		Scanner choice = new Scanner(System.in);
		int selection = choice.nextInt();
		switch (selection) {
		case 1:
			break;
		case 2:
			System.out.println(townExaminations[0]);
			break;
		case 3:
			secondaryArea(player, y);//residential road
			break;
		case 4:
			for(int i=0; i<getStoryCounter(); i++){
				System.out.println(story[i]);
				System.out.println("\n\n");
			}
			break;
		case 5:
			System.out.println(player.toString() + "\n" + player.PrintStats());
			break;
		case 6:
			inventoryMenu(y);
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

	private void secondaryArea(Character x, Inventory y) throws Exception {
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
			conversationMenu();
			break;
		case 7:
			if (player.getLevel() < 10 || !searchKeyItems("Machete")) {
				System.out.println(levelBarrier[0]);
			}
			else if (player.getLevel() >= 10 && searchKeyItems("Machete")) {
				if (storyCounter < 3) {
					System.out.println(story[2]);
					setStoryCounter(getStoryCounter() + 1);
					Battle.bossBattle(y);
					player.setCastleVisited(true);
					System.out.println("You can now visit the Castle, go to the overworld to try it out.");
				}
			}
			break;
		default:
		}
		if (selection != 1) {
			secondaryArea(x,y);
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
			System.out.println(townConversations[1]);
			conversationMenu();
			break;
		case 3:
			System.out.println(townConversations[2]);
			//if inventory for sidequest, get book
			conversationMenu();
			break;
		case 4:
			break;
		default:
		}
	}

	private void shopDistrict(Character x, Inventory y) {
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
			Shop tShop = new Shop();
			tShop.Shopping(x, y);
			break;
		default:
		}
		if (selection != 1) {
			shopDistrict(x,y);
		}
	}
}