package hw7;

/**
 * The Fractions2 Class A Fractions2 is a number of the form
 * numerator/denominator where the numerator and denominator are integers. The
 * denominator cannot be 0. You may assume that no user will input a denominator
 * of 0.
 *
 */

public class Fractions2 {

	// Create instance variables
	/**
	 * Integers for numerator and denominator
	 */
	int numerator;
	int denominator;

	// constructor
	/**
	 * to create a Fractions2 with the given numerator and denominator.
	 * 
	 * @param numerator
	 * @param denominator
	 */
	public Fractions2(int numerator, int denominator) {
		// The constructor should set the numerator and denominator instance variables
		// in the Fractions2 class.
		this.numerator = numerator;
		this.denominator = denominator;

		// The convention is that negative Fractions2s have the negative in the
		// numerator.
		if (this.denominator < 0) {
			this.numerator = -this.numerator;
			this.denominator = -this.denominator;
		}

	}

	/**
	 * Reduce the current Fractions2 by eliminating common factors. Remember, the
	 * convention is that negative Fractions2s have the negative in the numerator.
	 */
	public void reduceToLowestForm() {
		// use gcm method to find common factors.
		int gcm = Math.abs(gcm(this.numerator, this.denominator));
		// after the common factor
		this.numerator = this.numerator / gcm;
		this.denominator = this.denominator / gcm;
	}

	/**
	 * find common factor gcm
	 * 
	 * @param a numerator
	 * @param b denominator
	 * @return
	 */
	public static int gcm(int a, int b) {
		// use this function to conduct the common factor calculation
		return b == 0 ? a : gcm(b, a % b);
	}

	/**
	 * Add the current Fractions2 to the given otherFractions2.
	 * 
	 * @param otherFractions2
	 * @return the add result Returns a new Fractions2 that is the sum of the two
	 *         Fractions2s.
	 */
	public Fractions2 add(Fractions2 otherFractions2) {
		// new
		Fractions2 theNewFractions2 = new Fractions2(numerator, denominator);
		// numerator calculation
		theNewFractions2.numerator = this.numerator * otherFractions2.denominator
				+ this.denominator * otherFractions2.numerator;
		// denominator calculation
		theNewFractions2.denominator = this.denominator * otherFractions2.denominator;
		// The returned Fractions2 must be in reduced/lowest form.
		theNewFractions2.reduceToLowestForm();
		// Returns a new Fractions2 that is the sum of the two Fractions2s.
		return theNewFractions2;
	}

	/**
	 * Subtract the given otherFractions2 from the current Fractions2. That is,
	 * thisFractions2 - otherFractions2.
	 * 
	 * @param otherFractions2
	 * @return Returns a new Fractions2 that is the difference of the two
	 *         Fractions2s.
	 */
	public Fractions2 subtract(Fractions2 otherFractions2) {

		// new
		Fractions2 theNewFractions2 = new Fractions2(numerator, denominator);
		// numerator calculation
		theNewFractions2.numerator = this.numerator * otherFractions2.denominator
				- this.denominator * otherFractions2.numerator;
		// denominator calculation
		theNewFractions2.denominator = this.denominator * otherFractions2.denominator;
		// The returned Fractions2 must be in reduced/lowest form.
		theNewFractions2.reduceToLowestForm();
		// Returns a new Fractions2 that is the difference of the two Fractions2s.
		return theNewFractions2;
	}

	/**
	 * Multiply the current Fractions2 by the given otherFractions2.
	 * 
	 * @param otherFractions2
	 * @return Returns a new Fractions2 that is the product of this Fractions2 and
	 *         the otherFractions2.
	 */
	public Fractions2 mul(Fractions2 otherFractions2) {
		// new Fractions2 theNewFractions2
		Fractions2 theNewFractions2 = new Fractions2(numerator, denominator);
		// numerator calculation
		theNewFractions2.numerator = this.numerator * otherFractions2.numerator;
		// denominator calculation
		theNewFractions2.denominator = this.denominator * otherFractions2.denominator;
		// The returned Fractions2 must be in reduced/lowest form.
		theNewFractions2.reduceToLowestForm();

		// Returns a new Fractions2 that is the product of this Fractions2 and the
		// otherFractions2.
		return theNewFractions2;
	}

	/**
	 * Divide the current Fractions2 by the given otherFractions2. That is,
	 * thisFractions2 / otherFractions2.
	 * 
	 * @param otherFractions2
	 * @return Returns a new Fractions2 that is the quotient of this Fractions2 and
	 *         the otherFractions2.
	 */
	public Fractions2 div(Fractions2 otherFractions2) {
		// new Fractions2 theNewFractions2
		Fractions2 theNewFractions2 = new Fractions2(numerator, denominator);
		// numerator calculation
		theNewFractions2.numerator = this.numerator * otherFractions2.denominator;
		// denominator calculation
		theNewFractions2.denominator = this.denominator * otherFractions2.numerator;
		// The returned Fractions2 must be in reduced/lowest form.
		theNewFractions2.reduceToLowestForm();
		return theNewFractions2;
	}

	/**
	 * Return this Fractions2 in decimal form.
	 * 
	 * @return
	 */
	public double decimal() {
		// use (double) to convert type
		double decimalNumber = (double) this.numerator / this.denominator;
		return decimalNumber;
	}

	/**
	 * Square the current Fractions2. This method modifies the current Fractions2
	 * and reduces it to lowest form.
	 */
	public void sqr() {
		// numerator calculation
		this.numerator = this.numerator * this.numerator;
		// denominator calculation
		this.denominator = this.denominator * this.denominator;
		// reduces it to lowest form
		this.reduceToLowestForm();
	}

	/**
	 * Average the current Fractions2 with the given otherFractions2. The returned
	 * Fractions2 must be in reduced/lowest form.
	 * 
	 * @param otherFractions2
	 * @return Return a new Fractions2 that is the average of this Fractions2 and
	 *         the otherFractions2.
	 */

	public Fractions2 average(Fractions2 otherFractions2) {
		// new Fractions2
		Fractions2 theNewFractions2 = new Fractions2(numerator, denominator);
		// numerator calculation
		theNewFractions2.numerator = this.numerator * otherFractions2.denominator
				+ this.denominator * otherFractions2.numerator;
		// denominator calculation to find the average double
		theNewFractions2.denominator = this.denominator * otherFractions2.denominator * 2;
		// in reduced/lowest form
		theNewFractions2.reduceToLowestForm();
		return theNewFractions2;

	}

	/**
	 * Static method to average all of the Fractions2s in the given array. don’t
	 * need to create an instance of the Fractions2 class in order to call a static
	 * method
	 * 
	 * @param Fractions2s
	 * @return
	 */
	public static Fractions2 average(Fractions2[] Fractions2s) {
		// two integers if there is nothing in Fractions2
		// numerator = 0
		int newNumerator = 0;
		// denominator =1
		int newDenominator = 1;
		Fractions2 theNewFractions2 = new Fractions2(newNumerator, newDenominator);
		// if Fractions2s is not empty
		if (Fractions2s.length > 0) {
			// add every Fractions2 in Fractions2s
			for (int i = 0; i < Fractions2s.length; i++) {
				theNewFractions2 = theNewFractions2.add(Fractions2s[i]);
				// renew the two
				newNumerator = theNewFractions2.numerator;
				newDenominator = theNewFractions2.denominator;
			}
			// to find the average
			newDenominator *= Fractions2s.length;
		}
		// a new Fractions2
		Fractions2 theNewFractions21 = new Fractions2(newNumerator, newDenominator);
		// reduce to lowest
		theNewFractions21.reduceToLowestForm();

		return theNewFractions21;

	}

	/**
	 * Static method to average all the integers in the given array. don’t need to
	 * create an instance of the Fractions2 class in order to call a static method
	 * 
	 * @param ints
	 * @return Return the average of the array as a new Fractions2.
	 */
	public static Fractions2 average(int[] ints) {
		// two integers if there is nothing in Fractions2
		// if empty
		int aveIntNumerator = 0;
		int aveIntDenominator = 1;
		int totalInts = 0;
		// if Fractions2s is not empty
		if (ints.length > 0) {
			for (int i = 0; i < ints.length; i++) {
				totalInts += ints[i];
			}
			aveIntNumerator = totalInts;
			aveIntDenominator = ints.length;
		}
		// new Fractions2 aveInts
		Fractions2 aveInts = new Fractions2(aveIntNumerator, aveIntDenominator);
		// reduce to lowest
		aveInts.reduceToLowestForm();
		return aveInts;

	}

	/**
	 * Overriden method to compare the given object (as a Fractions2) to the current
	 * Fractions2, for equality.
	 */
	@Override

	public boolean equals(Object object) {
		Fractions2 toTest = (Fractions2) object;
		// Two Fractions2s are considered equal if they have the same numerator and same
		// denominator, after eliminating common factors.
		Fractions2 toTestClone = new Fractions2(toTest.numerator, toTest.denominator);
		// This method does not (permanently) reduce the current Fractions2 to lowest
		// form.
		Fractions2 thisClone = new Fractions2(this.numerator, this.denominator);
		// reduce
		toTestClone.reduceToLowestForm();
		thisClone.reduceToLowestForm();
		// check
		if (thisClone.numerator == toTestClone.numerator) {
			// check again
			if (thisClone.denominator == toTestClone.denominator) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Overriden method to return a string representation of the current Fractions2.
	 */
	@Override
	public String toString() {
		// There is a no whitespace in this string.
		String fracString = (numerator + "/" + denominator);
		return fracString;
	}

}