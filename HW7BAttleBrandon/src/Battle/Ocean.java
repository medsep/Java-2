package Battle;

import java.util.Random;

public class Ocean {

	/**
	 * size of ocean and number of ships in the fleet
	 */
	static final int OCEAN_SIZE = 10;

	/**
	 * used to store different kind of ships in the fleet
	 */
	private Ship[][] ships = new Ship[Ocean.OCEAN_SIZE][Ocean.OCEAN_SIZE];

	/**
	 * Number of ships in each fleet
	 */

	static final int NUM_BATTLESHIPS = 1;
	static final int NUM_CRUISERS = 2;
	static final int NUM_DESTROYERS = 3;
	static final int NUM_SUBMARINES = 4;

	private int shotsFired;

	/**
	 * no of shots fired
	 */
	private int hitCount;

	private int shipsSunk;

	/**
	 * Constructor
	 */
	public Ocean() {
		this.populateEmptyOcean();

		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	/**
	 * randomly places ships
	 */
	private void populateEmptyOcean() {
		for (int i = 0; i < this.ships.length; i++) {
			for (int j = 0; j < this.ships[i].length; j++) {
				Ship ship = new EmptySea();
				ship.placeShipAt(i, j, true, this);
			}
		}
	}

	/**
	 * Returns the number oh ships sunk
	 * 
	 * @return
	 */
	int getShipsSunk() {
		return this.shipsSunk;
	}

	boolean isGameOver() {
		return this.getShipsSunk() >= Ocean.OCEAN_SIZE;
	}

	/**
	 * Returns array of ships.
	 * 
	 * @return
	 */
	Ship[][] getShipArray() {
		return this.ships;
	}

	/**
	 * Return number of shots fired in the game
	 * 
	 * @return
	 */
	int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * Return number of hits
	 * 
	 * @return
	 */
	int getHitCount() {
		return this.hitCount;
	}

	void placeAllShipsRandomly() {

		Random rand = new Random();
		int row;
		int column;
		boolean horizontal;

		// place battleships
		// this represents the ocean class
		for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
			Ship battleship = new Battleship();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while (!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			battleship.placeShipAt(row, column, horizontal, this);
		}

		// place cruisers
		for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
			Ship cruiser = new Cruiser();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while (!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			cruiser.placeShipAt(row, column, horizontal, this);
		}

		// place destroyers
		for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
			Ship destroyer = new Destroyer();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while (!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			destroyer.placeShipAt(row, column, horizontal, this);
		}

		// place submarines
		for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
			Ship submarine = new Submarine();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while (!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			submarine.placeShipAt(row, column, horizontal, this);
		}
	}

	/**
	 * Returns true if location contains a ship
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	boolean isOccupied(int row, int column) {
		Ship[][] shipArray = this.getShipArray();

		return !("empty".equals(shipArray[row][column].getShipType()));
	}

	/**
	 * Returns true if given location contains a real ship.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */

	boolean shootAt(int row, int column) {
		// boolean checkRealShip = this.isOccupied(row, column);
		Ship[][] ships = this.getShipArray();
		boolean checkIsSunk = ships[row][column].isSunk();
		this.shotsFired += 1;
		if (checkIsSunk) {
			return false;
		} else {
			boolean checkShiphit = ships[row][column].shootAt(row, column);

			if (checkShiphit) {
				// If the ship is not sunk, and the part of ship is hit, then hitCount increases
				// by 1, even if the same part of ship is shot at multiple times.
				this.hitCount += 1;
				if (ships[row][column].isSunk()) {
					this.shipsSunk += 1;
					System.out.println("You just sunk a ship - " + ships[row][column].getShipType() + " !");
				}
				return true;
			}
			return false;
		}
	}

	/**
	 * Prints the ocean.
	 */
	void print() {

		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i <= 9; i++) {

			System.out.print(i + " ");
			for (int j = 0; j <= 9; j++) {
				Ship ship = ships[i][j];
				String stringOfStatus = "? ";
				if (ship.getShipType() == "empty") {
					boolean checkHit = ship.getHit()[0];
					if (checkHit) {
						// Return "-" if the spot is fired but nothing is found.
						stringOfStatus = ship.toString();
					} else {
						stringOfStatus = " .";
					}
				} else {
					int bowColumn = ship.getBowColumn();
					int bowRow = ship.getBowRow();
					int position;
					if (ship.isHorizontal()) {
						position = bowColumn - j;
					} else {
						position = bowRow - i;
					}

					if (ship.getHit()[position] == true) {
						// Return "x" or "s" depending on if the ship is sunk.
						stringOfStatus = ship.toString();
					} else {
						stringOfStatus = " .";
					}
				}
				System.out.print(stringOfStatus);
				if (j == 9)
					System.out.print("\n");
			}
		}
	}
}

//void print() {
// top left corner
// System.out.print(" ");

// print columns nums
// for (int i = 0; i < this.ships.length; i++) {
// System.out.print(i + " ");
// }
// System.out.println("");

// print row nums
// Ship ship;
// for (int i = 0; i < this.ships.length; i++) {
// System.out.print(i + " ");
// }
//	System.out.println("");
//}

// 	boolean shootAt(int row, int column) {
// row column out of bounds
// boolean returnVal = false;
// if ((row < 0 || row >= Ocean.OCEAN_SIZE) || (column < 0 || column >=
// Ocean.OCEAN_SIZE)) {
// return returnVal;
// }
// get ship location
// Ship[][] shipArray = this.getShipArray();
// Ship ship = shipArray[row][column];

// if it is still afloat
//		if (!ship.isSunk()) {
// shoot at the ship
// if (ship.shootAt(row, column)) {
// update hit count
// this.hitCount++;

// check again, if it is sunk
// if (ship.isSunk()) {
/// this.shipsSunk++;
// }
// }
// if it is an actual ship
// if (this.isOccupied(row, column)) {
// returnVal = true;
//			}
// }
// increment the total shots fired
// this.shotsFired++;

//		return returnVal;

//	}
