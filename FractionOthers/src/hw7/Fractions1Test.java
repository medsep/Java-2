package hw7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test the functions in Fractions1 Class with specific cases.
 *
 */
class Fractions1Test {

	// declare Fractions1s for testing
	Fractions1 Fractions1;
	Fractions1 normal1;
	Fractions1 normal2;
	Fractions1 notReduced;
	Fractions1 negativeDenominator;
	Fractions1 zeroNumerator;

	// initialize the Fractions1s
	@BeforeEach
	void setUp() throws Exception {
		normal1 = new Fractions1(2, 3);
		normal2 = new Fractions1(4, 5);
		notReduced = new Fractions1(4, 16);
		negativeDenominator = new Fractions1(10, -15);
		zeroNumerator = new Fractions1(0, -4);
	}

	@Test
	void testFractions1() {
		// to test if Fractions1 creates equal Fractions1s with same parameters
		assertEquals(normal1, new Fractions1(4, 6));
		assertEquals(zeroNumerator, new Fractions1(0, -16));
		// use toString to check if the Fractions1s are shown as expected
		assertEquals("-4/16", new Fractions1(4, -16).toString());
		assertEquals("4/16", new Fractions1(-4, -16).toString());
	}

	@Test
	void testReduceToLowestForm() {
		// reduce the Fractions1s to their lowest forms
		notReduced.reduceToLowestForm();
		negativeDenominator.reduceToLowestForm();
		zeroNumerator.reduceToLowestForm();

		// test not reduced Fractions1s
		assertEquals(notReduced, new Fractions1(2, 8));
		// test negative Fractions1s
		assertEquals(new Fractions1(-3, 12), new Fractions1(6, -24));
		// test zero-numerator Fractions1s
		assertEquals("0/1", zeroNumerator.toString());
	}

	@Test
	void testAdd() {
		assertEquals("22/15", normal1.add(normal2).toString());
		Fractions1 = new Fractions1(2, -3);
		// test zero numerator
		assertEquals(new Fractions1(0, 1), Fractions1.add(normal1));
		// test negative
		assertEquals("-4/3", Fractions1.add(negativeDenominator).toString());
		// use boolean equals to test
		assertTrue(Fractions1.add(new Fractions1(9, 3)).equals(new Fractions1(1, 1).add(new Fractions1(4, 3))));
	}

	@Test
	void testSubtract() {
		// subtract the given
		assertEquals(new Fractions1(-2, 15), normal1.subtract(normal2));
		Fractions1 = new Fractions1(2, -3);
		// test zero
		assertEquals(new Fractions1(0, 1), Fractions1.subtract(negativeDenominator));
		// test negative
		assertEquals("-4/3", Fractions1.subtract(normal1).toString());
		// use boolean equals to test
		assertTrue(Fractions1.equals(new Fractions1(2, 3).subtract(new Fractions1(4, 3))));
	}

	@Test
	void testMul() {
		Fractions1 = new Fractions1(1, 2);
		// test regular multiplication
		assertEquals(new Fractions1(8, 15), normal1.mul(normal2));
		Fractions1 = new Fractions1(2, -3);
		// test zero numerator
		assertEquals("0/1", Fractions1.mul(zeroNumerator).toString());
		// test negative
		assertEquals(new Fractions1(-4, 9), Fractions1.mul(normal1));
	}

	@Test
	void testDiv() {
		assertEquals(new Fractions1(5, 6), normal1.div(normal2));
		Fractions1 = new Fractions1(2, -3);
		// test negatives
		assertEquals("-5/6", Fractions1.div(normal2).toString());
		assertEquals("-1/1", Fractions1.div(normal1).toString());
		// test the zero case
		assertEquals("0/1", zeroNumerator.div(notReduced).toString());
	}

	@Test
	void testDecimal() {
		// test decimal with delta
		assertEquals(normal1.decimal(), 0.666666666, 0.00000001);
		assertEquals(zeroNumerator.decimal(), 0, 0.01);
		Fractions1 = new Fractions1(4, 7);
		assertEquals(Fractions1.decimal(), 0.57142857, 0.00000001);
	}

	@Test
	void testSqr() {
		// test negative
		negativeDenominator.sqr();
		assertEquals(new Fractions1(4, 9), negativeDenominator);
		// test not reduced
		notReduced.sqr();
		assertEquals(new Fractions1(1, 16), notReduced);
		// test 0
		zeroNumerator.sqr();
		assertEquals("0/1", zeroNumerator.toString());
	}

	@Test
	void testAverageFractions1() {
		assertEquals(new Fractions1(11, 15), normal2.average(normal1));
		Fractions1 = new Fractions1(2, -3);
		assertEquals("0/1", Fractions1.average(normal1).toString());
		assertEquals(new Fractions1(-1, 3), Fractions1.average(zeroNumerator));
	}

	@Test
	void testAverageFractions1Array() {
		Fractions1[] myArrayOfFractions1s1 = { new Fractions1(3, 4), new Fractions1(3, 5), new Fractions1(3, 6) };
		Fractions1 f1 = Fractions1.average(myArrayOfFractions1s1);
		assertEquals(new Fractions1(37, 60), f1);
		Fractions1[] myArrayOfFractions1s2 = {};
		// test the form of 0
		Fractions1 f2 = Fractions1.average(myArrayOfFractions1s2);
		assertEquals("0/1", f2.toString());
		// test negative
		Fractions1[] myArrayOfFractions1s3 = { new Fractions1(-1, 24), new Fractions1(2, -24), new Fractions1(5, -24) };
		Fractions1 f3 = Fractions1.average(myArrayOfFractions1s3);
		assertEquals("-1/9", f3.toString());
	}

	@Test
	void testAverageIntArray() {
		int[] myArrayOfInts1 = { 1, 2, 3, 4, 5 };
		Fractions1 f1 = Fractions1.average(myArrayOfInts1);
		assertEquals("3/1", f1.toString());
		// test the form of 0
		int[] myArrayOfInts2 = {};
		Fractions1 f2 = Fractions1.average(myArrayOfInts2);
		assertEquals("0/1", f2.toString());
		int[] myArrayOfInts3 = { 1, 2, 3, 4 };
		Fractions1 f3 = Fractions1.average(myArrayOfInts3);
		assertTrue(new Fractions1(5, 2).equals(f3));
	}

	@Test
	void testEqualsObject() {
		assertTrue(normal1.equals(new Fractions1(4, 6)));
		// test not reduced equals to reduced
		assertTrue(notReduced.equals(new Fractions1(1, 4)));
		// test 0 numerator
		assertTrue(zeroNumerator.equals(new Fractions1(0, -100000)));
	}

	@Test
	void testToString() {
		assertEquals("2/3", normal1.toString());
		// test if the minus symbol is at the right place
		assertEquals("-10/15", negativeDenominator.toString());
		// test if the zero Fractions1 remains the same without calling the reduce
		// function
		assertEquals("0/4", zeroNumerator.toString());
	}
}
