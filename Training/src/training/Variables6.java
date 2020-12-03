package training;

public class Variables6 {
	// 3 types of vars
	// static class variable, used in class
	// good for memory management
	static int count = 0;

	public void increment() {
		count++;
	}

	public static void main(String[] args) {
		Variables6 obj1 = new Variables6();
		Variables6 obj2 = new Variables6();
		obj1.increment();
		obj2.increment();

		System.out.println("Obj1: count is " + obj1.count);
		System.out.println("Obj2: count is " + obj2.count);

	}

}
