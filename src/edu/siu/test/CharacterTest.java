package edu.siu.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.siu.bargame.Character;

public class CharacterTest {

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
	public void testGetGold() {
		Character testChar = new Character();
		testChar.setGold(500);
		assertEquals(500,testChar.getGold());
	}

	
	@Test
	public void testGetGender() {
		Character testChar = new Character();
		testChar.setGender("Male");
		assertEquals("Male",testChar.getGender());
	}

	
	@Test
	public void testGetPlayerDescription() {
		Character testChar = new Character();
		testChar.setPlayerDescription("Players description test");
		assertEquals("Players description test",testChar.getPlayerDescription());
	}

}
