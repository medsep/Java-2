package SuperKeyword;

public class Dog extends Animal {

	public Dog(int x) {
		System.out.println("Dog constructor!!!");
	}

	public void sound() {

		super.sound();
		System.out.println("Barks!!!");
	}

}
