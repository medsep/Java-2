package Polymorphism;

public class CITI extends RBI {

	public static void main(String[] args) {
		CITI obj = new CITI();
		System.out.println(obj.getHomeLoanROI());

		// parent class refering to child class
		RBI obj2 = new HSBC();
	}

	public double getHomeLoanROI() {
		return 10.5;
	}

	public Integer show() {

		return 10;
	}

}
