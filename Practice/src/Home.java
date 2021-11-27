
public class Home {

	static int i = 20;

	public void go() {
		i = 456;
		int j = 356;
	}

	public void show() {
		i = 366;
		int j = 356;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int division(int a, int b) {
		return a / b;
	}

	public int adition(int a, int b) {
		return a + b;
	}

	public int substract(int a, int b) {
		if (a > b) {
			return a - b;
		}
		return b - a;
	}

}
