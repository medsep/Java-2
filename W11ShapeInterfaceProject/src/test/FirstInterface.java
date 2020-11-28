package test;

interface FirstInterface {
	public void myMethod(); // interface method
}

interface SecondInterface {
	public void myOtherMethod(); // interface method
}

class DemoClass implements FirstInterface, SecondInterface {
	@Override
	public void myMethod() {
		System.out.println("Some text..");
	}

	@Override
	public void myOtherMethod() {
		System.out.println("Some other text...");
	}
}

class MyMainClass1 {
	public static void main(String[] args) {
		DemoClass myObj = new DemoClass();
		myObj.myMethod();
		myObj.myOtherMethod();
	}
}