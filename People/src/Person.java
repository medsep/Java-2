/*
 * this class will represent a person
 */
public class Person {
	//
	/*
	 * name
	 */
	String name;

	int age;

	/*
	 * name and age of person
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/*
	 * compares instances of person based on name.
	 */
	public boolean equals(Object something) {
		// cast given object to person
		Person otherPerson = (Person) something;
		// returns true if names of 2 ppl r the same
		return this.name.equals(otherPerson.name);
	}

}
