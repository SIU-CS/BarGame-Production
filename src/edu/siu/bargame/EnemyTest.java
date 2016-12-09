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
	public void testGetStr() {
		Enemy testE=new Enemy(20,20,20,20);
		assertEquals(20,testE.getStr());
			
	}

	@Test
	public void testGetDef() {
		Enemy testE=new Enemy(20,20,20,20);
		assertEquals(20,testE.getDef());
	}

	@Test
	public void testGetCurHp() {
		Enemy testE=new Enemy(20,20,20,20);
		assertEquals(20,testE.getCurHp());
	}

}
