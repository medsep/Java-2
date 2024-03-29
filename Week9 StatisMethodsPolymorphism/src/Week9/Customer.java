/**
 * represent customer with name id geography
 */

package Week9;

import java.util.ArrayList;

public class Customer {
	// Static varaible shared across all instances of customer

	// copmany for all the customer
	static final String COMPANY = "CVS";

	// Array list to store all customers
	static ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();

	// To generate count of customers
	// all static variable in UpperCase
	static Counter COUNTER;

	// instance variables

	/**
	 * Name of customer
	 * 
	 * @param args
	 */
	String name;

	/**
	 * Geography
	 * 
	 * @param args
	 */
	String geography;

	/**
	 * ID of customer
	 * 
	 * @param args
	 */
	int ID;

	// constructor
	public Customer(String name, String geography) {
		this.name = name;
		this.geography = geography;

		this.ID = Customer.COUNTER.getCount();

		// increment the count
		Customer.COUNTER.increment();

		// adds this customer to list of all customers
		Customer.CUSTOMERS.add(this);
	}

	// methods
	// need static method to access static vataible
	public static void printAllCustomers() {
		System.out.println("All customers: ");

		// iterate over statically refered list of customers
		for (Customer c : Customer.CUSTOMERS) {
			System.out.println(c);
		}
		System.out.println("\n");
	}

	/*
	 * Equals method to check for equality
	 */

	public boolean equals(Object obj) {
		Customer otherCustomer = (Customer) obj;
		// if ((this.name.equals(otherCustomer.name) &&
		// (this.geography.equals(otherCustomer.geography))))
		if ((this.name.equals(otherCustomer.name) && (this.geography.equals(otherCustomer.geography)))) {
			return true;
		}
		return false;
	}

	/**
	 * String method how to cast an instance of customer class to string
	 * 
	 * @param args
	 */
	public String toString() {
		// return this.ID + ":" + this.name + ", Company: " + Customer.COMPANY + " ,
		// Location: " + this.geography;
		return this.ID + ": " + this.name + ", Company: " + Customer.COMPANY + ", Location: " + this.geography;
	}

	/**
	 * To locate a customer in a list of customers
	 * 
	 * @param args
	 */

	public static int findCustomer(Customer customer) {
		int index = -1;

		// iterate over customer list and locate give customer
		for (int i = 0; i < Customer.CUSTOMERS.size(); i++) {
			if (Customer.CUSTOMERS.get(i).equals(customer)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * Remove a customer from a list
	 * 
	 * @param args
	 */

	public static void removeCustomer(Customer customer) {
		int removeIndex = Customer.findCustomer(customer);

		if (removeIndex >= 0) {
			Customer.CUSTOMERS.remove(removeIndex);
		}
	}

	public static void main(String[] args) {

		// counter class initialization
		Customer.COUNTER = new Counter(1);

		// create customer
		Customer c1 = new Customer("chenyun", "Los Angeles");

		// print all customers
		Customer.printAllCustomers();

		// create customer
		Customer c2 = new Customer("huize", "NYC");

		// print all customers
		Customer.printAllCustomers();

		Customer c3 = new Customer("andy", "Cananda");
		// print all customers
		Customer.printAllCustomers();

		//
		Customer.removeCustomer(c1);
		// print all customers
		Customer.printAllCustomers();

	}

}
