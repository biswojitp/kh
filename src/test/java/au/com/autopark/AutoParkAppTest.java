
package au.com.autopark;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AutoParkAppTest {

	
	
	@Test
	public void test_final_location() throws Exception {
		String input = "5,5:RFLFRFLF";

		AutoParkApp cars = new AutoParkApp(input);

		assertEquals(cars.getEndLocation().getVAxis(), 7);
		assertEquals(cars.getEndLocation().getHAxis(), 7);
		assertEquals(cars.getEndLocation().getDirection(), Direction.N);
	}

	@Test
	public void test_final_location2() throws Exception {
		String input = "6,6:FFLFFLFFLFF";

		AutoParkApp cars = new AutoParkApp(input);

		assertEquals(cars.getEndLocation().getVAxis(), 6);
		assertEquals(cars.getEndLocation().getHAxis(), 6);
		assertEquals(cars.getEndLocation().getDirection(), Direction.E);
	}
	
	@Test(expected = Exception.class)
	public void testInvalidCommands() throws Exception {
		String input = "88RFLFRFLF";

		new AutoParkApp(input);
	}

	@Test(expected = Exception.class)
	public void testInvalidGridSize() throws Exception {
		String input = "15,15:RFLFRFLF";

		new AutoParkApp(input);
	}

	


}