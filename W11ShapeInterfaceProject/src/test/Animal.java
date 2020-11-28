package test;

interface Animal {
	public void animalSound(); // interface method (does not have a body)

	public void sleep(); // interface method (does not have a body)
}

class Pig implements Animal {
	@Override
	public void animalSound() {
		System.out.println("The pig says: wee wee");
	}

	@Override
	public void sleep() {
		System.out.println("Zzz");
	}
}

class MyMainClass {
	public static void main(String[] args) {
		Pig myPig = new Pig();
		myPig.animalSound();
		myPig.sleep();
	}
}
