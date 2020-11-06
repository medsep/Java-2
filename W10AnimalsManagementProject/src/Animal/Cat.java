package Animal;

/**
 * Represent cat and extends animal.
 */

public class Cat extends Animal {

	/**
	 * Default type for cat.
	 */
	static String DEFAULT_TYPE = "domestic";

	// instance variables

	/**
	 * Type of cat.
	 */
	private String type;

	// also inherits cars defined in animal superclass.

	// constructor

	/**
	 * Creates a cat with given age.
	 * 
	 * @param age
	 */
	public Cat(int age) {
		super(age);

		// set type of cat to default value
		this.type = Cat.DEFAULT_TYPE;
	}

	// getter and setters
	/**
	 * gets types of cat
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets type of cat
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	// other methods

	/**
	 * Overrides speak method in superclass Animal.
	 */
	@Override
	public void speak() {
		System.out.println(this.name + "says : Meow");
	}

	/**
	 * Returns the name of this cat for printing.
	 */
	@Override
	public String toString() {
		return this.name + "is a" + this.type;
	}

}
