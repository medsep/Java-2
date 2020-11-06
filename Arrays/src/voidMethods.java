
public class voidMethods {

	public static void threeLine() {
		newLine();
		newLine();
		newLine();
	}

	private static void newLine() {
		System.out.println();

	}

	public static void main(String[] args) {
		System.out.println("First line.");
		// threeLine();
		// newLine();
		System.out.println("Second line.");
	}
}
