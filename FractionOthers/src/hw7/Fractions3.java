package hw7;

public class Fractions3 {

	// Instance variables numerator & denominator
	int numerator;
	int denominator;

	// Fractions3 constructor
	public Fractions3(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/*
	 * Helper method: find the greatest common divisor (GCD) of two integers
	 */
	private static int gcd(int int1, int int2) {
		while (int1 != 0 && int2 != 0) {
			int c = int2;
			int2 = int1 % int2;
			int1 = c;
		}
		// Return the absolute value of the GCD
		return Math.abs(int1 + int2);
	}

	/*
	 * Reduces the current Fractions3 by eliminating common factors
	 */
	void reduceToLowestForm(int n, int d) {
		// Find GCD of numerator & denominator
		int theGcd = gcd(n, d);
		if (d < 0) {
			denominator = (-1 * d) / theGcd;
			numerator = (-1 * n) / theGcd;
		} else {
			denominator = (d / theGcd);
			numerator = (n / theGcd);
		}
	}

	/*
	 * Adds the current Fractions3 to the otherFractions3, returns a new Fractions3
	 * that is the sum of the two Fractions3s
	 */
	Fractions3 add(Fractions3 otherFractions3) {
		// Cross multiply the numerators & denominators and subtract
		int newNum = (this.numerator * otherFractions3.denominator) + (otherFractions3.numerator * this.denominator);
		// Multiply denominators together to get a common denominator
		int newDen = this.denominator * otherFractions3.denominator;
		// Create a new Fractions3 object
		Fractions3 newFractions3 = new Fractions3(newNum, newDen);
		// Reduce it to lowest form
		newFractions3.reduceToLowestForm(newFractions3.numerator, newFractions3.denominator);
		// Return the new Fractions3
		return newFractions3;
	}

	/*
	 * Subtract otherFractions3 from the current Fractions3, i.e. thisFractions3 -
	 * otherFractions3
	 */
	Fractions3 subtract(Fractions3 otherFractions3) {
		// Create a negative one Fractions3
		Fractions3 negativeOne = new Fractions3(-1, 1);
		// Add the first Fractions3 and negativeOne * the second Fractions3
		Fractions3 subtractedFractions3s = this.add(negativeOne.mul(otherFractions3));
		// Reduce and return the resulting Fractions3
		return subtractedFractions3s;
	}

	/*
	 * Multiply the current Fractions3 by the otherFractions3
	 */
	Fractions3 mul(Fractions3 otherFractions3) {
		// Multiply the numerators
		int newNum = this.numerator * otherFractions3.numerator;
		// Multiply the denominators
		int newDen = this.denominator * otherFractions3.denominator;
		// Reduce and return the resulting Fractions3
		// Create a new Fractions3 object
		Fractions3 newFractions3 = new Fractions3(newNum, newDen);
		// Reduce it to lowest form
		newFractions3.reduceToLowestForm(newFractions3.numerator, newFractions3.denominator);
		// Return the new Fractions3
		return newFractions3;
	}

	/*
	 * Divide the current Fractions3 by the otherFractions3
	 */
	Fractions3 div(Fractions3 otherFractions3) {
		// Multiply Fractions3 by the inverse of otherFractions3 to divide
		int newNum = this.numerator * otherFractions3.denominator;
		// Multiply the denominators
		int newDen = this.denominator * otherFractions3.numerator;
		// Reduce and return the resulting Fractions3
		// Create a new Fractions3 object
		Fractions3 newFractions3 = new Fractions3(newNum, newDen);
		// Reduce it to lowest form
		newFractions3.reduceToLowestForm(newFractions3.numerator, newFractions3.denominator);
		// Return the new Fractions3
		return newFractions3;
	}

	/*
	 * Returns this Fractions3 in decimal form
	 */
	double decimal() {
		// Divide the numerator by the denominator normally,
		// but convert one to a double so the result is a double
		return (double) numerator / denominator;
	}

	/*
	 * Squares the current Fractions3 (modifies the current Fractions3), but doesn't
	 * reduce the Fractions3
	 */
	void sqr() {
		// Square both the numerator and denominator of the current Fractions3
		int newNum = (int) numerator * numerator;
		int newDen = (int) denominator * denominator;
		// Set the numerator and denominator to the results
		numerator = newNum;
		denominator = newDen;
	}

	/*
	 * Returns a string representation of the current Fractions3
	 */
	public String toString() {
		// Resolve negatives in the denominator by multiplying both the
		// numerator & denominator by (-1)
		if (denominator < 0) {
			denominator = (-1 * denominator);
			numerator = (-1 * numerator);
		}
		// Return the result as a string
		return (numerator + "/" + denominator);
	}

	/*
	 * Averages the current Fractions3 with the otherFractions3
	 */
	Fractions3 average(Fractions3 otherFractions3) {
		// Add the two Fractions3s together
		Fractions3 addedFractions3s = this.add(otherFractions3);
		// Create a Fractions3 2/1
		Fractions3 twoFractions3 = new Fractions3(2, 1);
		// Divide the result by twoFractions3 to get the average
		Fractions3 averagedFractions3s = addedFractions3s.div(twoFractions3);
		// Reduce it to lowest form
		averagedFractions3s.reduceToLowestForm(averagedFractions3s.numerator, averagedFractions3s.denominator);
		// Return the new Fractions3
		return averagedFractions3s;
	}

	/*
	 * Averages all Fractions3s in the array
	 */
	Fractions3 average(Fractions3[] Fractions3s) {
		// First check whether the array is empty;
		// if so, return the Fractions3 0/1
		if (Fractions3s.length == 0) {
			return new Fractions3(0, 1);
		} else {
			// Initialize a zero-valued Fractions3 as the start of our sum
			Fractions3 Fractions3Sum = new Fractions3(0, 1);
			// Fractions3 theSum = Fractions3Sum.add(Fractions3s[0]);
			// Iteratively add each Fractions3 in the array to the sum
			for (int i = 0; i < Fractions3s.length; i++) {
				Fractions3Sum = Fractions3Sum.add(Fractions3s[i]);
			}
			// Get the length of the Fractions3s array and turn it into a Fractions3 object
			Fractions3 Fractions3Length = new Fractions3(Fractions3s.length, 1);
			// Divide the Fractions3 sum by the length of the Fractions3 array
			Fractions3 theAverage = Fractions3Sum.div(Fractions3Length);
			// Reduce it to lowest form
			theAverage.reduceToLowestForm(theAverage.numerator, theAverage.denominator);
			// Return a new Fractions3 object
			return new Fractions3(theAverage.numerator, theAverage.denominator);
		}
	}

	/*
	 * Averages all integers in the array
	 */
	Fractions3 average(int[] ints) {
		// First check whether the array is empty;
		// if so, return the Fractions3 0/1
		if (ints.length == 0) {
			return new Fractions3(0, 1);
		} else {
			// Initialize an empty list of Fractions3s to which we can add
			// Fractions3s that result from the integer list
			Fractions3[] Fractions3s = new Fractions3[ints.length];
			// Iterate through the integer list, convert each element to a Fractions3
			// and add it to the Fractions3s list
			for (int i = 0; i < ints.length; i++) {
				Fractions3s[i] = new Fractions3(ints[i], 1);
			}
			// Average all Fractions3s in the Fractions3s array
			Fractions3 theAverage = average(Fractions3s);
			// Reduce it to lowest form
			theAverage.reduceToLowestForm(theAverage.numerator, theAverage.denominator);
			// Return a new Fractions3 object
			return new Fractions3(theAverage.numerator, theAverage.denominator);
		}
	}
}