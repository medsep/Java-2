package java_basics;

public class MyUtils {
	public static String printSomeJunk(String paramater) {
//		System.out.println("Some bla bla bla " + paramater);
		return paramater;
	}
	
	public static void printSomeJunk(int parameter) {//method signature
		System.out.println("Integer passed in: " + parameter);
	}
	
	public static void sum2Numbers(int firstArg, int secondArg) {
		System.out.println(firstArg + secondArg);
	}
	
	public int add10(int someArgument) {
		int result = someArgument + 10;
		return result;
	}
}
