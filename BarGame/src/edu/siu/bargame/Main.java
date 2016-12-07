package edu.siu.bargame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Character player = new Character(7, 7, 14);
		player.createCharacter();
		player.setHero(player);
		System.out.println("");
		System.out.println(player + "");
		Inventory inv = new Inventory();
		
		System.out.println("Would you like to load a previously-saved game?  Yes or No");
		Scanner load = new Scanner (System.in);
		String loadChoice = load.nextLine();
		if (loadChoice.equalsIgnoreCase("yes")) {
			GameSave.load();
		}
		else {
			inv.setStartItems();
			System.out.println(Story.story[0]);
		}
		MenuUI UInterface = new MenuUI();

	 	Boolean game = true;
		while (game) {
			int temp = 0;
	 		UInterface.Interface();
	 		temp = UInterface.getChoice();

			switch (temp) {
				case 1:
					System.out.println("Where would you like to go?\n\nSalinger\n");
					if (player.getTownVisited()) {
						System.out.println("Ferop\n");
					}
					if (player.getCastleVisited()) {
						System.out.println("Castle\n\n");
					}
					Scanner locale = new Scanner(System.in);
					String area = locale.next();
					if (area.equalsIgnoreCase("salinger")) {
						Forest forest = new Forest();
						forest.menu();
					}
					else if (area.equalsIgnoreCase("ferop")) {
						Town town = new Town();
						town.menu();
					}
					else if (area.equalsIgnoreCase("castle")) {
						Castle castle = new Castle();
						castle.menu();
					}
					else {
						System.out.println("Invalid location entered");
					}
					break;
				case 2:
					inv.printBattleItems();
				    inv.printEquipment();
				    inv.printKeyItems();
				    break;
				case 3:
					System.out.println(player.PrintStats());
					break;
				case 4:
					Battle.battle(inv);
					break;
				case 5:
					System.out.println("Saving Game...");
					GameSave.save();
					System.out.println("Game Saved.");
					break;
				case 6:
					game = false;
					System.out.println("Thanks for playing! ");
					break;
			}
		}
	}
}