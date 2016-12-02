package edu.siu.bargame;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 Though some changes were made to the code, the algorithm is credited to Almas Baimagambetov,
 through this video:  https://www.youtube.com/watch?v=-xW0pBZqpjU, with some additional help from
 the stackoverflow.com forums.
 */

public class GameSave extends Inventory implements java.io.Serializable {
	
	private static final long serialVersionUID = -4232457763066697964L;

	
	 public static void save(String fileName) throws Exception {
		 Path p = Paths.get(fileName);
		 Files.deleteIfExists(p);
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
			//oos.writeObject(data);
			oos.writeUTF(player.getGender());
			oos.writeUTF(player.getName());
			oos.writeUTF(player.getPlayerDescription());
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
			oos.writeInt(player.getBookDecipher());
			oos.writeObject(player.getHero());//remove if errors
			oos.writeObject(Inventory.battleItems);
			oos.writeObject(Inventory.equipmentItems);
			oos.writeObject(Inventory.keyItems);
			oos.close();
			System.out.println("Game Saved.");
		}
	}
	
	public static void load(String fileName) throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			player.setGender(ois.readUTF());
			player.setName(ois.readUTF());
			player.setPlayerDescription(ois.readUTF());
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
			player.setBookDecipher(ois.readInt());
			
			player.setHero((Character) ois.readObject());//remove if errors
			Inventory.setBattleItems((String[]) ois.readObject());
			Inventory.setEquipment((String[]) ois.readObject());
			Inventory.setKeyItems((String[]) ois.readObject());
			player.setCurrentLocation("Forest");
			ois.close();
			System.out.println("Game Loaded.");
		}
	}
	
}
