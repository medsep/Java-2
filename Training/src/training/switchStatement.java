package training;

import java.util.Scanner;

public class switchStatement {

	public static void main(String[] args) {

		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter age");
		age = sc.nextInt();
		switch (age) {
		case 18:
			System.out.println("Age 18");
			break;
		case 19:
			System.out.println("Age 19");
			break;
		case 20:
			System.out.println("Age 20");
			break;
		case 21:
			System.out.println("Age 21");
			break;
		case 22:
			System.out.println("Age 22");
			break;
		default:
			System.out.println("Not met");
			break;
		}

	}

}
