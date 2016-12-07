package edu.siu.test;

import static org.junit.Assert.*;


import org.junit.Test;

import edu.siu.bargame.Inventory;

public class InventoryTest {



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
