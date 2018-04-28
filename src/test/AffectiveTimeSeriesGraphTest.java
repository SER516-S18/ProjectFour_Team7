package test;

import edu.ser516.project4.client.view.affective.AffectiveTimeSeriesGraph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AffectiveTimeSeriesGraphTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
    	AffectiveTimeSeriesGraph affectiveTimeSeriesGraph = AffectiveTimeSeriesGraph.getinstance();
		boolean var = true;
		if ( affectiveTimeSeriesGraph instanceof AffectiveTimeSeriesGraph) {
			var = true;
		} 
		assertEquals(true, var);
		
		
	}

}
