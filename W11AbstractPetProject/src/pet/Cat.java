package pet;

/**
 * Represents a cat and is a subclass of abstract class Pet.
 * 
 * @author meh
 *
 */

public class Cat extends Pet {

	// static variable

	/**
	 * Default sound for all cats. Only accessible within this class
	 */
	private static String SOUND = "Meow";

	// instance vars

	/**
	 * TYpe of cat Only accesible from within this class
	 */
	private String type;

	// constructor

	/**
	 * Create a cat with following params *
	 * 
	 * @param name
	 * @param age
	 * @param weight
	 * @param type
	 */
	public Cat(String name, int age, double weight, String type) {

		// call constructor in superclass to avoid error
		// sets age, name and weight of cat
		super(age, name, weight);

		// set type of cats
		this.type = type;
	}

	// getters and setters

	// get type of cat
	public String getType() {
		return type;
	}

	// set type of class
	public void setType(String type) {
		this.type = type;
	}

	// inherited abstract methods
	// must override and implement these

	// access modifier

	/**
	 * Cat makes sound
	 */
	@Override
	public void makeSound() {
		System.out.println(Cat.SOUND);
	}

	/**
	 * Returns name and type of cat for printing and debugging
	 */

	@Override
	public String toString() {
		return this.name + " is a " + this.type;

	}

}
