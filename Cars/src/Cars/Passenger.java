package Cars;

public class Passenger {
	/**
	 * Person representing passenger.
	 * 
	 * @author meh
	 *
	 */
	Person person;

	/*
	 * indicates if it is sick
	 */
	boolean carSick = false;

	/**
	 * Create passenger with name, age, license plate
	 */
	public Passenger(String name, int age) {
		this.person = new Person(name, age);
	}

	/**
	 * Set sick status of car
	 */
	void setCarSick(boolean carSick) {
		this.carSick = carSick;
		if (carSick) {
			System.out.println(this.getName() + " not feeling well ....");
		} else {
			System.out.println(this.getName() + " feeling well");
		}
	}

	/**
	 * Return name of passenger
	 * 
	 * @return
	 */
	String getName() {
		return this.person.name;
	}

	int getAge() {
		return this.person.age;
	}

}
