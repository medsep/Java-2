/**
 * Main class of this game
 */
package battleship;

import java.util.Scanner;

public class BattleshipGame {

	/**
	 * Main method. Helper method, to run the game have been created to keep it
	 * clear and easy to read.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean again = true;

		while (again == true) {
			// a new game
			new BattleshipGame().game(scan);

			// ask whether to play again
			System.out.println("Do you want to play again? \n" + "(y for yes, \n" + "any other char to exit)");
			String answer = scan.next();
			if (answer.toLowerCase().charAt(0) == 'y') {
				again = true;
			} else// if (answer.toLowerCase().charAt(0) == 'n')
			{
				again = false;
			}

		}
		scan.close();
	}

	/**
	 * Main game method. Runs the game and also catches any invalid input from the
	 * user. Includes a helper method to print the ocean with all the ships present,
	 * used for debugging.
	 * 
	 * @param scanner
	 */
	void game(Scanner scanner) {
		// initialize the variables
		int row = 0, column = 0;
		String strrow, strcolumn;

		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();

		// Use this to visually check every ship is placed correctly
		// Will be used to test print method
		ocean.printWithShips();
		ocean.print();

		while (!ocean.isGameOver()) {
			System.out.println("Please input where you want to fire!");
			System.out.println("Enter row, column: ");
			while (true) {
				String rowColPair = scanner.nextLine();
				String[] rowColPairArray = rowColPair.split(",");
				if (rowColPair.matches("[0-9],[0-9]")) {
					strrow = rowColPairArray[0].trim();
					strcolumn = rowColPairArray[1].trim();

					try {
						row = Integer.parseInt(strrow);
						column = Integer.parseInt(strcolumn);
						if (row > 9 || row < 0) {
							System.out.println("please input the row index between 0-9!");
						} else if (column > 9 || column < 0) {
							System.out.println("please input the column index between 0-9!");
						} else if ((!rowColPair.matches("[0-9],[0-9]"))) {
							throw new IllegalArgumentException("Invalid input!!");
						}

						else {
							break;
						}
					} catch (Exception e) {
						System.out.println("Invalid input!");
					}
				}
			}
			ocean.shootAt(row, column);

			System.out.println("You have already fired: " + ocean.getShotsFired() + " times");
			System.out.println("You have hit: " + ocean.getHitCount() + " times");
			System.out.println("You have successfully sunk " + ocean.getShipsSunk() + "/10 ships");
			// print the map
			ocean.print();
			// check whether the game is over
			ocean.isGameOver();
		}
		System.out.println("Your total shots fired was: " + ocean.getShotsFired() + " times");
	}
}
