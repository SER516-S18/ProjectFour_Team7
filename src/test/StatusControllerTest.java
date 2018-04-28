package test;

import edu.ser516.project4.client.controller.StatusController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusControllerTest {

	@Before
	public void setUp() throws Exception {

		}

	@Test
	public void test() {
		
		
		
		
		boolean var = false;
		StatusController status = new StatusController();
		Object temp = status.getInstance();
		if (temp instanceof StatusController) {
			var = true;
		}
		assertEquals(true, var);
	}

}
