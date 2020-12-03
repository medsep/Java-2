package training;

import java.util.Scanner;

public class ifStatements {
	public static void main(String[] args) {

		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please eneter age ");
		age = sc.nextInt();
		if (age > 19) {
			System.out.println("Above 18");

		}

	}
}
