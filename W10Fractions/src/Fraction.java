
public class Fraction {

	// instance vars

	int numerator;
	int denominator;

	// constrctor

	/***
	 * 
	 * @param numerator
	 * @param denominator
	 */

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * Compares 2 faction for eqailiyu by comparing num and den
	 */

	@Override
	public boolean equals(Object obj) {
		// cast object to fraction
		Fraction otherFraction = (Fraction) obj;

		// compare numerator and denominator of both fractions
		return (this.numerator == otherFraction.numerator && this.denominator == otherFraction.denominator);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
