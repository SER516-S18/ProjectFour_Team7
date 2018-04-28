package test;

import edu.ser516.project4.client.model.StatusObservable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StatusObservableTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testetObserverInstance() {
		StatusObservable obj = new StatusObservable();
		Object temp = obj.getObserverInstance();
		boolean var = false;
		if (temp instanceof StatusObservable) {
			var = true;
		}
		assertEquals(true, var);
		
	}

}
