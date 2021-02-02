package train1.com.fx1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JunitAddTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void AddTest() {
		JunitTest junit = new JunitTest();
		int result = junit.add(100, 200);
		assertEquals(300, result);
	}

}
