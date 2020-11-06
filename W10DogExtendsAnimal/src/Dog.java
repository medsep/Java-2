/**
 * Dog extends animal
 * 
 * @author meh
 *
 */
public class Dog extends Animal {

	@Override
	public void greeting() {
		super.greeting(); // call greeting method in super class animal (order matters)
		System.out.println("I am a dog.");
	}

}
