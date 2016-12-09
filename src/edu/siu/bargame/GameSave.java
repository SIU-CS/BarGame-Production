package edu.siu.bargame;
/**
 *  GameSave class
 *  The purpose of this class is to save game state.
 * 
 */

/**
 * 
 * GameSave Class comment added by lucas.
 * 
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameSave extends Inventory implements java.io.Serializable {
	
	private static final long serialVersionUID = -4232457763066697964L;

	
	 public static void save() throws Exception {
		 Path p = Paths.get("save1.txt");
		 Files.deleteIfExists(p);
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("save1.txt")))) {
			//oos.writeObject(data);
			oos.writeInt(player.getGold());
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
			oos.writeObject(Inventory.battleItems);
			oos.writeObject(Inventory.equipmentItems);
			oos.writeObject(Inventory.keyItems);
			oos.close();
			System.out.println("Game Saved.");
		}
	}
	
	public static void load() throws Exception {
		 Path p = Paths.get("save1.txt");
		if(Files.exists(p)){
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(p))) {
			player.setGold(ois.readInt());
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
			Inventory.setBattleItems((String[]) ois.readObject());
			Inventory.setEquipment((String[]) ois.readObject());
			Inventory.setKeyItems((String[]) ois.readObject());
			player.setCurrentLocation("Forest");
			ois.close();
			System.out.println("Game Loaded.");
		}
	}
		else{
			System.out.println("no save data found.");
		}
	}
	
}