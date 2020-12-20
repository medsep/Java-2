package Lesson2;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<>();
		animals.add("Lion");
		animals.add("cat");
		animals.add("Dog");
		animals.add("Bird");

//		for (int i = 0; i < animals.size(); i++) {
//			System.out.println(animals.get(i));
//		}
//		System.out.println("===================");
//		for (String animal : animals) {
//			System.out.println(animal);
//		}

		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle("Honda", "Accord", 12000, false));
		vehicles.add(new Vehicle("Toyota", "Camery", 10000, false));

		for (Vehicle car : vehicles) {
			System.out.println(car.toString());
		}

//		printElements(vehicles);

	}

//	public static void printElements(List someList) {
//		for (int i = 0; i < someList.size(); i++) {
//			System.out.println(someList.get(i));
//		}
//		
//	}
}
