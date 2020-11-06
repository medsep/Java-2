import java.util.Scanner;

public class ScoreTester {
	public static void main(String[] args) {
		Scanner mm = new Scanner(System.in);
		double expected = mm.nextDouble();
		Student fred = new Student(100);
		while (mm.hasNextDouble()) {
			if (!fred.addScore(mm.nextDouble())) {
				System.out.println("Too many scores.");
				return;
			}
		}
		System.out.println("Final score: " + fred.finalScore());
		System.out.println("Expected: " + expected);
	}
}