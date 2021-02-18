
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.codility.tasks.invert.Inverter;

public class InverterTest {

	@Test
	public void shouldInvert() {
		String inverted = Inverter.invert(null);
		// String expected = "llab";
		// String input = "ball";
		// String actual = Inverter.Invert(input);
		// assertEquals(actual,expected);
		Assert.fail();
	}

	public void shouldInvertNonEmptyString() {
		// String inverted = Inverter.invert(input);
		// assertFail(inverted);
		String expected = "";
		String input = "";
		String actual = Inverter.Invert(input);
		assertEquals(actual, expected);
		Assert.fail();
	}

	public void shouldReturnEmptyStringWhenEmptyInput() {
		// String inverted = Inverter.invert(null);
		// assertFail(inverted);
		String expected = "b";
		String input = "b";
		String actual = Inverter.Invert(input);
		assertEquals(actual, expected);
		Assert.fail();
	}

}
