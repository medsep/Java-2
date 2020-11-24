package battleship;

import java.util.Scanner;

/**
 * main class of this game
 * 
 * @author Shunshun Liu &amp Liang Chen
 */
public class BattleshipGame {

	/**
	 * Displays the given question and prompts for user input using the given
	 * scanner.
	 * 
	 * @param question to ask
	 * @param scanner  to use for user input
	 * @return true if the user inputs 'y'
	 */
	static boolean getYesOrNoToQuestion(String question, Scanner scanner) {
		boolean response = true;

		String answer;

		System.out.println();
		System.out.print(question + " ");

		while (true) {
			answer = scanner.next();

			if (answer.toLowerCase().charAt(0) == 'y') {
				response = true;
				break;
			} else if (answer.toLowerCase().charAt(0) == 'n') {
				response = false;
				break;
			}
		}

		return response;
	}

	/**
	 * Game main function
	 * 
	 */
	public static void main(String[] args) {

		boolean continumeGame = true;
		Scanner scanner = new Scanner(System.in);
		int row, column;
		String strrow, strcolumn;
		while (continumeGame) {
			Ocean ocean = new Ocean();
			ocean.placeAllShipsRandomly();
			while (!ocean.isGameOver()) {
				ocean.print();

				System.out.println("Please input where you want to fire!");

				while (true) {

					System.out.println("Enter row,column: ");
					String rowColPair = scanner.nextLine();
					String[] rowColPairArray = rowColPair.split(",");

					strrow = rowColPairArray[0].trim();
					strcolumn = rowColPairArray[1].trim();
					// System.out.println("row, column: ");
					// strrow = scanner.next();
					// System.out.println("column: ");
					// strcolumn = scanner.next();

					try {
						row = Integer.parseInt(strrow);
						column = Integer.parseInt(strcolumn);
						if (row > 9 || row < 0) {
							System.out.println("please input the row index between 0-9!");
						} else if (column > 9 || column < 0) {
							System.out.println("please input the column index between 0-9!");
						} else {
							break;
						}
					} catch (Exception e) {
						System.out.println("Invalid input!");
					}

				}

				ocean.shootAt(row, column);

				System.out.println("You have already fired: " + ocean.getShotsFired() + " times");
				System.out.println("You have hitted: " + ocean.getHitCount() + " times");
				System.out.println("You have led " + ocean.getShipsSunk() + " ship(s) sunk.");
				// ocean.print();

			}
			System.out.println("You have already fired: " + ocean.getShotsFired() + " times");
			continumeGame = getYesOrNoToQuestion("Do you want to play this again?", scanner);

		}
		scanner.close();
	}

}
