package hw7;

/**
 * Represents a Fractions1 by a numerator and a denominator.
 *
 */
public class Fractions1 {

	// Create instance variables

	/**
	 * Integers for numerator and denominator.
	 */
	int numerator;
	int denominator;

	/**
	 * Create a Fractions1 with given numerator and denominator. For negative
	 * Fractions1s, make sure the minus goes with the numerator.
	 * 
	 * @param numerator
	 * @param denominator
	 */
	public Fractions1(int numerator, int denominator) {
		// if the Fractions1 is negative (or zero), pass the minus symbol to the
		// numerator
		if ((numerator <= 0 && denominator > 0) || (numerator >= 0 && denominator < 0)) {
			this.numerator = -Math.abs(numerator);
			this.denominator = Math.abs(denominator);
		} else {
			// if the the numerator and denominator are both greater or smaller than 0
			// remove all the minus symbol
			this.numerator = Math.abs(numerator);
			this.denominator = Math.abs(denominator);
		}
	}

	/**
	 * Reduce the current Fractions1 by eliminating common factors. 0 is represented
	 * by 0/1.
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
	 * Add the current Fractions1 to the given otherFractions1. Returns a new
	 * Fractions1 that is the sum of the two Fractions1s.
	 * 
	 * @param otherFractions1
	 * @return
	 */
	public Fractions1 add(Fractions1 otherFractions1) {
		// the added numerator
		int newNumerator = this.numerator * otherFractions1.denominator + otherFractions1.numerator * this.denominator;
		// the added denominator
		int newDenominator = this.denominator * otherFractions1.denominator;
		// a new Fractions1 to store the added value
		Fractions1 newFrac = new Fractions1(newNumerator, newDenominator);
		// reduce the Fractions1 to its lowest form
		newFrac.reduceToLowestForm();
		return newFrac;
	}

	/**
	 * Subtract the given otherFractions1 from the current Fractions1. Returns a new
	 * Fractions1 that is the difference of the two Fractions1s.
	 * 
	 * @param otherFractions1
	 * @return
	 */
	public Fractions1 subtract(Fractions1 otherFractions1) {
		// numerator after the subtraction
		int newNumerator = this.numerator * otherFractions1.denominator - otherFractions1.numerator * this.denominator;
		// denominator after the subtraction
		int newDenominator = this.denominator * otherFractions1.denominator;

		// a new Fractions1 to store the subtracted value
		Fractions1 newFrac = new Fractions1(newNumerator, newDenominator);
		// reduce the Fractions1 to its lowest form
		newFrac.reduceToLowestForm();
		return newFrac;
	}

	/**
	 * Multiply the current Fractions1 by the given otherFractions1. Returns a new
	 * Fractions1 that is the product of this Fractions1 and the otherFractions1.
	 * 
	 * @param otherFractions1
	 * @return
	 */
	public Fractions1 mul(Fractions1 otherFractions1) {
		// numerator and denominator after the multiplication
		int newNumerator = this.numerator * otherFractions1.numerator;
		int newDenominator = this.denominator * otherFractions1.denominator;
		// a new Fractions1 and reduce it to its lowest form
		Fractions1 newFrac = new Fractions1(newNumerator, newDenominator);
		newFrac.reduceToLowestForm();
		return newFrac;
	}

	/**
	 * Divide the current Fractions1 by the given otherFractions1. Returns a new
	 * Fractions1 that is the quotient of this Fractions1 and the otherFractions1.
	 * 
	 * @param otherFractions1
	 * @return
	 */
	public Fractions1 div(Fractions1 otherFractions1) {
		// numerator and denominator after the division
		int newNumerator = this.numerator * otherFractions1.denominator;
		int newDenominator = this.denominator * otherFractions1.numerator;
		// a new Fractions1 and reduce it to its lowest form
		Fractions1 newFrac = new Fractions1(newNumerator, newDenominator);
		newFrac.reduceToLowestForm();
		return newFrac;
	}

	/**
	 * Return this Fractions1 in decimal form.
	 * 
	 * @return
	 */
	public double decimal() {
		// cast the double type to the result of dividing the numerator by denominator
		double fracDecimal = (double) this.numerator / this.denominator;
		return fracDecimal;
	}

	/**
	 * Square the current Fractions1.
	 */
	public void sqr() {
		// modifies the current Fractions1 and reduces it to its lowest
		this.numerator = this.numerator * this.numerator;
		this.denominator = this.denominator * this.denominator;
		this.reduceToLowestForm();
	}

	/**
	 * Average the current Fractions1 with the given otherFractions1. Return a new
	 * Fractions1 that is the average of this Fractions1 and the otherFractions1.
	 * 
	 * @param otherFractions1
	 * @return
	 */
	public Fractions1 average(Fractions1 otherFractions1) {
		// add otherFractions1 to thisFractions1 and divide the result by 2
		int newNumerator = this.add(otherFractions1).numerator;
		int newDenominator = this.add(otherFractions1).denominator * 2;

		// a new Fractions1 to store the result and reduce to its lowest
		Fractions1 newFrac = new Fractions1(newNumerator, newDenominator);
		newFrac.reduceToLowestForm();
		return newFrac;
	}

	/**
	 * Average all of the Fractions1s in the given array. Return the average of the
	 * array.
	 * 
	 * @param Fractions1s
	 * @return
	 */
	public static Fractions1 average(Fractions1[] Fractions1s) {
		// two local variables to store the new numerator and denominator
		int totalNumerator = 0;
		int totalDenominator = 1;
		// create a new Fractions1 to store the process value
		Fractions1 aveFrac = new Fractions1(totalNumerator, totalDenominator);

		// if the array is not empty, iterate over the array, adding the Fractions1s
		// together
		if (Fractions1s.length > 0) {
			for (int i = 0; i < Fractions1s.length; i++) {
				aveFrac = aveFrac.add(Fractions1s[i]);
				totalNumerator = aveFrac.numerator;
				totalDenominator = aveFrac.denominator;
			}
			// calculate the average by multiply the denominator to the number of elements
			totalDenominator *= Fractions1s.length;
		}

		// create a new Fractions1 to store the final average
		Fractions1 averageArr = new Fractions1(totalNumerator, totalDenominator);
		// reduce the Fractions1
		averageArr.reduceToLowestForm();
		return averageArr;
	}

	/**
	 * Average all the integers in the given array. Return the average of the array
	 * as a new Fractions1.
	 * 
	 * @param ints
	 * @return
	 */
	public static Fractions1 average(int[] ints) {
		// two local variables to store the new numerator and denominator
		int aveIntNumerator = 0;
		int aveIntDenominator = 1;
		// an integer variable to store the total amount
		int totalInts = 0;

		// if the array is not empty
		// iterate over the array to calculate the total
		if (ints.length > 0) {
			for (int i = 0; i < ints.length; i++) {
				totalInts += ints[i];
			}
			aveIntNumerator = totalInts;
			aveIntDenominator = ints.length;
		}

		// create a new Fractions1 to store the result and reduce it to lowest
		Fractions1 aveInts = new Fractions1(aveIntNumerator, aveIntDenominator);
		aveInts.reduceToLowestForm();
		return aveInts;
	}

	/**
	 * Compare the given object (as a Fractions1) to the current Fractions1, for
	 * equality.
	 */
	@Override
	public boolean equals(Object object) {
		// cast the Fractions1 type to the object
		Fractions1 toTest = (Fractions1) object;
		// clone it to reduce
		Fractions1 toTestClone = new Fractions1(toTest.numerator, toTest.denominator);
		// clone thisFractions1 to reduce
		Fractions1 thisClone = new Fractions1(this.numerator, this.denominator);
		// reduce the cloned Fractions1s for comparison
		toTestClone.reduceToLowestForm();
		thisClone.reduceToLowestForm();

		// if the numerators and the denominators are equal, return true
		// else, return false as not equal
		if (thisClone.numerator == toTestClone.numerator) {
			if (thisClone.denominator == toTestClone.denominator) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return a string representation of the current Fractions1.
	 */
	@Override
	public String toString() {
		// create a string variable to store the info of a Fractions1
		String Fractions1_str = (this.numerator + "/" + this.denominator);
		return Fractions1_str;
	}
}
