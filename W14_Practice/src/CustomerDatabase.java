import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDatabase {
	/***
	 * how many customers in the database, initial state = 0;
	 */
	int numberOfCustomer;

	/***
	 * a map from id to customer
	 */
	Map<Integer, Customer> idToCustomerMap;

	/***
	 * a map from customer to id
	 */
	Map<Customer, Integer> CustomerToIDMap;

	/***
	 * constructor
	 */
	public CustomerDatabase() {
		numberOfCustomer = 0;
		idToCustomerMap = new HashMap<>();
		CustomerToIDMap = new HashMap<>();
	}

	/***
	 * add the customer to the database
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		if (customer.name == null) {
			return;
		}
		int id = numberOfCustomer;
		customer.setID(id);
		idToCustomerMap.put(id, customer);
		CustomerToIDMap.put(customer, id);
		numberOfCustomer++;
		return;
	}

	/***
	 * get the size of the database
	 * 
	 * @return
	 */
	public int getSizeOfDatabase() {
		return this.numberOfCustomer;
	}

	/***
	 * get the customer by his id
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomerByID(int id) {
		if (!idToCustomerMap.containsKey(id)) {
			return null;
		}
		return idToCustomerMap.get(id);
	}

	/***
	 * get the id from the customer
	 * 
	 * @param customer
	 * @return
	 */
	public int getIDByCustomer(Customer customer) {
		if (!idToCustomerMap.containsKey(customer)) {
			return -1;
		}
		return CustomerToIDMap.get(customer);
	}

	/***
	 * get the users money spent by his id
	 * 
	 * @param id
	 * @return
	 */
	public int getMoneySpentByID(int id) {
		Customer customer = getCustomerByID(id);
		return customer.moneySpent;
	}

	/***
	 * Reads the file, creates the customer, and puts them into the database. Prints
	 * out the money spent for each user as well as the size of the user database.
	 * Also tries to get user's id from their name or get user's name from their id.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String filename = "cit591.txt";
		List<String> lines = Reader.readFile(filename);
		CustomerDatabase cb = new CustomerDatabase();
		Customer CIT591 = new Customer(lines);
		cb.addCustomer(CIT591);
		System.out.println("CIT591 has spent: " + cb.getMoneySpentByID(0));
		System.out.println("CIT591's id is: " + cb.getIDByCustomer(CIT591));
		System.out.println("database size now is : " + cb.getSizeOfDatabase());
		System.out.println(CIT591.name);

		filename = "brandon.txt";
		lines = Reader.readFile(filename);
		Customer brandon = new Customer(lines);
		cb.addCustomer(brandon);
		System.out.println("Brandon has spent: " + cb.getMoneySpentByID(1));
		System.out.println("Brandon's id is: " + cb.getIDByCustomer(brandon));
		System.out.println("database size now is: " + cb.getSizeOfDatabase());

	}
}
