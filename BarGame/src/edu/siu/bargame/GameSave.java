package edu.siu.bargame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 Though some changes were made to the code, the algorithm is credited to Almas Baimagambetov,
 through this video:  https://www.youtube.com/watch?v=-xW0pBZqpjU, with some additional help from
 the stackoverflow.com forums.
 */

public class GameSave extends Inventory implements java.io.Serializable {
	
	private static final long serialVersionUID = -4232457763066697964L;

	
	 public static void save() throws Exception {
		 Path p = Paths.get("save1.txt");
		 Files.deleteIfExists(p);
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("save1.txt")))) {
			oos.writeUTF(player.getGender());
			oos.writeUTF(player.getName());
			oos.writeUTF(player.getPlayerDescription());
			oos.writeInt(player.getGold());
			oos.writeInt(player.getCurHp());
			oos.writeInt(player.getDef());
			oos.writeInt(player.getExp());
			oos.writeInt(player.getExpForLevelUp());
			oos.writeInt(player.getLevel());
			oos.writeInt(player.getMaxHp());
			oos.writeInt(player.getStr());
			oos.writeBoolean(player.getForestVisited());
			oos.writeBoolean(player.getTownVisited());
			oos.writeBoolean(player.getCastleVisited());
			oos.writeObject(Inventory.battleItems);
			oos.writeObject(Inventory.equipmentItems);
			oos.writeObject(Inventory.keyItems);
			oos.close();
		}
	}
	
	public static void load() throws Exception {
		Path p = Paths.get("save1.txt");
		if (Files.exists(p)) {
			try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(p))) {
				player.setGender(ois.readUTF());
				player.setName(ois.readUTF());
				player.setPlayerDescription(ois.readUTF());
				player.setGold(ois.readInt());
				player.setCurHp(ois.readInt());
				player.setDef(ois.readInt());
				player.setExp(ois.readInt());
				player.setExpForLevelUp(ois.readInt());
				player.setLevel(ois.readInt());
				player.setMaxHp(ois.readInt());
				player.setStr(ois.readInt());
				player.setForestVisited(ois.readBoolean());
				player.setTownVisited(ois.readBoolean());
				player.setCastleVisited(ois.readBoolean());			
				Inventory.setBattleItems((String[]) ois.readObject());
				Inventory.setEquipment((String[]) ois.readObject());
				Inventory.setKeyItems((String[]) ois.readObject());
				player.setCurrentLocation("Forest");
				ois.close();
				System.out.println("Game Loaded.");
				
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
							Inventory.printBattleItems();
						    Inventory.printEquipment();
						    Inventory.printKeyItems();
						    break;
						case 3:
							System.out.println(player.PrintStats());
							break;
						case 4:
							Battle.battle();
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
		else {
			System.out.println("No save data found.");
		}
	}
	
}
