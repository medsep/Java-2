package battleship;

import java.util.Scanner;

/**
 * Main class for a human.
 * 
 * @author meh
 *
 */
public class BattleshipGame {

	public static void main(String[] args) {
		Ocean ocean = new Ocean;
		ocean.placeAllShipsRandomly();
		
		//for debugging
		Scanner scanner = new Scanner(System.in);
		
		while (!ocean.isGameOver()) {
			
			ocean.print();
			//System.out.println("Hit count: " + ocean.getHitCount());
			
			System.out.println("Enter row, column: ");
			String rowColPair = scanner.nextLine();
			String[] rowColPairArray = rowColPair.split(", ");
			
			String rowStr = rowColPairArray[0].trim();
			String colStr = rowColPairArray[1].trim();
			
			try {
				int row = Integer.parseInt(rowStr);
				int column = Integer.parseInt(colStr);
				
				boolean shootSuccess = ocean.shootAt(row, column);
				
				if (shootSuccess) {
					System.out.println("hit");
					
					Ship[][] shipArray = ocean.getShipArray();
					Ship ship = shipArray[row][column];
					
					if (ship.isSunk()) {
						System.out.println("You just sunk a ship..(" + ship.getShipType() + ")");
					}
				}else {
					System.out.println("miss");
				}
				}catch (NumberFormatException e) {
					//e.printStackTrace();
					}

		}
		
		System.out.println("The game is over!");
		System.out.println(ocean.getShotsFired() + " shots were required.");
		
		scanner.close();
	}

}
