package edu.siu.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.siu.bargame.Inventory;

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
	public void testAddEquipment(){
		Inventory testInv = new Inventory();
		assertEquals("Potion added to equipment.", testInv.addEquipment("Potion"));
	}



	@Test
	public void testAddBattleItem() {
		Inventory testInv = new Inventory();
		testInv.addBattleItem("Potion");
		assertEquals("Potion has been added to your inventory.", testInv.addBattleItem("Potion"));
		
	}

	@Test
	public void testRemoveBattleItem() {
		Inventory testInv = new Inventory();
		testInv.addBattleItem("Potion");
		assertEquals("Potion has been removed.",testInv.removeBattleItem("Potion"));
	}


	
}
