
public class BreakAndCount {

	public static void go() {
		System.out.println("First");
		// break;
		System.out.println("Last");
	}

	public static void main(String[] args) {

		go();

		for (int i = 0; i < 10; i++) {
			// if (i == 5)
			// break;

			if (i >= 5)
				continue;
			System.out.println(i);
		}
		System.out.println("Loop is over!");
	}
}
