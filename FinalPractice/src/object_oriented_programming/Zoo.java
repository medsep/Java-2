package object_oriented_programming;

public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird bird = new Bird(2, 3, "male");
		
		Flyable flyingBird = new Bird(2, 3, "female");
		flyingBird.fly();
		
		System.out.println("");
		
		bird.walk();
		
		bird.fly();//method implemented because of interface
		bird.move();//method implemented because of abstract class
		
		
	}
	
	public static void moveAnimal(Animal animal) {//polymorphism
		animal.move();
	}

}
