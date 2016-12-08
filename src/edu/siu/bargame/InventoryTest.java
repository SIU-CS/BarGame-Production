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
	public void testAddBattleItem() {
		Inventory p = new Inventory();
		assertEquals("Potion has been added to your inventory.", p.addBattleItem("Potion"));
	}

	@Test
	public void testAddKeyItem() {
		Inventory p = new Inventory();
		assertEquals("Ancient Book added to Key Items",p.addKeyItem("Ancient Book"));
	}

	
	@Test
	public void testAddEquipment() {
		Inventory p = new Inventory();
		assertEquals("Dragon Armor added to equipment.", p.addEquipment("Dragon Armor"));
	}

}