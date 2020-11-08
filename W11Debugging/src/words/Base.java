package words;

abstract class Base {
	void fun() {
		System.out.println("Base fun() called");
	}
}

class Derived extends Base {
}

class Main {
	public static void main(String args[]) {
		Base b = new Derived();
		b.fun();
	}
}