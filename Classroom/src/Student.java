/*
 * Represents a student in class
 * each student has name and id
 */
public class Student {
	// instance variable
	String name;
	// Student id
	String ID;

	// constructor
	/*
	 * Creates a student with given name and ID
	 */
	public Student(String name, String ID) {
		this.name = name;
		this.ID = ID;
	}

	public String toString() {
		return this.name;
	}

}
