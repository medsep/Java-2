package Polymorphism;

public class OverloadingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OverloadingExample obj = new OverloadingExample();
		obj.add(4.2d, 5);
		// obj.doLogin("ffff", "abcdef");
		obj.add(10, 20.3d);
		// byte b1 = 10;
		// byte b2 = 20;
		// obj.add(b1, b2);
		obj.addition(10, 20, 50, 80, 99, 66);
		;

	}

	public static void main(int[] args[]) {

	}

	public void add(int a, double b) {

	}
	/*
	 * public void add(int a, int b, int c) {
	 * 
	 * }
	 * 
	 * public void doLogin(String username, String password) {
	 * 
	 * }
	 * 
	 * public void doLogin(int mobileNUmber, String password) {
	 * 
	 * }
	 * 
	 * public void add(double var, int a) {
	 * 
	 * }
	 * 
	 * public void add(byte a, byte b) {
	 * 
	 * }
	 */

	public void add(double a, int b) {

	}

	// varargs
	public void addition(int... a) {

		int[] var = a;

	}

}
