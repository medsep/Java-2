package Animal;

import java.util.ArrayList;

/**
 * Class fro managing animals
 * 
 * @author meh
 *
 */
public class AnimalsManager {

	// instance vars

	/**
	 * List of all animals
	 */
	ArrayList<Animal> animals;

	// constructor

	/**
	 * Creates AnimalsManger and initializes list of all animals.
	 */
	public AnimalsManager() {
		// initializes animals ArrayList
		this.animals = new ArrayList<Animal>();

	}

	// methods

	/**
	 * print list if animals
	 */
	public void printAnimals() {
		// iterate over and print
		// enhanced for loop
		for (Animal a : this.animals) {
			// this will call toString method in the respective animal class
			// toString in Animal class or overridden toString in subclass of animal
			System.out.println(a);
		}
	}

	/**
	 * Tells all animal to speak
	 */
	public void animalsSpeak() {
		for (Animal a : this.animals) {
			// this will call toString method in the respective animal class
			// toString in Animal class or overridden toString in subclass of animal
			a.speak();
		}
	}

	public static void main(String[] args) {
		// create generic animal
		Animal animal = new Animal(2);

		// calls setName defined in animal class
		animal.setName("Bob the animal");

		// print the animal
		// this calls toString defined in Animal class
		System.out.println(animal);

		// create a dog
		Dog dog1 = new Dog(4, "Pug");

		// calls setName defined in animal class
		dog1.setName("Puggles");

		// create another dog
		Dog dog2 = new Dog(9, "Pug");

		// calls setName defined in Animal class
		dog2.setName("Puggles");

		// creates a cat
		Cat cat1 = new Cat(8);
		cat1.setName("Teddy ");
		cat1.setType(" outside");

		// calls toString defined in Cat class
		System.out.println(cat1);

		AnimalsManager animalsManager = new AnimalsManager();

		// add each animal to arraylist animals
		animalsManager.animals.add(animal);
		animalsManager.animals.add(dog1);
		animalsManager.animals.add(dog2);
		animalsManager.animals.add(cat1);

		// print all animals
		System.out.println("");
		animalsManager.printAnimals(); // calls toString in each class

		animalsManager.animalsSpeak(); // calls speak in each class

		// compare dog1 to dog2
		System.out.println("");
		// calls eqauls method defined in dog class
		System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));

		// change breed of dog2
		dog2.setBreed("Golden retriver");
		System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));

	}

}
