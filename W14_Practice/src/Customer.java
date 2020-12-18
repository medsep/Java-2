import java.util.List;
import java.util.regex.Pattern;

public class Customer {
	/***
	 * Lines read from the files
	 */
	List<String> lines;

	/***
	 * customer's id
	 */
	int id;

	/***
	 * name of the customer
	 */
	String name;

	/***
	 * customer's money spent
	 */
	int moneySpent;

	/***
	 * constructor
	 * 
	 * @param lines set the name and money spent by the customer in constructor
	 */
	public Customer(List<String> lines) {
		this.lines = lines;
		this.setName();
		this.moneySpent = 0;
		this.setMoneySpent();
	}

	/***
	 * set up the name of the user
	 */
	private void setName() {
		// TODO
		for (String line : lines) {
			if (line.startsWith("Name: ")) {
				String[] authorArray = line.split(":");
				String name = authorArray[1].trim();
				name = name.toLowerCase();
				if (!name.isEmpty()) {
					this.name = name;
				}
				break;
			}
		}
	}

	/***
	 * set up the money users spent
	 */
	private void setMoneySpent() {
		// TODO
		for (String line : lines) {
			line = line.trim();
			if (line == "") {
				continue;
			}
			if (isNumeric(line)) {
				this.moneySpent += Integer.valueOf(line);
			}
		}
	}

	private boolean isNumeric(String str) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*S");
		return pattern.matcher(str).matches();
	}

	/**
	 * alternative method for boolean
	 */
	// public boolean isNumeric(String str){
	// for (int i= str.length()-1; i>=0; i--){
	// int chr = str.charAt(i);
	// if (chr < 48 || chr >57)
	// return false;
//}
	// return true
	// }

	/***
	 * set up the id of the customer in database
	 * 
	 * @param id
	 */
	void setID(int id) {
		// TODO
		this.id = id;
	}
}
