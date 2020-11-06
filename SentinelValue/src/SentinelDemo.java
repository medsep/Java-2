import java.util.Scanner;

/**
 * takes input from user and returns average until -1 is entered.
 * 
 * @author meh
 *
 */
public class SentinelDemo {

	public static void main(String[] args) {

		double sum = 0;
		int count = 0;
		double salary = 0;
		System.out.println("Enter salaries, -1 to end: ");
		Scanner in = new Scanner(System.in);
		while (salary != -1) {
			salary = in.nextDouble();
			if (salary != -1) {
				sum += salary;
				count++;
			}
		}
		if (count > 0) {
			double average = sum / count;
			System.out.println("Avergae is " + String.format("%.2f", average));
		} else {
			System.out.println("No data");
		}
	}

}
