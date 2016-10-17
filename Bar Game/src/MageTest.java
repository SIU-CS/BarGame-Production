import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MageTest {

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
//nt level, int exp, String gender, String Name, int defense, int health, int strength, int g, int maxH, int currH
	@Test
	public void test() {
		final int level=10;
		final int exp=200;
		final String name="Lucas";
		final String Gender="Male";
		final int Def=10;
		final int gold=100;
		final int health=100;
		final int CurrH=100;
		
		
		Mage m = new Mage(10,200,"Male","Lucas",10,100,100,110,100);
		assertEquals(level, m.getLevel());
		assertEquals(exp, m.getExp());
		assertEquals(name, m.getName());
		assertEquals(Gender,m.getGender());
		assertEquals(Def, m.getDefense());
		assertEquals(gold, m.reduceGold(10));
		assertEquals(health, m.getHealth());
		assertEquals(CurrH, m.getCURRHEALTH());
	}

}
