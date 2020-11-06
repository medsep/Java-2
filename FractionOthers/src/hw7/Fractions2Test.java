package hw7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Fractions2Test {

	double delta;

	@BeforeEach
	public void setUp() {
		this.delta = 0.000001;
	}

	@Test
	void testFractions2() {

		Fractions2 Fractions2 = new Fractions2(4, 16);
		assertEquals(4, Fractions2.numerator);
		assertEquals(16, Fractions2.denominator);

		Fractions2 = new Fractions2(4, -16);
		assertEquals(-4, Fractions2.numerator);
		assertEquals(16, Fractions2.denominator);

	}

	@Test
	void testReduceToLowestForm() {
		Fractions2 Fractions2 = new Fractions2(4, 16);
		Fractions2.reduceToLowestForm();

		assertEquals(1, Fractions2.numerator);
		assertEquals(4, Fractions2.denominator);

		Fractions2 = new Fractions2(0, 4);
		Fractions2.reduceToLowestForm();

		assertEquals(0, Fractions2.numerator);
		assertEquals(1, Fractions2.denominator);

	}

	@Test
	void testAdd() {
		Fractions2 Fractions21 = new Fractions2(4, 16);
		Fractions2 Fractions22 = new Fractions2(5, 16);
		Fractions2 newFractions2 = Fractions21.add(Fractions22);
		assertEquals(9, newFractions2.numerator);
		assertEquals(16, newFractions2.denominator);
		assertNotSame(newFractions2, Fractions21);
		assertNotSame(newFractions2, Fractions22);

		Fractions21 = new Fractions2(3, 7);
		Fractions22 = new Fractions2(2, 7);
		newFractions2 = Fractions21.add(Fractions22);
		assertEquals(5, newFractions2.numerator);
		assertEquals(7, newFractions2.denominator);
		assertNotSame(newFractions2, Fractions21);
		assertNotSame(newFractions2, Fractions22);

	}

	@Test
	void testSubtract() {

		Fractions2 Fractions21 = new Fractions2(4, 16);
		Fractions2 Fractions22 = new Fractions2(5, 16);
		Fractions2 newFractions2 = Fractions21.subtract(Fractions22);
		assertEquals(-1, newFractions2.numerator);
		assertEquals(16, newFractions2.denominator);

		Fractions21 = new Fractions2(5, 9);
		Fractions22 = new Fractions2(3, 9);
		newFractions2 = Fractions21.subtract(Fractions22);
		assertEquals(2, newFractions2.numerator);
		assertEquals(9, newFractions2.denominator);

	}

	@Test
	void testMul() {

		Fractions2 Fractions21 = new Fractions2(4, 16);
		Fractions2 Fractions22 = new Fractions2(5, 16);
		Fractions2 newFractions2 = Fractions21.mul(Fractions22);
		assertEquals(5, newFractions2.numerator);
		assertEquals(64, newFractions2.denominator);

		Fractions21 = new Fractions2(5, 9);
		Fractions22 = new Fractions2(3, 9);
		newFractions2 = Fractions21.mul(Fractions22);
		assertEquals(5, newFractions2.numerator);
		assertEquals(27, newFractions2.denominator);

	}

	@Test
	void testDiv() {
		Fractions2 Fractions21 = new Fractions2(4, 16);
		Fractions2 Fractions22 = new Fractions2(5, 16);
		Fractions2 newFractions2 = Fractions21.div(Fractions22);
		assertEquals(4, newFractions2.numerator);
		assertEquals(5, newFractions2.denominator);

		Fractions21 = new Fractions2(5, 9);
		Fractions22 = new Fractions2(3, 9);
		newFractions2 = Fractions21.div(Fractions22);
		assertEquals(5, newFractions2.numerator);
		assertEquals(3, newFractions2.denominator);

	}

	@Test
	void testDecimal() {
		Fractions2 Fractions21 = new Fractions2(4, 16);
		double dec = Fractions21.decimal();
		assertEquals(.25, dec, this.delta);

		Fractions21 = new Fractions2(5, 16);
		dec = Fractions21.decimal();
		assertEquals(.3125, dec, this.delta);

	}

	@Test
	void testSqr() {
		Fractions2 Fractions21 = new Fractions2(2, 3);
		Fractions21.sqr();
		assertEquals(4, Fractions21.numerator);
		assertEquals(9, Fractions21.denominator);

		Fractions21 = new Fractions2(4, 16);
		Fractions21.sqr();
		assertEquals(1, Fractions21.numerator);
		assertEquals(16, Fractions21.denominator);

	}

	@Test
	void testEquals() {
		Fractions2 Fractions21 = new Fractions2(2, 3);
		Fractions2 Fractions22 = new Fractions2(2, 3);
		assertEquals(Fractions21, Fractions22);

		Fractions21 = new Fractions2(4, 16);
		Fractions22 = new Fractions2(1, 4);
		assertEquals(Fractions21, Fractions22);

		// confirm the Fractions2s were not (permanently) reduced to lowest form
		assertEquals(4, Fractions21.numerator);
		assertEquals(16, Fractions21.denominator);
		assertEquals(1, Fractions22.numerator);
		assertEquals(4, Fractions22.denominator);

	}

	@Test
	void testToString() {
		Fractions2 Fractions21 = new Fractions2(2, 3);
		String str = Fractions21.toString();
		assertEquals("2/3", str);

	}

	@Test
	void testAverageFractions2() {
		Fractions2 Fractions21 = new Fractions2(1, 2);
		Fractions2 otherFractions2 = new Fractions2(3, 4);
		Fractions2 avgFractions2 = Fractions21.average(otherFractions2);

		assertEquals(5, avgFractions2.numerator);
		assertEquals(8, avgFractions2.denominator);

	}

	@Test
	void testAverageFractions2Array() {

		Fractions2 Fractions21 = new Fractions2(3, 4);
		Fractions2 Fractions22 = new Fractions2(3, 5);
		Fractions2 Fractions23 = new Fractions2(3, 6);

		Fractions2[] Fractions2s = new Fractions2[] { Fractions21, Fractions22, Fractions23 };
		Fractions2 avgFractions2 = Fractions2.average(Fractions2s);

		assertEquals(37, avgFractions2.numerator);
		assertEquals(60, avgFractions2.denominator);

	}

	@Test
	void testAverageIntArray() {

		int[] ints = new int[] { 1, 2, 3, 4 };
		Fractions2 avgFractions2 = Fractions2.average(ints);

		assertEquals(5, avgFractions2.numerator);
		assertEquals(2, avgFractions2.denominator);

	}

}
