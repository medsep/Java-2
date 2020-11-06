package Animal;

/**
 * Represents a dog and extends the Animal class
 * 
 * @author meh
 *
 */
public class Dog extends Animal {

	// instance vars

	/**
	 * Breed of the dog as well as those of Animal
	 */
	private String breed;

	// constructor

	/**
	 * Creates a dof with the given age and greed.
	 * 
	 * @param age
	 * @param breed
	 */
	public Dog(int age, String breed) {
		// calls constructor in superclass Animal
		super(age);

		// sets breed of dog
		this.breed = breed;
	}

	// getters/setters

	/**
	 * Gets the breed of dog
	 * 
	 * @return
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * sets the breed of dog
	 * 
	 * @param breed
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	// Other methods

	/**
	 * Override the speak method in superclass Animal.
	 */
	@Override
	public void speak() {
		System.out.println(this.name + " says: Fear my bark!");
	}

	/**
	 * returns name and breed of dog for printing.
	 */
	@Override
	public String toString() {
		return this.name + " is a " + this.breed;
	}

	public boolean equals(Object obj) {

		// cast other object to dog
		Dog otherDog = (Dog) obj;

		// compares 2 dogs based on their name and breed
		return (this.name.equals(otherDog.name) && this.breed.equals(otherDog.breed));
	}

}
