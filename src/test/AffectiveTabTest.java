package test;

import edu.ser516.project4.client.view.affective.AffectiveTab;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AffectiveTabTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		AffectiveTab affectiveTab = new AffectiveTab();
		Object temp = affectiveTab.getPanel();
		boolean var = true;
		if (temp instanceof AffectiveTab) {
			var = false;
		}
		assertEquals(true, var);
		
		
	}

}
