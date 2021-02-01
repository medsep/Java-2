package train1.com.fx1;

public class lesson1 {

	public static void main(String[] args) {
		int score = 100;

		switch (score) {

		case 90:
			System.out.println("Very good");
			break;
		case 100:
		case 60:
			System.out.println("Good");
			break;

		case 40:
			System.out.println("Pass");
			break;

		default:
			System.out.println("Grades are not defined");
			break;
		}
	}
}
