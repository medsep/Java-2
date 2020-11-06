
public class Loops {

	public static void sequence(int n) {
		while (n != 1) {
			System.out.println(n);
			if (n % 2 == 0) { // n is even
				n = n / 2;
			} else { // n is odd
				n = n * 3 + 1;
			}
		}
	}

	public static void logarithm(int i) {
		// int i = 1;
		while (i < 10) {
			double x = i;
			System.out.println(x + " " + Math.log(x) / Math.log(2));
			i = i + 1;
		}
	}

	public static void countdown(int n) {
		while (n > 0) {
			System.out.println(n);
			n = n - 1;
		}
		System.out.println("Blastoff!");
	}

	final double LOG2 = Math.log(2);
	int i = 1;
	{
		while (i < 100) {
			double x = i;
			System.out.println(x + " " + Math.log(x) / LOG2);
			i = i * 2;
		}
	}

	int i1 = 1;
	{
		while (i <= 6) {
			System.out.printf("%4d", 2 * i);
			i = i + 1;
		}
		System.out.println();

	}

	public static void printRow(int n) {
		int i = 1;
		while (i <= 6) {
			System.out.printf("%4d", n * i);
			i = i + 1;
		}
		System.out.println();
	}

	public static void printTable() {
		int i = 1;
		while (i <= 66) {
			printRow(i);
			i = i + 1;
		}
	}

	public static void printTable(int rows) {
		int i = 1;
		while (i <= rows) {
			printRow(i, i);
			i = i + 1;
		}
	}

	public static void printRow(int n, int cols) {
		int i = 1;
		while (i <= cols) {
			System.out.printf("%4d", n * i);
			i = i + 1;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// logarithm(1);
		// printTable(8);
		printTable(6);

	}
}
