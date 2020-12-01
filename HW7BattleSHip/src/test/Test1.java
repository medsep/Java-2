package test;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean again = true;

		while (again == true) {
			// a new game
			// new BattleshipGame().game(scan);
			// ask whether to play again
			// ask whether to play again

			try {// ask whether to play again
				System.out.println("Do you want to play again? y/n");
				String answer = scan.next();
				if (answer.toLowerCase().charAt(0) == 'y') {
					again = true;
				} else if (answer.toLowerCase().charAt(0) == 'n') {
					again = false;
				}
			} catch (Exception e) {
				System.out.println("Invalid entry!!");
			}
		}
		scan.close();
	}
}
//(!answer.startsWith("Y") || !answer.startsWith("N") || !answer.startsWith("y")
//|| !answer.startsWith("n"))