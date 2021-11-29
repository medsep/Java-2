package Polymorphism;

/*
 * polymorphism: overlaoding, overriding
 * overloading: static binding/compile time/early binding: same method different signiture
 * overriding:  dynamic binding/runtime/late binding
 */

public class RBI {

	public double getHomeLoanROI() {
		return 8.5;
	}

	public double getCarLoanROI() {
		return 10.5;
	}

	public void getHomeLoanROI(String backName, int amount) {

	}

	public void getHomeLoanROI(int amount, String backName) {

	}

	public RBI getObject() {
		RBI obj = new RBI();
		return obj;
	}

	// wraping into integer class
	// webdriver driver = new firefoxdriver(); ==> polymorphic reference

	public Number show() {

		return 10;
	}

}
