/*
 * represent a customer
 */
public class Customer {
	// instance variable
	String name;

	// constructor
	public Customer(String name) {
		this.name = name;
	}

	/*
	 * returns customer name
	 */
	public String toString() {
		return this.name;// returns name of customer to print
	}

	public static void main(String[] args) {
		Customer c = new Customer("Mehdi");
		System.out.println("c = " + c); // this will try to convert customer c to a string by calling toString method
	}

}
