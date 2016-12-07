package edu.siu.bargame;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest {

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
	public void testSetStartItems() {
		String[] battleItems = new String[20];
		String[] keyItems = new String[6];
		String[] equipment = new String[5];
		battleItems[0]="Potion";
		battleItems[1] = "Potion";
		battleItems[2]="Potion";
		battleItems[3]="Potion";
		keyItems[0]="Damaged Necklace";
		equipment[0]="leather";
		equipment[1]="leather";
		equipment[2]="leather";
		equipment[3]="leather";
		equipment[4]="wooden";
		assertEquals(equipment[4], "wooden");
	}

	@Test
	public void testAddBattleItem() {
		String[] battleItems = new String[20];
		battleItems[0]="Potion";
		battleItems[1] = "Potion";
		battleItems[2]="Potion";
		battleItems[3]="Potion";
		String item = "Potion";
		boolean added = false;
		for (int i = 0; i<=battleItems.length - 1; i++) {
			if (battleItems[i] == null) {
				battleItems[i] = item;
				added = true;
				break;
			}
		}
		assertEquals(battleItems[4], "Potion");
	}
	static String[] battleItems = new String[20];
	@Test
	public void testRemoveBattleItem() {
		battleItems[0]="potion";
		battleItems[1]="potion";
		battleItems[2]="potion";
		battleItems[3]="item4";
		String item = "item4";
		
		for (int i = 0; i <= battleItems.length - 1; i++) {
			if (battleItems[i] == item.toLowerCase()) {
				battleItems[i] = null;
				break;
			}
		}
		assertEquals(battleItems[3], null);
	}

	@Test
	public void testAddKeyItem() {
		String[] keyItems = new String[6];
		String item = "g";
		for (int i = 0; i <= keyItems.length - 1; i++) {
			if (keyItems[i] == null) {
				keyItems[i] = item;
				break;
			}
		}
		assertEquals(keyItems[0], "g");
	}

	@Test
	public void testAddEquipment() {
		String[] equipment = new String[5];
		equipment[0] = "leather";
		equipment[1]="leather";
		equipment[2]="leather";
		String item = "leather";
		boolean added = false;
		for (int i = 0; i <= equipment.length - 1; i++) {
			if (equipment[i] == null) {
				equipment[i] = item;
				added = true;
				break;
			}
		}
		assertEquals(equipment[3], item);
	}

	@Test
	public void testRemoveEquipment() {
		String[] equipment = new String[5];
		equipment[0] = "leather hat";
		equipment[1]="leather jacket";
		equipment[2]="leather leggings";
		String item = "leather jacket";
		boolean remove = false;
		for (int i = 0; i <= equipment.length - 1; i++) {
			if (equipment[i] == item) {
				equipment[i] = null;
				remove = true;
				break;
			}
		}
		assertEquals(equipment[1], null);
	}

	@Test
	public void testUseItem() {
		String[] battleItems = new String[20];
		battleItems[0]="Potion";
		battleItems[1] = "Potion";
		battleItems[2]="Potion";
		battleItems[3]="Potion";
		String item = "x";
		String g;
		switch(item) {
		case "Potion":
		//	hero.setCurHp(hero.getCurHp()+20);
			g ="a";
			break;
		//auto use case "Pheonix Down":
		case "Great Potion":
		//	hero.setCurHp(hero.getCurHp()+60);
			g = "b";
			break;
		case "Max Potion":
		//	hero.setCurHp(hero.getMaxHp());
			g = "c";
			break;
		default:
			g = "fail";
		}
		assertEquals(g, "fail");
	}

/*	@Test
	public void testEquipBonus() {
		fail("Not yet implemented");
	}*/

}
