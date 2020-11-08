/**
 * This class represents a person
 */
package people;

import java.util.ArrayList;

public class Person {

	// insatance vars

	/**
	 * Name of person
	 */
	private String name;

	// getter and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		ArrayList<Person> people = new ArrayList<Person>();

		// create and add person to list
		Person person = new Person();
		people.add(person);

		// give person name
		person.setName("Mehdi");

		String firstName = people.get(0).getName();

		// length of first name
		int firstNameLength = firstName.length();

		System.out.println(firstName + " has a length " + firstNameLength);

	}

}
