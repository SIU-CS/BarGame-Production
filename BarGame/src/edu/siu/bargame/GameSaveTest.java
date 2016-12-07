package edu.siu.bargame;

import static org.junit.Assert.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameSaveTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public static void save(String fileName) throws Exception {
		 Path p = Paths.get(fileName);
		 Files.deleteIfExists(p);
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
			//oos.writeObject(data);
			oos.writeUTF("M");
			oos.writeUTF("Name");
			oos.writeUTF("Description");
			oos.writeInt(100);
			oos.writeInt(12);
			oos.writeInt(4);
			oos.writeInt(33);
			oos.writeInt(44);
			oos.writeInt(5);
			oos.writeInt(25);
			oos.writeInt(5);
			oos.writeBoolean(true);
			oos.writeBoolean(true);
			oos.writeBoolean(false);
			oos.writeObject(Inventory.battleItems);
			oos.writeObject(Inventory.equipmentItems);
			oos.writeObject(Inventory.keyItems);
			oos.close();
			System.out.println("Game Saved.");
		}
		
	}
	
	@Test
	
	public void load() throws Exception {
		String fileName = "Save1.save";
		save(fileName);
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			String x = ois.readUTF();
			//player.setName(ois.readUTF());
			//player.setPlayerDescription(ois.readUTF());
			//player.setGold(ois.readInt());
			//player.setCurHp(ois.readInt());
			//player.setDef(ois.readInt());
			//player.setExp(ois.readInt());
			//player.setExpForLevelUp(ois.readInt());
			//player.setLevel(ois.readInt());
			//player.setMaxHp(ois.readInt());
			//player.setStr(ois.readInt());
			//player.setForestVisited(ois.readBoolean());
			//player.setTownVisited(ois.readBoolean());
			//player.setCastleVisited(ois.readBoolean());			

			Inventory.setBattleItems((String[]) ois.readObject());
			Inventory.setEquipment((String[]) ois.readObject());
			Inventory.setKeyItems((String[]) ois.readObject());
			//player.setCurrentLocation("Forest");
			ois.close();
			//System.out.println("Game Loaded.");
			//Forest forest = new Forest();
			//forest.menu();
			assertEquals(x, "M");
		}
	}

}
