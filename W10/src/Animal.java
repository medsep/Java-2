public class Animal {
	public void greeting() {
		System.out.println("I am an animal!");
	}

	public static void main(String args[]) {
		Animal animal = new Animal();
		Dog dog = new Dog();
//prints �I am an animal!�
		animal.greeting();
//prints �I am a dog!�
		dog.greeting();
	}
}
