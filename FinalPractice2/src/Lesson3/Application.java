package Lesson3;

import java.util.HashSet;
//import java.util.HashSet;
import java.util.LinkedHashSet;

public class Application {

	public static void main(String[] args) {
		LinkedHashSet<Integer> values = new LinkedHashSet<>(); // LinkedHashSet with preserver the order of data
																// inserted while the HashSet wont.

		values.add(12);
		values.add(43);
		values.add(15);
		values.add(67);
		values.add(43);
		values.add(33);

		for (Integer value : values) {
			System.out.println(value);
		}

		System.out.println("---------------------------");

		HashSet<Animal> animals = new HashSet<>();

		Animal animal1 = new Animal("Dog", 12);
		Animal animal2 = new Animal("Cat", 8);
		Animal animal3 = new Animal("Bird", 3);
		Animal animal4 = new Animal("Dog", 12);
		Animal animal5 = new Animal("Kangaroo", 24);

		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);

		System.out.println(animal1.hashCode());
		System.out.println(animal4.hashCode());

		for (Animal animal : animals) {
			System.out.println(animal);
		}

	}

}
