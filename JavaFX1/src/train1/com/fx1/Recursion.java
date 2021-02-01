package train1.com.fx1;

/**
 * A method callng itself
 * 
 * @author mehdi
 *
 */
public class Recursion {

	public static int factorial(int N) {
		if (N <= 1)
			return 1;
		else
			return (N * factorial(N - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(factorial(5));
	}

}
