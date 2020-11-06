
public class ForLoop {

	public static void printTable(int rows) {
		for (int i = 1; i <= rows; i = i + 1) {
			printRow(i, i);
		}
	}

	public static void printRow(int n, int cols) {
		int i;
		for (i = 1; i <= cols; i = i + 1) {
			System.out.printf("%4d", n * i);
		}
		System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printTable(8);
		printRow(6, 6);
	}

}
