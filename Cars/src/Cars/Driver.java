package Cars;

public class Driver {

	Person person;

	boolean hasLicense;

	boolean driveAutomatically = false;

	/**
	 * Create driver. The constructor.
	 */
	public Driver(String name, int age, boolean hasLicense, boolean driveAutomatically) {
		this.person = new Person(name, age);
		this.driveAutomatically = driveAutomatically;
	}

	/**
	 * Returns name of the driver
	 * 
	 * @return
	 */

	String getName() {
		return this.person.name;
	}

	/**
	 * Returns age
	 */

	int getAge() {
		return this.person.age;
	}

}
