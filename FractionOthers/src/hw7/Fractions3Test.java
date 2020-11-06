package hw7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//JUnit 4 Test
public class Fractions3Test {

	// Instance variables numerator & denominator
	private static int num;
	private static int den;

	// Create a Fractions3 object and set epsilon
	Fractions3 Fractions3;
	double epsilon;

	// Set up initial Fractions3 instance
	@Before
	public void setUp() {
		Fractions3 = new Fractions3(num, den);
		epsilon = 0.00000000001;
	}

	// Test reduceToLowestForm

	@Test
	public void testReduceToLowestFormWhenInLowestForm() {
		Fractions3 testFractions3 = new Fractions3(2, 3);
		testFractions3.reduceToLowestForm(testFractions3.numerator, testFractions3.denominator);
		assertTrue("Should return itself if already in lowest form", testFractions3.numerator == 2);
		assertTrue("Should return itself if already in lowest form", testFractions3.denominator == 3);
	}

	@Test
	public void testReduceToLowestFormWhenNotInLowestForm() {
		Fractions3 testFractions3 = new Fractions3(4, 16);
		testFractions3.reduceToLowestForm(testFractions3.numerator, testFractions3.denominator);
		assertTrue("Fractions3 should be reduced to lowest form", testFractions3.numerator == 1);
		assertTrue("Fractions3 should be reduced to lowest form", testFractions3.denominator == 4);
	}

	@Test
	public void testReduceToLowestFormWithNegative() {
		Fractions3 testFractions3 = new Fractions3(3, -4);
		testFractions3.reduceToLowestForm(testFractions3.numerator, testFractions3.denominator);
		assertTrue("Negative signs should be moved to the numerator", testFractions3.numerator == -3);
		assertTrue("Negative signs should be moved to the numerator", testFractions3.denominator == 4);
	}

	@Test
	public void testReduceToLowestFormWithZero() {
		Fractions3 testFractions3 = new Fractions3(0, 5);
		testFractions3.reduceToLowestForm(testFractions3.numerator, testFractions3.denominator);
		assertTrue("0/n should be reduced to 0/1", testFractions3.numerator == 0);
		assertTrue("0/n should be reduced to 0/1", testFractions3.denominator == 1);
	}

	@Test
	public void testReduceToLowestFormWithConstants() {
		Fractions3 testFractions3 = new Fractions3(49, 7);
		testFractions3.reduceToLowestForm(testFractions3.numerator, testFractions3.denominator);
		assertTrue("Constants should be reduced to n/1", testFractions3.numerator == 7);
		assertTrue("Constants should be reduced to n/1", testFractions3.denominator == 1);
	}

	// Test add

	@Test
	public void testAddWhenResultInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(1, 3);
		Fractions3 addedFractions3s = Fractions31.add(Fractions32);
		assertTrue("Fractions3s should be added properly", addedFractions3s.numerator == 2);
		assertTrue("Fractions3s should be added properly", addedFractions3s.denominator == 3);
	}

	@Test
	public void testAddWhenResultNotInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(5, 3);
		Fractions3 addedFractions3s = Fractions31.add(Fractions32);
		assertTrue("Fractions3s should be reduced to lowest form", addedFractions3s.numerator == 2);
		assertTrue("Fractions3s should be reduced to lowest form", addedFractions3s.denominator == 1);
	}

	@Test
	public void testAddWhenResultIsZero() {
		Fractions3 Fractions31 = new Fractions3(-1, 3);
		Fractions3 Fractions32 = new Fractions3(1, 3);
		Fractions3 addedFractions3s = Fractions31.add(Fractions32);
		assertTrue("If Fractions3s add to zero, result should be 0/1", addedFractions3s.numerator == 0);
		assertTrue("If Fractions3s add to zero, result should be 0/1", addedFractions3s.denominator == 1);
	}

	@Test
	public void testAddWithNegatives() {
		Fractions3 Fractions31 = new Fractions3(4, -3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 addedFractions3s = Fractions31.add(Fractions32);
		assertTrue("Negative signs should be moved to numerator", addedFractions3s.numerator == -2);
		assertTrue("Negative signs should be moved to numerator", addedFractions3s.denominator == 3);
	}

	// Test subtract

	@Test
	public void testSubtractWhenResultInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(2, 3);
		Fractions3 Fractions32 = new Fractions3(1, 3);
		Fractions3 subtractedFractions3s = Fractions31.subtract(Fractions32);
		assertTrue("Fractions3s should be subtracted properly", subtractedFractions3s.numerator == 1);
		assertTrue("Fractions3s should be subtracted properly", subtractedFractions3s.denominator == 3);
	}

	@Test
	public void testSubtractWhenResultNotInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(13, 4);
		Fractions3 Fractions32 = new Fractions3(1, 4);
		Fractions3 subtractedFractions3s = Fractions31.subtract(Fractions32);
		assertTrue("Fractions3s should be reduced to lowest form", subtractedFractions3s.numerator == 3);
		assertTrue("Fractions3s should be reduced to lowest form", subtractedFractions3s.denominator == 1);
	}

	@Test
	public void testSubtractWhenResultIsZero() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(1, 3);
		Fractions3 subtractedFractions3s = Fractions31.subtract(Fractions32);
		assertTrue("If Fractions3s subtract to zero, result should be 0/1", subtractedFractions3s.numerator == 0);
		assertTrue("If Fractions3s subtract to zero, result should be 0/1", subtractedFractions3s.denominator == 1);
	}

	@Test
	public void testSubtractWhenResultIsNegative() {
		Fractions3 Fractions31 = new Fractions3(2, 3);
		Fractions3 Fractions32 = new Fractions3(3, 3);
		Fractions3 subtractedFractions3s = Fractions31.subtract(Fractions32);
		assertTrue("Negative signs should be moved to numerator", subtractedFractions3s.numerator == -1);
		assertTrue("Negative signs should be moved to numerator", subtractedFractions3s.denominator == 3);
	}

	// Test multiply

	@Test
	public void testMultiplyWhenResultInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Fractions3s should be multiplied correctly", multipliedFractions3s.numerator == 2);
		assertTrue("Fractions3s should be multiplied correctly", multipliedFractions3s.denominator == 9);
	}

	@Test
	public void testMultiplyWhenResultNotInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(3, 3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Fractions3s should be reduced to lowest form", multipliedFractions3s.numerator == 2);
		assertTrue("Fractions3s should be reduced to lowest form", multipliedFractions3s.denominator == 3);
	}

	@Test
	public void testMultiplyWhenDenIsNegative() {
		Fractions3 Fractions31 = new Fractions3(1, -3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Negative signs should be moved to numerator", multipliedFractions3s.numerator == -2);
		assertTrue("Negative signs should be moved to numerator", multipliedFractions3s.denominator == 9);
	}

	@Test
	public void testMultiplyWhenNumIsNegative() {
		Fractions3 Fractions31 = new Fractions3(-1, 3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Negative signs should be in numerator", multipliedFractions3s.numerator == -2);
		assertTrue("Negative signs should be in numerator", multipliedFractions3s.denominator == 9);
	}

	@Test
	public void testMultiplyWhenBothAreNegative() {
		Fractions3 Fractions31 = new Fractions3(1, -3);
		Fractions3 Fractions32 = new Fractions3(-2, 3);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Two negative Fractions3s should multiply to a positive Fractions3",
				multipliedFractions3s.numerator == 2);
		assertTrue("Two negative Fractions3s should multiply to a positive Fractions3",
				multipliedFractions3s.denominator == 9);
	}

	@Test
	public void testMultiplyWithZero() {
		Fractions3 Fractions31 = new Fractions3(55, -3);
		Fractions3 Fractions32 = new Fractions3(0, 3);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("Any Fractions3 multiplied by 0 should be 0/1", multipliedFractions3s.numerator == 0);
		assertTrue("Any Fractions3 multiplied by 0 should be 0/1", multipliedFractions3s.denominator == 1);
	}

	@Test
	public void testMultiplyWithOne() {
		Fractions3 Fractions31 = new Fractions3(1, -3);
		Fractions3 Fractions32 = new Fractions3(1, 1);
		Fractions3 multipliedFractions3s = Fractions31.mul(Fractions32);
		assertTrue("A Fractions3 multiplied by one is itself", multipliedFractions3s.numerator == -1);
		assertTrue("A Fractions3 multiplied by one is itself", multipliedFractions3s.denominator == 3);
	}

	// Test divide
	@Test
	public void testDivideWhenInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 dividedFractions3s = Fractions31.div(Fractions32);
		assertTrue("Fractions3s should be divided properly", dividedFractions3s.numerator == 1);
		assertTrue("Fractions3s should be divided properly", dividedFractions3s.denominator == 2);
	}

	@Test
	public void testDivideWhenNotInLowestForm() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(5, 3);
		Fractions3 dividedFractions3s = Fractions31.div(Fractions32);
		assertTrue("Fractions3s should be reduced to lowest form", dividedFractions3s.numerator == 1);
		assertTrue("Fractions3s should be reduced to lowest form", dividedFractions3s.denominator == 5);
	}

	@Test
	public void testDivideWhenOneIsNegative() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(2, -3);
		Fractions3 dividedFractions3s = Fractions31.div(Fractions32);
		assertTrue("Negative signs should be in numerator", dividedFractions3s.numerator == -1);
		assertTrue("Negative signs should be in numerator", dividedFractions3s.denominator == 2);
	}

	@Test
	public void testDivideWhenBothAreNegative() {
		Fractions3 Fractions31 = new Fractions3(1, -3);
		Fractions3 Fractions32 = new Fractions3(-2, 3);
		Fractions3 dividedFractions3s = Fractions31.div(Fractions32);
		assertTrue("Two negative Fractions3s divide to a positive result", dividedFractions3s.numerator == 1);
		assertTrue("Two negative Fractions3s divide to a positive result", dividedFractions3s.denominator == 2);
	}

	@Test
	public void testDivideWhenResultIsOne() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(1, 3);
		Fractions3 dividedFractions3s = Fractions31.div(Fractions32);
		assertTrue("A Fractions3 divided by itself results in 1/1", dividedFractions3s.numerator == 1);
		assertTrue("A Fractions3 divided by itself results in 1/1", dividedFractions3s.denominator == 1);
	}

	// Test decimal
	@Test
	public void testDecimal() {
		Fractions3 Fractions3 = new Fractions3(1, 4);
		double expected = 0.25;
		assertEquals("Decimal should be positive when Fractions3 is positive", expected, Fractions3.decimal(), epsilon);
	}

	@Test
	public void testDecimalWithNegative() {
		Fractions3 Fractions3 = new Fractions3(1, -4);
		double expected = -0.25;
		assertEquals("Decimal should be negative when Fractions3 is negative", expected, Fractions3.decimal(), epsilon);
	}

	@Test
	public void testDecimalWithZero() {
		Fractions3 Fractions3 = new Fractions3(0, 1);
		double expected = 0.00;
		assertEquals("Decimal should be 0.0 when Fractions3 is 0", expected, Fractions3.decimal(), epsilon);
	}

	@Test
	public void testDecimalWithRepeatingNumber() {
		Fractions3 Fractions3 = new Fractions3(1, -3);
		double expected = -0.33333333333;
		assertEquals("Decimal should have repeating digits", expected, Fractions3.decimal(), epsilon);
	}

	// Test sqr
	@Test
	public void testSqr() {
		Fractions3 Fractions3 = new Fractions3(1, 3);
		Fractions3.sqr();
		assertTrue("Fractions3 should be squared properly", Fractions3.numerator == 1);
		assertTrue("Fractions3 should be squared properly", Fractions3.denominator == 9);
	}

	@Test
	public void testSqrResultNotInLowestForm() {
		Fractions3 Fractions3 = new Fractions3(2, 4);
		Fractions3.sqr();
		assertTrue("Fractions3 should NOT be reduced to lowest form", Fractions3.numerator == 4);
		assertTrue("Fractions3 should NOT be reduced to lowest form", Fractions3.denominator == 16);
	}

	@Test
	public void testSqrWithNegativeDenominator() {
		Fractions3 Fractions3 = new Fractions3(1, -4);
		Fractions3.sqr();
		assertTrue("Any integer squared is positive", Fractions3.numerator == 1);
		assertTrue("Any integer squared is positive", Fractions3.denominator == 16);
	}

	@Test
	public void testSqrWithBothNegative() {
		Fractions3 Fractions3 = new Fractions3(-3, -4);
		Fractions3.sqr();
		assertTrue("Any integer squared is positive", Fractions3.numerator == 9);
		assertTrue("Any integer squared is positive", Fractions3.denominator == 16);
	}

	@Test
	public void testSqrWithZero() {
		Fractions3 Fractions3 = new Fractions3(0, 4);
		Fractions3.sqr();
		assertTrue("Zero squared is zero", Fractions3.numerator == 0);
		assertTrue("Zero squared is zero", Fractions3.denominator == 16);
	}

	// Test toString

	@Test
	public void testToString() {
		Fractions3 testFractions3 = new Fractions3(1, 3);
		String expected = "1/3";
		assertEquals("Should return the Fractions3 as a string", expected, testFractions3.toString());
	}

	@Test
	public void testToStringOneNegative() {
		Fractions3 testFractions3 = new Fractions3(1, -3);
		String expected = "-1/3";
		assertEquals("Should return the negative sign in numerator", expected, testFractions3.toString());
	}

	@Test
	public void testToStringBothNegative() {
		Fractions3 testFractions3 = new Fractions3(-1, -3);
		String expected = "1/3";
		assertEquals("Should return the negative sign in numerator", expected, testFractions3.toString());
	}

	@Test
	public void testToStringWithZero() {
		Fractions3 testFractions3 = new Fractions3(0, -3);
		String expected = "0/3";
		assertEquals("Should get rid of the negative sign if Fractions3 of form 0/n", expected,
				testFractions3.toString());
	}

	// Test average (two Fractions3s)

	@Test
	public void testAverage() {
		Fractions3 Fractions31 = new Fractions3(1, 3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 avgFractions3s = Fractions31.average(Fractions32);
		assertTrue("Fractions3s should be averaged properly", avgFractions3s.numerator == 1);
		assertTrue("Fractions3s should be averaged properly", avgFractions3s.denominator == 2);
	}

	@Test
	public void testAvgWhenOneIsZero() {
		Fractions3 Fractions31 = new Fractions3(0, 3);
		Fractions3 Fractions32 = new Fractions3(2, 3);
		Fractions3 avgFractions3s = Fractions31.average(Fractions32);
		assertTrue("Fractions3s should be averaged properly when one is zero", avgFractions3s.numerator == 1);
		assertTrue("Fractions3s should be averaged properly when one is zero", avgFractions3s.denominator == 3);
	}

	@Test
	public void testAverageWhenBothZero() {
		Fractions3 Fractions31 = new Fractions3(0, 6);
		Fractions3 Fractions32 = new Fractions3(0, 4);
		Fractions3 avgFractions3s = Fractions31.average(Fractions32);
		assertTrue("Average of two zero Fractions3s should be zero", avgFractions3s.numerator == 0);
		assertTrue("Average of two zero Fractions3s should be zero", avgFractions3s.denominator == 1);
	}

	@Test
	public void testAverageWithOneNegative() {
		Fractions3 Fractions31 = new Fractions3(-5, 8);
		Fractions3 Fractions32 = new Fractions3(2, 9);
		Fractions3 avgFractions3s = Fractions31.average(Fractions32);
		assertTrue("Fractions3s should be averaged properly when one is negative", avgFractions3s.numerator == -29);
		assertTrue("Fractions3s should be averaged properly when one is negative", avgFractions3s.denominator == 144);
	}

	@Test
	public void testAverageWithBothNegative() {
		Fractions3 Fractions31 = new Fractions3(-1, 6);
		Fractions3 Fractions32 = new Fractions3(2, -3);
		Fractions3 avgFractions3s = Fractions31.average(Fractions32);
		assertTrue("Fractions3s should be averaged properly when both are negative", avgFractions3s.numerator == -5);
		assertTrue("Fractions3s should be averaged properly when both are negative", avgFractions3s.denominator == 12);
	}

	// Test average (Fractions3 array)

	@Test
	public void testAverageFractions3ArrayWhenEmpty() {
		Fractions3[] Fractions3s = {};
		Fractions3 avgFractions3s = Fractions3.average(Fractions3s);
		assertTrue("Average of an empty array should be 0/1", avgFractions3s.numerator == 0);
		assertTrue("Average of an empty array should be 0/1", avgFractions3s.denominator == 1);
	}

	@Test
	public void testAverageFractions3ArrayWithOneElement() {
		Fractions3 Fractions31 = new Fractions3(1, 2);
		Fractions3[] Fractions3s = { Fractions31 };
		Fractions3 avgFractions3s = Fractions3.average(Fractions3s);
		assertTrue("Average of a one-element array should be that element", avgFractions3s.numerator == 1);
		assertTrue("Average of a one-element array should be that element", avgFractions3s.denominator == 2);
	}

	@Test
	public void testAverageFractions3ArrayOfSameElements() {
		Fractions3 Fractions31 = new Fractions3(1, 2);
		Fractions3 Fractions32 = new Fractions3(1, 2);
		Fractions3 Fractions33 = new Fractions3(1, 2);
		Fractions3[] Fractions3s = { Fractions31, Fractions32, Fractions33 };
		Fractions3 avgFractions3s = Fractions3.average(Fractions3s);
		assertTrue("Average of an array of all the same elements should be that element",
				avgFractions3s.numerator == 1);
		assertTrue("Average of an array of all the same elements should be that element",
				avgFractions3s.denominator == 2);
	}

	@Test
	public void testAverageFractions3ArrayOfDifferentElements() {
		Fractions3 Fractions31 = new Fractions3(1, 2);
		Fractions3 Fractions32 = new Fractions3(3, 5);
		Fractions3 Fractions33 = new Fractions3(6, 8);
		Fractions3[] Fractions3s = { Fractions31, Fractions32, Fractions33 };
		Fractions3 avgFractions3s = Fractions3.average(Fractions3s);
		assertTrue("Takes the average properly", avgFractions3s.numerator == 37);
		assertTrue("Takes the average properly", avgFractions3s.denominator == 60);
	}

	// Test average (integer array)

	@Test
	public void testAverageIntegerArrayWhenEmpty() {
		int[] Fractions3s = {};
		Fractions3 avgInteger = Fractions3.average(Fractions3s);
		assertTrue("Average of an empty array should be 0/1", avgInteger.numerator == 0);
		assertTrue("Average of an empty array should be 0/1", avgInteger.denominator == 1);
	}

	@Test
	public void testAverageIntegerArrayWithOneElement() {
		int[] Fractions3s = { 3 };
		Fractions3 avgInteger = Fractions3.average(Fractions3s);
		assertTrue("Average of a one-element array should be that element", avgInteger.numerator == 3);
		assertTrue("Average of a one-element array should be that element", avgInteger.denominator == 1);
	}

	@Test
	public void testAverageIntegerArrayWithSameElements() {
		int[] Fractions3s = { 3, 3, 3 };
		Fractions3 avgInteger = Fractions3.average(Fractions3s);
		assertTrue("Average of an array of all the same elements should be that element", avgInteger.numerator == 3);
		assertTrue("Average of an array of all the same elements should be that element", avgInteger.denominator == 1);
	}

	@Test
	public void testAverageIntegerArrayOfPositives() {
		int[] Fractions3s = { 51, 101, 602, 71, 51, 0, 34, 51, 9 };
		Fractions3 avgInteger = Fractions3.average(Fractions3s);
		assertTrue("Takes the average of positive elements properly", avgInteger.numerator == 970);
		assertTrue("Takes the average of positive elements properly", avgInteger.denominator == 9);
	}

	@Test
	public void testAverageIntegerArrayOfNegatives() {
		int[] Fractions3s = { -51, -101, -602, -71, -51, 0, -34, -51, -9 };
		Fractions3 avgInteger = Fractions3.average(Fractions3s);
		assertTrue("Takes the average of negative elements properly", avgInteger.numerator == -970);
		assertTrue("Takes the average of negative elements properly", avgInteger.denominator == 9);
	}

	@Test
	public void testAverageIntegerArrayPositivesAndNegatives() {
		int[] Fractions3s = { -5, 2, -6, 7, 0 };
		Fractions3 avgInteger = Fractions3.average(Fractions3s);
		assertTrue("Takes the average of both negative & positive elements properly", avgInteger.numerator == -2);
		assertTrue("Takes the average of both negative & positive elements properly", avgInteger.denominator == 5);
	}

}