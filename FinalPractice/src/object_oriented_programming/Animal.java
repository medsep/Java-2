package object_oriented_programming;

public abstract class Animal {
	
	int numberOfLegs;
	int age;
	String gender;
	
	public Animal(int numberOfLegs, int age, String gender) {
		
		this.numberOfLegs = numberOfLegs;
		this.age = age;
		this.gender = gender;
	}
	
	public void walk() {
		System.out.println("Walking...");
	}
	
	public void eat() {
		System.out.println("Eating...");
	}
	
	public void sleep() {
		System.out.println("Sleeping...");
	}
	
	public abstract void move();
	
}
