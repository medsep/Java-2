package train1.com.fx1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JunitConcatTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test

	public void ConcatTest() {
		JunitTest junit = new JunitTest();
		String result = junit.concat("Hello ", "World");
		assertEquals("Hello World", result);
	}

}
