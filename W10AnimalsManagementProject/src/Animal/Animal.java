/**
 * Represent a general animal.
 * we will create subclasses that will inherit from this.
 */

package Animal;

public class Animal {

	// static vars

	/**
	 * Default age.
	 */
	static int DEFAULT_AGE = 0;

	/**
	 * age
	 */
	int age;

	/**
	 * Weight of the animal
	 */
	double weight;

	/**
	 * Name of the animal
	 */
	String name;

	// Constructors
	public Animal(int age) {
		this.age = age;
	}

	public Animal() {
		// calls first constructor with default age
		this(Animal.DEFAULT_AGE);
	}

	// getters/setters to set them for instance variables

	/**
	 * Gets the name of the animal
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the animal.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// other methods

	/**
	 * Animal speaks
	 */
	public void speak() {
		System.out.println("Animal says hi.");
	}

	/**
	 * Overrides toString in Object class. Returns the na,e of the animal for
	 * printing.
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
