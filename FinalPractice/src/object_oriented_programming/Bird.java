package object_oriented_programming;

//a class can only extend one class, it can only has one parent. Any class cannot have multiple parents but it can have as many interface as it wants

public class Bird extends Animal implements Flyable{

	public Bird(int numberOfLegs, int age, String gender) {
		super(numberOfLegs, age, gender);
		
	}

	
	public void fly() {
		System.out.println("Birds can fly!");
		
	}

	public void move() {
		System.out.println("Birds move when flying and walking.");
		
	}
	
	
	
}
