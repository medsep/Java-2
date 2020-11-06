/**
 * """
*Name : Mehdi Sepahvand,
*Penn ID: 15228700,
*Statement of work: Work is completely my own. The only resources used were lecture\n
* codes, recitation videos and Java help library.
 */
package hw7;

public class Fraction {

	int numerator;
	int denominator;

	// constructor
	/**
	 * Create fraction with a given numerator and denominator and formats the
	 * negative fraction
	 * 
	 * @param numerator
	 * @param denominator
	 */

	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;

		this.formatNegativeFraction();
		// this.reduceToLowestForm();
	}

	/**
	 * Format negative fraction, with -ve always on the numerator.
	 */

	void formatNegativeFraction() {
		if (this.denominator < 0) {
			this.denominator *= -1;
			this.numerator *= -1;
		}
	}

	/**
	 * Reduce to lowest form by eliminating common factors
	 */

	public void reduceToLowestForm() {
		// set up the variable to store the biggest common factor
		int commonFactor = 1;
		// initialize instance variable, reducing 0 to 0/1
		if (this.numerator == 0) {
			this.denominator = 1;
		} else {
			// iterate over the possible common factors and take the value of the last one
			for (int i = 1; i <= Math.max(this.numerator, this.denominator); i++) {
				if (this.numerator % i == 0 && this.denominator % i == 0) {
					commonFactor = i;
				}
			}
			// divide both numerator and denominator by the biggest common factor
			this.numerator /= commonFactor;
			this.denominator /= commonFactor;
		}
	}

	/**
	 * Add the current fraction to the given otherFraction. Returns a new Fraction
	 * that is the sum of the two Fractions.
	 * 
	 * @param otherFraction
	 * @return a new Fraction that is the sum of the two Fractions.
	 */

	public Fraction add(Fraction otherFraction) {
		// new
		Fraction theNewFractions = new Fraction(numerator, denominator);
		// numerator calculation
		theNewFractions.numerator = this.numerator * otherFraction.denominator
				+ this.denominator * otherFraction.numerator;
		// denominator calculation
		theNewFractions.denominator = this.denominator * otherFraction.denominator;
		// The returned fraction must be in reduced form.
		theNewFractions.reduceToLowestForm();
		// Returns a new Fractions2 that is the sum of the two Fractions2s.
		return theNewFractions;
	}

	/**
	 * Subtract the given otherFraction from the current fraction. That is,
	 * thisFraction - otherFraction.
	 * 
	 * @param otherFraction
	 * @return a new Fraction that is the difference of the two Fractions.
	 */

	public Fraction subtract(Fraction otherFraction) {

		Fraction theNewFraction = new Fraction(numerator, denominator);
		theNewFraction.numerator = this.numerator * otherFraction.denominator
				- this.denominator * otherFraction.numerator;
		// denominator calculation
		theNewFraction.denominator = this.denominator * otherFraction.denominator;
		// The returned Fractions2 must be in reduced/lowest form.
		theNewFraction.reduceToLowestForm();

		return theNewFraction;
	}

	/**
	 * Multiply the current fraction by the given otherFraction.
	 * 
	 * @param otherFraction
	 * @return a new Fraction that is the product of this fraction and the
	 *         otherFraction.
	 */

	public Fraction mul(Fraction otherFraction) {

		this.reduceToLowestForm();
		otherFraction.reduceToLowestForm();

		int prodNumerator = this.numerator * otherFraction.numerator;
		int prodDenominator = this.denominator * otherFraction.denominator;

		Fraction newFraction = new Fraction(prodNumerator, prodDenominator);
		// Ensure it is in reduced form.
		newFraction.reduceToLowestForm();
		return newFraction;
	}

	/**
	 * Divide the current fraction by the given otherFraction. That is, thisFraction
	 * / otherFraction.
	 * 
	 * @param otherFraction
	 * @return a new Fraction that is the quotient of this fraction and the
	 *         otherFraction.
	 */

	public Fraction div(Fraction otherFraction) {

		this.reduceToLowestForm();
		otherFraction.reduceToLowestForm();

		int otherNumerator = otherFraction.numerator;
		int otherDenominator = otherFraction.denominator;
		otherFraction.numerator = otherDenominator;
		otherFraction.denominator = otherNumerator;

		Fraction newFraction = this.mul(otherFraction);
		// Ensure it is in reduced form.
		newFraction.reduceToLowestForm();

		return newFraction;
	}

	/***
	 * return fraction to decimal e.g. 1/3=0.333333333333333
	 * 
	 * @return this fraction in decimal form
	 */
	public double decimal() {
		double doubleDenominator = (double) this.denominator;
		return this.numerator / doubleDenominator;
	}

	/**
	 * Square the current fraction. 2/3=>4/9
	 */

	public void sqr() {
		// modifies the current Fractions1 and reduces it to its lowest
		this.numerator = this.numerator * this.numerator;
		this.denominator = this.denominator * this.denominator;
		// reduce to lowest form
		this.reduceToLowestForm();
	}

	/**
	 * Average the current fraction with the given otherFraction.
	 * 
	 * @param otherFraction
	 * @return a new Fraction that is the average of this fraction and the
	 *         otherFraction.
	 */

	public Fraction average(Fraction otherFraction) {

		Fraction sumFractions = this.add(otherFraction);
		Fraction twoFractions = new Fraction(2, 1);
		Fraction divFraction = sumFractions.div(twoFractions);
		return divFraction;
	}

	/**
	 * Static method to average all of the fractions in the given array.
	 * 
	 * @param fractions
	 * @return the average of the array.
	 */

	public static Fraction average(Fraction[] fractions) {

		Fraction divFraction = new Fraction(0, 1);
		int numFractions = fractions.length;
		// If the array is empty, return a new Fraction that equals 0. That is 0/1.
		if (numFractions > 0) {
			Fraction sumFractions = fractions[0];
			for (int i = 1; i < numFractions; i++) {
				sumFractions = sumFractions.add(fractions[i]);
			}
			Fraction lenFraction = new Fraction(numFractions, 1);
			divFraction = sumFractions.div(lenFraction);
			// The returned Fraction must be in reduced/lowest form.
			divFraction.reduceToLowestForm();
		}
		return divFraction;
	}

	/**
	 * Static method to average all the integers in the given array.
	 * 
	 * @param ints
	 * @return the average of the array as a new Fraction.
	 */

	public static Fraction average(int[] ints) {

		Fraction divFraction = new Fraction(0, 1);
		int numInts = ints.length;

		if (numInts > 0) {
			int sumInts = ints[0];
			for (int i = 1; i < numInts; i++) {
				sumInts += ints[i];
			}
			divFraction = new Fraction(sumInts, numInts);
			// The returned Fraction must be in reduced/lowest form.
			divFraction.reduceToLowestForm();
		}
		return divFraction;
	}

	/**
	 * Overridden method to compare the given object (as a fraction) to the current
	 * fraction, for equality.
	 */

	@Override
	public boolean equals(Object object) {
		// Returns false if object is not a fraction
		if (!(object instanceof Fraction)) {
			return false;
		}
		Fraction thisFraction = new Fraction(this.numerator, this.denominator);
		// reduce to lowest form
		thisFraction.reduceToLowestForm();

		Fraction otherFraction = (Fraction) object;
		otherFraction = new Fraction(otherFraction.numerator, otherFraction.denominator);
		otherFraction.reduceToLowestForm();

		return (thisFraction.numerator == otherFraction.numerator
				&& thisFraction.denominator == otherFraction.denominator);
	}

	/**
	 * Overridden method to return a string representation of the current fraction.
	 */

	@Override
	public String toString() {

		return this.numerator + "/" + this.denominator;
	}
}
