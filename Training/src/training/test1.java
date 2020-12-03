package training;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = 0;
		int sum = 0;
		while (true) {
			System.out.println("Give a number:");
			int input = Integer.valueOf(scanner.nextLine());

			if (input != 0) {
				count += 1;
				sum += input;
				continue;
			} else if (input == 0) {
				break;
			}
		}
		double average = 1.0 * sum / count;
		System.out.println("Average of the numbers: " + average);

	}

}
