package pet;

/**
 * Represents a dog annd is subclass of class Pet.
 * 
 * @author meh
 *
 */
public class Dog extends Pet {

	// static vars

	/**
	 * Default sound for all dogs
	 */

	private static String SOUND = "Bark!";

	// instance vars

	/**
	 * Breed of dog Only accessible from within this class
	 */
	private String breed;

	// constructor

	public Dog(String name, int age, double weight, String breed) {
		// must call constructor in superclass pet
		super(age, name, weight);

		// sets breed of dog
		this.breed = breed;

	}

	// getters and setters

	// gets breed of dog
	public String getBreed() {
		return breed;
	}

	// sets breed of dog
	public void setBreed(String breed) {
		this.breed = breed;
	}

	// inherited abstract methods
	// must override and implement these(provide bodies)

	/**
	 * Makes dog sound
	 */

	@Override
	public void makeSound() {
		System.out.println(Dog.SOUND);
	}

	/**
	 * Dog name concatnated with its breed for print and debug
	 */
	@Override
	public String toString() {
		return this.name + " is a " + this.breed;
	}

}
