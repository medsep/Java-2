/**
 * """
*Name : Mehdi Sepahvand,
*Penn ID: 15228700,
*Statement of work: Work is completely my own. The only resources used were lecture\n
* codes, recitation videos and Java help library.
 */

package hw7;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

	double delta;

	@BeforeEach
	public void setUp() {
		this.delta = 0.000001;
	}

	@Test
	void testFractions() {

		Fraction Fraction = new Fraction(4, 16);
		assertEquals(4, Fraction.numerator);
		assertEquals(16, Fraction.denominator);

		Fraction = new Fraction(4, -16);
		assertEquals(-4, Fraction.numerator);
		assertEquals(16, Fraction.denominator);

		Fraction = new Fraction(-35, 60);
		assertNotEquals(35, Fraction.numerator);
		assertNotEquals(35, Fraction.denominator);
		assertEquals(-35, Fraction.numerator);
		assertEquals(60, Fraction.denominator);

		Fraction = new Fraction(-35, -60);
		assertNotEquals(-35, Fraction.numerator);
		assertNotEquals(-35, Fraction.denominator);
		assertEquals(35, Fraction.numerator);
		assertEquals(60, Fraction.denominator);

		// Test with negative numerator and denominator.
		Fraction = new Fraction(-6, -6);
		assertNotEquals(-6, Fraction.numerator);
		assertNotEquals(-6, Fraction.denominator);
		assertEquals(6, Fraction.numerator);
		assertEquals(6, Fraction.denominator);

	}

	@Test
	void testReduceToLowestForm() {
		Fraction Fraction = new Fraction(4, 16);
		Fraction.reduceToLowestForm();

		assertEquals(1, Fraction.numerator);
		assertEquals(4, Fraction.denominator);

		Fraction = new Fraction(0, 4);
		Fraction.reduceToLowestForm();

		assertEquals(0, Fraction.numerator);
		assertEquals(1, Fraction.denominator);

		Fraction = new Fraction(-25, -100);
		Fraction.reduceToLowestForm();
		assertEquals(1, Fraction.numerator);
		assertEquals(4, Fraction.denominator);
		assertNotEquals(25, Fraction.numerator);
		assertNotEquals(100, Fraction.denominator);

		// testReduceToLowestFormWithZero
		Fraction testFractions3 = new Fraction(0, 5);
		testFractions3.reduceToLowestForm();
		assertTrue("Reduced to 0/1", testFractions3.numerator == 0);
		assertTrue("Reduced to 0/1", testFractions3.denominator == 1);

		// testReduceToLowestFormWithNegative
		Fraction testFractions4 = new Fraction(3, -4);
		testFractions4.reduceToLowestForm();
		assertTrue("Negative signs should be moved to the numerator", testFractions4.numerator == -3);
		assertTrue("Negative signs should be moved to the numerator", testFractions4.denominator == 4);

		// testReduceToLowestFormWhenInLowestForm
		Fraction testFractions5 = new Fraction(2, 3);
		testFractions5.reduceToLowestForm();
		assertTrue("Should return itself if already in lowest form", testFractions5.numerator == 2);
		assertTrue("Should return itself if already in lowest form", testFractions5.denominator == 3);

	}

	@Test
	void testAdd() {
		Fraction Fraction1 = new Fraction(4, 16);
		Fraction Fraction2 = new Fraction(5, 16);
		Fraction newFraction = Fraction1.add(Fraction2);
		assertEquals(9, newFraction.numerator);
		assertEquals(16, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);

		Fraction1 = new Fraction(3, 5);
		Fraction2 = new Fraction(1, 4);
		newFraction = Fraction1.add(Fraction2);
		assertEquals(17, newFraction.numerator);
		assertEquals(20, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);

		// Here we test with unfactored numbers, in both
		// denominator and numerator.
		Fraction1 = new Fraction(10, 50);
		Fraction2 = new Fraction(20, 40);
		newFraction = Fraction1.add(Fraction2);
		assertEquals(7, newFraction.numerator);
		assertEquals(10, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(30, newFraction.numerator);
		assertNotEquals(50, newFraction.denominator);

		// Here we test with negative numbers, in both
		// numerator.
		Fraction1 = new Fraction(10, 50);
		Fraction2 = new Fraction(-20, 50);
		newFraction = Fraction1.add(Fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(5, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(30, newFraction.numerator);
		assertNotEquals(50, newFraction.denominator);

		// Here we test with negative numbers, in both
		// denominator and numerator.
		Fraction1 = new Fraction(10, -50);
		Fraction2 = new Fraction(-20, 50);
		newFraction = Fraction1.add(Fraction2);
		assertEquals(-3, newFraction.numerator);
		assertEquals(5, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(30, newFraction.numerator);
		assertNotEquals(-50, newFraction.denominator);

		// testAddWhenResultInLowestForm
		Fraction Fractions31 = new Fraction(1, 3);
		Fraction Fractions32 = new Fraction(1, 3);
		Fraction addedFractions3s = Fractions31.add(Fractions32);
		assertTrue("Fractions3s should be added properly", addedFractions3s.numerator == 2);
		assertTrue("Fractions3s should be added properly", addedFractions3s.denominator == 3);

		// testAddWhenResultIsZero
		Fraction Fractions41 = new Fraction(-1, 3);
		Fraction Fractions42 = new Fraction(1, 3);
		Fraction addedFractions4s = Fractions41.add(Fractions42);
		assertTrue("If Fractions3s add to zero, result should be 0/1", addedFractions4s.numerator == 0);
		assertTrue("If Fractions3s add to zero, result should be 0/1", addedFractions4s.denominator == 1);

	}

	@Test
	void testSubtract() {

		Fraction Fraction1 = new Fraction(4, 16);
		Fraction Fraction2 = new Fraction(5, 16);
		Fraction newFraction = Fraction1.subtract(Fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(16, newFraction.denominator);

		Fraction1 = new Fraction(5, 9);
		Fraction2 = new Fraction(3, 9);
		newFraction = Fraction1.subtract(Fraction2);
		assertEquals(2, newFraction.numerator);
		assertEquals(9, newFraction.denominator);

		// Test with unreduced numbers and negatives in
		// numerator.
		Fraction1 = new Fraction(-5, 100);
		Fraction2 = new Fraction(3, 50);
		newFraction = Fraction1.subtract(Fraction2);
		assertEquals(-11, newFraction.numerator);
		assertEquals(100, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(-55, newFraction.numerator);
		assertNotEquals(500, newFraction.denominator);

		// Test with 2 large numbers which can be reduced
		// and negatives in the denominator.
		Fraction1 = new Fraction(5, -100);
		Fraction2 = new Fraction(3, -500);
		newFraction = Fraction1.subtract(Fraction2);
		assertEquals(-11, newFraction.numerator);
		assertEquals(250, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(-22, newFraction.numerator);
		assertNotEquals(500, newFraction.denominator);

		// testSubtractWhenResultIsNegative
		Fraction Fractions31 = new Fraction(2, 3);
		Fraction Fractions32 = new Fraction(3, 3);
		Fraction subtractedFractions3s = Fractions31.subtract(Fractions32);
		assertTrue("Negative signs should be moved to numerator", subtractedFractions3s.numerator == -1);
		assertTrue("Negative signs should be moved to numerator", subtractedFractions3s.denominator == 3);

		// testSubtractWhenResultIsZero
		Fraction Fractions41 = new Fraction(1, 3);
		Fraction Fractions42 = new Fraction(1, 3);
		Fraction subtractedFractions4s = Fractions41.subtract(Fractions42);
		assertTrue("If Fraction subtract to zero, result should be 0/1", subtractedFractions4s.numerator == 0);
		assertTrue("If Fraction subtract to zero, result should be 0/1", subtractedFractions4s.denominator == 1);

	}

	@Test
	void testMul() {

		Fraction Fraction1 = new Fraction(4, 16);
		Fraction Fraction2 = new Fraction(5, 16);
		Fraction newFraction = Fraction1.mul(Fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(64, newFraction.denominator);

		Fraction1 = new Fraction(5, 9);
		Fraction2 = new Fraction(3, 9);
		newFraction = Fraction1.mul(Fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(27, newFraction.denominator);

		// test with unreduced form and negatives in denominator.
		Fraction1 = new Fraction(3, -4);
		Fraction2 = new Fraction(2, -8);
		newFraction = Fraction1.mul(Fraction2);
		assertEquals(3, newFraction.numerator);
		assertEquals(16, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(6, newFraction.numerator);
		assertNotEquals(32, newFraction.denominator);

		// test with unreduced form and negatives in denominator.
		Fraction1 = new Fraction(30, -12);
		Fraction2 = new Fraction(20, -5);
		newFraction = Fraction1.mul(Fraction2);
		assertEquals(10, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(6, newFraction.numerator);
		assertNotEquals("", newFraction.denominator);

		// test with unreduced form and negatives in numerator.
		Fraction1 = new Fraction(-30, -12);
		Fraction2 = new Fraction(20, -5);
		newFraction = Fraction1.mul(Fraction2);
		assertEquals(-10, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(-600, newFraction.numerator);
		assertNotEquals(60, newFraction.denominator);

		// public void testMultiplyWithZero
		Fraction Fractions31 = new Fraction(55, -3);
		Fraction Fractions32 = new Fraction(0, 3);
		Fraction multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Any Fractions3 multiplied by 0 should be 0/1", multipliedFractions3s.numerator == 0);
		assertTrue("Any Fractions3 multiplied by 0 should be 0/1", multipliedFractions3s.denominator == 1);

		// public void testMultiplyWithOne
		Fraction Fractions41 = new Fraction(1, -3);
		Fraction Fractions42 = new Fraction(1, 1);
		Fraction multipliedFractions4s = Fractions41.mul(Fractions42);
		assertTrue("A Fractions3 multiplied by one is itself", multipliedFractions4s.numerator == -1);
		assertTrue("A Fractions3 multiplied by one is itself", multipliedFractions4s.denominator == 3);
	}

	@Test
	void testDiv() {
		Fraction Fraction1 = new Fraction(4, 16);
		Fraction Fraction2 = new Fraction(5, 16);
		Fraction newFraction = Fraction1.div(Fraction2);
		assertEquals(4, newFraction.numerator);
		assertEquals(5, newFraction.denominator);

		Fraction1 = new Fraction(5, 9);
		Fraction2 = new Fraction(3, 9);
		newFraction = Fraction1.div(Fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(3, newFraction.denominator);

		// test with unreduced form and negatives in numerator.
		Fraction1 = new Fraction(-30, -3);
		Fraction2 = new Fraction(5, -5);
		newFraction = Fraction1.div(Fraction2);
		assertEquals(-10, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(-150, newFraction.numerator);
		assertNotEquals(15, newFraction.denominator);

		// test with unreduced form and negatives in denominator.
		Fraction1 = new Fraction(30, -5);
		Fraction2 = new Fraction(2, -10);
		newFraction = Fraction1.div(Fraction2);
		assertEquals(30, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(300, newFraction.numerator);
		assertNotEquals(10, newFraction.denominator);

		// test with unreduced form and negatives in denominator.
		Fraction1 = new Fraction(30, -10);
		Fraction2 = new Fraction(15, -5);
		newFraction = Fraction1.div(Fraction2);
		assertEquals(1, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
		assertNotSame(newFraction, Fraction1);
		assertNotSame(newFraction, Fraction2);
		assertNotEquals(6, newFraction.numerator);
		assertNotEquals("", newFraction.denominator);

		// testDivideWhenResultIsOne()
		Fraction Fractions31 = new Fraction(1, 3);
		Fraction Fractions32 = new Fraction(1, 3);
		Fraction dividedFractions3s = Fractions31.div(Fractions32);
		assertTrue("A Fractions3 divided by itself results in 1/1", dividedFractions3s.numerator == 1);
		assertTrue("A Fractions3 divided by itself results in 1/1", dividedFractions3s.denominator == 1);

	}

	@Test
	void testDecimal() {
		Fraction Fraction1 = new Fraction(4, 16);
		double dec = Fraction1.decimal();
		assertEquals(.25, dec, this.delta);

		Fraction1 = new Fraction(5, 16);
		dec = Fraction1.decimal();
		assertEquals(.3125, dec, this.delta);

		// Test a negative prime fraction
		Fraction1 = new Fraction(1, -13);
		dec = Fraction1.decimal();
		assertEquals(-.076923, dec, this.delta);
		assertNotEquals(-.077, dec, this.delta);

		// Test a prime fraction
		Fraction1 = new Fraction(1, 17);
		dec = Fraction1.decimal();
		assertEquals(.058823, dec, this.delta);
		assertNotEquals(.059, dec, this.delta);

		// Test a recurring fraction with double negative
		Fraction1 = new Fraction(-1, -3);
		dec = Fraction1.decimal();
		assertEquals(.333333, dec, this.delta);
		assertNotEquals(.3, dec, this.delta);
	}

	@Test
	void testSqr() {
		Fraction Fraction1 = new Fraction(2, 3);
		Fraction1.sqr();
		assertEquals(4, Fraction1.numerator);
		assertEquals(9, Fraction1.denominator);

		Fraction1 = new Fraction(4, 16);
		Fraction1.sqr();
		assertEquals(1, Fraction1.numerator);
		assertEquals(16, Fraction1.denominator);

		// Test a couple of perfect squares with a negative
		Fraction1 = new Fraction(-4, 5);
		Fraction1.sqr();
		assertEquals(16, Fraction1.numerator);
		assertEquals(25, Fraction1.denominator);
		assertNotEquals(-16, Fraction1.numerator);
		assertNotEquals(-25, Fraction1.denominator);

		// Test a couple of squares with negative which are reducible
		Fraction1 = new Fraction(-8, -10);
		Fraction1.sqr();
		assertEquals(16, Fraction1.numerator);
		assertEquals(25, Fraction1.denominator);
		assertNotEquals(-16, Fraction1.numerator);
		assertNotEquals(-25, Fraction1.denominator);

		// Test a couple of large squares with negative which are reducible
		Fraction1 = new Fraction(-1000, -5000);
		Fraction1.sqr();
		assertEquals(1, Fraction1.numerator);
		assertEquals(25, Fraction1.denominator);
		assertNotEquals(1000000, Fraction1.numerator);
		assertNotEquals(25000000, Fraction1.denominator);

		// testSqrWithZero as denominator will be 1. (our convention)
		Fraction Fractions3 = new Fraction(0, 4);
		Fractions3.sqr();
		assertTrue("Zero squared is zero", Fractions3.numerator == 0);
		assertTrue("Zero squared is zero", Fractions3.denominator == 1);

	}

	@Test
	void testEquals() {
		Fraction Fraction1 = new Fraction(2, 3);
		Fraction Fraction2 = new Fraction(2, 3);
		Fraction Fraction3 = new Fraction(-2, 3);
		Fraction Fraction4 = new Fraction(4, 6);
		Fraction Fraction5 = new Fraction(0, -5);
		assertEquals(Fraction1, Fraction2);
		assertEquals(Fraction1, Fraction4);
		assertEquals(Fraction2, Fraction4);
		assertNotEquals(Fraction1, Fraction3);
		assertNotEquals(Fraction2, Fraction3);

		Fraction1 = new Fraction(4, 16);
		Fraction2 = new Fraction(1, 4);
		assertEquals(Fraction1, Fraction2);

		// confirm the Fractions were not (permanently) reduced to lowest form
		assertEquals(4, Fraction1.numerator);
		assertEquals(16, Fraction1.denominator);
		assertEquals(1, Fraction2.numerator);
		assertEquals(4, Fraction2.denominator);
	}

	@Test
	void testToString() {
		Fraction Fraction1 = new Fraction(2, 3);
		String str = Fraction1.toString();
		assertEquals("2/3", str);

		// Test with another fraction
		Fraction Fraction2 = new Fraction(2, 7);
		String str1 = Fraction2.toString();
		assertNotEquals("1/3", str1);
		assertEquals("2/7", str1);

		// Test with non reducible fraction
		Fraction Fraction3 = new Fraction(8, 10);
		String str2 = Fraction3.toString();
		assertNotEquals("4/5", str2);
		assertEquals("8/10", str2);

		// Test with negative denominator.
		Fraction Fraction4 = new Fraction(10, -100);
		String str3 = Fraction4.toString();
		assertNotEquals("-1/10", str3);
		assertEquals("-10/100", str3);

		// test with zero
		Fraction zeroNumerator = new Fraction(0, -4);
		String str4 = zeroNumerator.toString();
		assertEquals("0/4", str4);

	}

	@Test
	void testAverageFraction() {
		Fraction Fraction1 = new Fraction(1, 2);
		Fraction otherFraction = new Fraction(3, 4);
		Fraction avgFraction = Fraction1.average(otherFraction);

		assertEquals(5, avgFraction.numerator);
		assertEquals(8, avgFraction.denominator);

		// Test reducibility
		Fraction Fraction2 = new Fraction(5, 10);
		Fraction otherFraction2 = new Fraction(10, 100);
		Fraction avgFraction2 = Fraction2.average(otherFraction2);

		assertEquals(3, avgFraction2.numerator);
		assertEquals(10, avgFraction2.denominator);
		assertNotEquals(30, avgFraction2.numerator);
		assertNotEquals(100, avgFraction2.denominator);

		// Test with negatives and also reducibility
		Fraction Fraction3 = new Fraction(-5, 10);
		Fraction otherFraction3 = new Fraction(10, -100);
		Fraction avgFraction3 = Fraction3.average(otherFraction3);

		assertEquals(-3, avgFraction3.numerator);
		assertEquals(10, avgFraction3.denominator);
		assertNotEquals(-30, avgFraction3.numerator);
		assertNotEquals(100, avgFraction3.denominator);

		// Test with double negative and also reducibility
		Fraction Fraction4 = new Fraction(-5, -10);
		Fraction otherFraction4 = new Fraction(10, -100);
		Fraction avgFraction4 = Fraction3.average(otherFraction4);

		assertEquals(-3, avgFraction4.numerator);
		assertEquals(10, avgFraction4.denominator);
		assertNotEquals(-30, avgFraction4.numerator);
		assertNotEquals(100, avgFraction4.denominator);

	}

	@Test
	void testAverageFractionArray() {

		Fraction Fraction1 = new Fraction(3, 4);
		Fraction Fraction2 = new Fraction(3, 5);
		Fraction Fraction3 = new Fraction(3, 6);

		Fraction[] Fractions = new Fraction[] { Fraction1, Fraction2, Fraction3 };
		Fraction avgFraction = Fraction.average(Fractions);

		assertEquals(37, avgFraction.numerator);
		assertEquals(60, avgFraction.denominator);

		// Test with negative fractions
		Fraction Fraction12 = new Fraction(-3, 4);
		Fraction Fraction22 = new Fraction(-3, 5);
		Fraction Fraction32 = new Fraction(-3, 6);

		Fraction[] Fractions2 = new Fraction[] { Fraction12, Fraction22, Fraction32 };
		Fraction avgFraction2 = Fraction.average(Fractions2);

		assertEquals(-37, avgFraction2.numerator);
		assertEquals(60, avgFraction2.denominator);

		// Test with negative fractions ands zeros
		Fraction Fraction13 = new Fraction(0, 4);
		Fraction Fraction23 = new Fraction(3, -5);
		Fraction Fraction33 = new Fraction(0, 6);

		Fraction[] Fractions3 = new Fraction[] { Fraction13, Fraction23, Fraction33 };
		Fraction avgFraction3 = Fraction.average(Fractions3);

		assertEquals(-1, avgFraction3.numerator);
		assertEquals(5, avgFraction3.denominator);

		// Test with negative fractions
		Fraction Fraction14 = new Fraction(5, 10);
		Fraction Fraction24 = new Fraction(8, 20);
		Fraction Fraction34 = new Fraction(16, 40);

		Fraction[] Fractions4 = new Fraction[] { Fraction14, Fraction24, Fraction34 };
		Fraction avgFraction4 = Fraction.average(Fractions4);

		assertEquals(13, avgFraction4.numerator);
		assertEquals(30, avgFraction4.denominator);

	}

	@Test
	void testAverageIntArray() {

		int[] ints = new int[] { 1, 2, 3, 4 };
		Fraction avgFraction = Fraction.average(ints);

		assertEquals(5, avgFraction.numerator);
		assertEquals(2, avgFraction.denominator);

		//
		int[] ints1 = new int[] { 6, 5, 4, 6 };
		Fraction avgFraction1 = Fraction.average(ints1);

		assertEquals(21, avgFraction1.numerator);
		assertEquals(4, avgFraction1.denominator);

		// test with negative array
		int[] ints2 = new int[] { -1, 2, -3, 4 };
		Fraction avgFraction2 = Fraction.average(ints2);

		assertEquals(1, avgFraction2.numerator);
		assertEquals(2, avgFraction2.denominator);

		// Test for 0 average
		int[] ints3 = new int[] { 1, 2, 3, 4, -10 };
		Fraction avgFraction3 = Fraction.average(ints3);

		assertEquals(0, avgFraction3.numerator);
		assertEquals(1, avgFraction3.denominator);

	}

	@Test
	public void testAvgWithZero() {
		Fraction Fractions31 = new Fraction(0, 1);
		Fraction Fractions32 = new Fraction(2, 3);
		Fraction avgFractions3s = Fractions31.average(Fractions32);
		assertTrue("Fractions3s should be averaged properly when one is zero", avgFractions3s.numerator == 1);
		assertTrue("Fractions3s should be averaged properly when one is zero", avgFractions3s.denominator == 3);
	}

	@Test
	void testAverageIntegerArray() {
		int[] Fractions = { -51, -101, -602, -71, -51, 0, -34, -51, -9 };
		Fraction avgInteger = Fraction.average(Fractions);
		assertTrue("Takes the average of negative elements properly", avgInteger.numerator == -970);
		assertTrue("Takes the average of negative elements properly", avgInteger.denominator == 9);
	}

	@Test
	void testAverageIntegerArray1() {
		int[] Fractions = { -5, 2, -6, 7, 0 };
		Fraction avgInteger = Fraction.average(Fractions);
		assertTrue("Takes the average of both negative & positive elements properly", avgInteger.numerator == -2);
		assertTrue("Takes the average of both negative & positive elements properly", avgInteger.denominator == 5);
	}

	@Test
	public void testAverageIntegerArrays() {
		int[] Fractions3s = { -51, -101, -602, -71, -51, 0, -34, -51, -9 };
		Fraction avgInteger = Fraction.average(Fractions3s);
		assertTrue("Takes the average of negative elements properly", avgInteger.numerator == -970);
		assertTrue("Takes the average of negative elements properly", avgInteger.denominator == 9);
	}

	@Test
	public void testWithOneElement() {
		int[] Fractions3s = { 3 };
		Fraction avgInteger = Fraction.average(Fractions3s);
		assertTrue("Average of a one-element array should be that element", avgInteger.numerator == 3);
		assertTrue("Average of a one-element array should be that element", avgInteger.denominator == 1);
	}

}
