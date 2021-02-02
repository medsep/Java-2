package train1.com.fx1;

public class HandlingException {

	public static int retInt() {
		int b[] = new int[2];
		int a = 100;
		try {
			// int a = 100 / 0;

			// System.out.println(b[3]);
			a = a / 0;
			return a;

		} catch (ArithmeticException e) {
			System.out.println(e);
			return a;
		} finally {
			// a = 55555;
			System.out.println("Finally executed");
			// return a;
		}
	}

	public static void main(String[] args) {
		System.out.println(retInt());
	}
}
