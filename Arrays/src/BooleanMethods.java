
public class BooleanMethods {

	/**
	 * 
	 * @param x
	 * @return
	 */

	public static boolean isSingleDigit(int x) {
		if (x > -10 && x < 10) {
			return true;
		} else {
			return false;
		}
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int recurse = factorial(n - 1);
		int result = n * recurse;
		return result;
	}

	public static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(isSingleDigit(99));
		System.out.println(fibonacci(55));

	}

}
