
public class Recursive {

	public static void countdown(int n) {
		if (n == 0) {
			System.out.println("Blastoff!");
		} else {
			System.out.println(n);
			countdown(n - 1);
		}
	}

	public static void displayBinary(int value) {
		if (value > 0) {
			displayBinary(value / 2);
			System.out.print(value % 2);
		}
	}

	public static void nLines(int n) {
		if (n > 0) {
			System.out.println();
			nLines(n - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// nLines(1);
		// countdown(6);
		displayBinary(8);
	}

}
