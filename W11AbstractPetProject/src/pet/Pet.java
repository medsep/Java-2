package pet;

import java.util.ArrayList;

/**
 * Abstract class pet represents a genric ro abstract pet.
 * 
 * @author meh
 *
 */
public abstract class Pet {

	// instance vars

	/**
	 * age of pet Default (package-private) access. Accessible anywhere in the same
	 * package.
	 */
	int age;

	/**
	 * Name of pet Default (package-private) access. Accessible anywhere in the same
	 */
	String name;

	/**
	 * Weight of pet Default (package-private) access. Accessible anywhere in the
	 * same
	 * 
	 */
	double weight;

	/**
	 * Called by subclasses of Pet to create instances of different types of pets.
	 * 
	 * @param age
	 * @param weight
	 * @param name
	 */
	// constructor

	public Pet(int age, String name, double weight) {

		this.age = age;
		this.name = name;
		this.weight = weight;
	}

	// gets and setters

	/**
	 * Gets the weight
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	// non-abstract methods

	/**
	 * Tells pet to eat given food
	 * 
	 * @param food
	 */
	public void eat(Food food) {
		// increment the weight with food
		this.weight += (food.getCalories() / 100);
	}

	// abstract methods.

	/**
	 * forces all pets to make their own sound all subclasses of pet must be
	 * implement this method
	 */
	public abstract void makeSound();

	/**
	 * forces all pets to override toString for printing and debugging
	 */
	@Override
	public abstract String toString();

	public static void main(String[] args) {
		// create lisy of pets
		ArrayList<Pet> pets = new ArrayList<Pet>();

		// create Dog
		Dog dog = new Dog("Buster", 14, 100, "German Shepherd");

		// create Cat
		Cat cat = new Cat("Snuggles", 30, 40, "House Cat");

		// add pets to list
		pets.add(dog);
		pets.add(cat);

		// iterate over list of pets to make a sound
		for (Pet p : pets) {
			// pets makes sound
			// abstract method in pet class
			// every subclass of pet must have this implement
			p.makeSound();
		}

		for (Pet p : pets) {
			// print pet
			// abstract method in pet class
			// every subclass of pet must have this implemented
			System.out.println(p);
		}

		// call specific method in dog class
		String breed = dog.getBreed();
		System.out.println("dog breed: " + breed);

		// call specific method in cat class
		String type = cat.getType();
		System.out.println("dog breed: " + type);

		// get and print dog's current weight
		// calls non-abstract method in pet class
		System.out.println("dog's weight : " + dog.getWeight());

		// create pet food
		Food food = new Food(1000);

		// calls non-abstract method defined in pet class
		dog.eat(food);

		// get the dogs' new weight
		System.out.println("dog's weight : " + dog.getWeight());

	}

}
