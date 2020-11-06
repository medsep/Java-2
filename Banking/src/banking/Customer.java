package banking;
/**
 * Represents a customer of a bank
 * @author meh
 *
 */
public class Customer {
	//instance vars
	String name;
	
	String address;
	
	//constructor
	/*
	 * Creates a customer with the given name
	 */
	public Customer(String name) {
		//sets instance var name to given name
		this.name =name;
		
	}
	
	//methods
	/*
		 * address for customer
		 */
	public void setAddress (String address) {
		this.address=address;
			}
	/**
	 * return customer name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * return customer address 
	 * @return
	 */
	public String getAddress() {
		return this.address;
	}

}
