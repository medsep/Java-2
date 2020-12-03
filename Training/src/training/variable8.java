package training;

public class variable8 {
	public String myVar = "instance var";

	public void myMethod() {
		String myVar = "inside method";
		System.out.println(myVar);

	}

	/**
	 * calling a method inside a method
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		variable8 obj1 = new variable8();
		System.out.print("Calling method");
		obj1.myMethod();
		System.out.println(obj1.myVar);
	}

}
