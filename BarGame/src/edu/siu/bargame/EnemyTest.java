package edu.siu.bargame;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnemyTest {

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
	public void testTypeOfEnemy() {
		Enemy enemy = null;
		String typeValue = "";
		int scale = 3;
		switch (scale) {
			case 1:
				enemy = new Enemy(8, 4, 3, 10);
				typeValue = "Soldier";
				break;
			case 2:
				enemy = new Enemy(10, 2, 1, 5);
				typeValue = "Undead";
				break;
			case 3:
				enemy = new Enemy(3, 2, 0, 3);
				typeValue = "Spider";
				break;
			case 4:
				enemy = new Enemy(6, 3, 3, 6);
				typeValue = "Bandit";
				break;
			case 5:
				enemy = new Enemy(6, 2, 3, 6);
				typeValue = "Wanderer";
				break;
			case 6:
				enemy = new Enemy(7, 4, 3, 9);
				typeValue = "Mercenary";
				break;
			case 7:
				enemy = new Enemy(20, 6, 12, 10);
				typeValue = "Golem";
				break;
			case 8:
				enemy = new Enemy(18, 9, 7, 10);
				typeValue = "Wyvern";
				break;
			case 9:
				enemy = new Enemy(15, 10, 4, 11);
				typeValue = "Sorceror";
			default:
				System.out.println("Invalid enemy type entered.");
				enemy = new Enemy(0, 0, 0, 0);
		}
		assertEquals(typeValue, "Spider");
	}

}
