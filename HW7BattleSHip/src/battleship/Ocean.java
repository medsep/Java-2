package battleship;

import java.util.Random;

/**
 * Class of the 10X10 ocean
 */
public class Ocean {

	/**
	 * size of ocean and number of ships in the fleet
	 */
	static final int OCEAN_SIZE = 10;

	/** Used to quickly determine which ship is in any given location */
	private Ship[][] ships = new Ship[OCEAN_SIZE][OCEAN_SIZE];

	/**
	 * "map" is a String array which is used for printing.
	 */
	public String[][] map = new String[10][10];

	/**
	 * Number of ships in each fleet
	 */

	static final int NUM_BATTLESHIPS = 1;
	static final int NUM_CRUISERS = 2;
	static final int NUM_DESTROYERS = 3;
	static final int NUM_SUBMARINES = 4;

	/** The total number of shots fired by the user */
	private int shotsFired;

	/**
	 * The number of times a shot hit a ship. If the user shoots the same part of a
	 * ship more than once, every hit is counted, even though additional hits do the
	 * user any good.
	 */
	private int hitCount;

	/** The number of ships sunk (10 ships in all) */
	private int shipsSunk;

	/**
	 * Creates an ocean initializes any game variables, such as how many shots have
	 * been fired.
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
	 * Place all ten ships randomly on the (initially empty) ocean. Place larger
	 * ships before smaller ones,
	 */
	void placeAllShipsRandomly() {

		int row;
		int column;
		boolean horizontal;
		Random random = new Random();

		// place battleship
		for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
			Ship battleship = new Battleship();
			row = random.nextInt(10);
			column = random.nextInt(10);
			horizontal = random.nextInt(2) == 0 ? false : true;
			while (!battleship.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				horizontal = random.nextInt(2) == 0 ? false : true;
			}
			battleship.placeShipAt(row, column, horizontal, this);
		}

		// place cruiser
		for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
			Ship cruiser = new Cruiser();
			row = random.nextInt(10);
			column = random.nextInt(10);
			horizontal = random.nextInt(2) == 0 ? false : true;
			while (!cruiser.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				horizontal = random.nextInt(2) == 0 ? false : true;
			}
			cruiser.placeShipAt(row, column, horizontal, this);
		}

		// place destroyer
		for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
			Ship destroyer = new Destroyer();
			row = random.nextInt(10);
			column = random.nextInt(10);
			horizontal = random.nextInt(2) == 0 ? false : true;
			while (!destroyer.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				horizontal = random.nextInt(2) == 0 ? false : true;
			}
			destroyer.placeShipAt(row, column, horizontal, this);
		}

		// place submarine
		for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
			Ship submarine = new Submarine();
			row = random.nextInt(10);
			column = random.nextInt(10);
			horizontal = random.nextInt(2) == 0 ? false : true;
			while (!submarine.okToPlaceShipAt(row, column, horizontal, this)) {
				row = random.nextInt(10);
				column = random.nextInt(10);
				horizontal = random.nextInt(2) == 0 ? false : true;
			}
			submarine.placeShipAt(row, column, horizontal, this);
		}
	}

	/**
	 * Returns true if the given location contains a real ship, still afloat,false
	 * if it does not. In addition, this method updates the number of shots that
	 * have been fired, and the number of hits.
	 * 
	 * @param row
	 * @param column
	 * @return True if there is a ship
	 */
	boolean isOccupied(int row, int column) {

		Ship ship = this.getShipArray()[row][column];
		String shipType = ship.getShipType();
		if (shipType != "empty") {
			// Return true if there is a real ship
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get shots you have fired.
	 * 
	 * @return the number of shots fired (in the game)
	 */
	int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * Get hits you already hit.
	 * 
	 * @return the number of hits recorded (in the game). All hits are counted, not
	 *         just the first time a given square is hit.
	 */
	int getHitCount() {
		return this.hitCount;
	}

	/**
	 * Returns true if the given location contains a real ship, still afloat, (not
	 * an EmptySea), false if it does not. In addition, this method updates the
	 * number of shots that have been fired, and the number of hits.
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
	 * Get if the ship is sunk.
	 * 
	 * @return the number of ships sunk (in the game)
	 */
	int getShipsSunk() {
		return this.shipsSunk;
	}

	/**
	 * Check if the game is over.
	 * 
	 * @return true if all ships have been sunk, otherwise false
	 */
	boolean isGameOver() {
		return this.getShipsSunk() >= Ocean.OCEAN_SIZE;
	}

	/**
	 * Get ships array from ocean.
	 * 
	 * @return the 10x10 array of Ships
	 */
	Ship[][] getShipArray() {

		return this.ships;
	}

	/**
	 * Prints the Ocean. The top left corner square should be 0, 0. Use "x" to
	 * indicate a location that you have fired upon and hit a (real) ship. Use "-"
	 * to indicate a location that you have fired upon and found nothing there. Use
	 * "s" to indicate a location containing a sunken ship. and use "." (a period)
	 * to indicate a location that you have never fired upon.
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
						stringOfStatus = ". ";
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
						stringOfStatus = ship.toString() + " ";
					} else {
						stringOfStatus = ". ";
					}
				}
				System.out.print(stringOfStatus);
				if (j == 9)
					System.out.print("\n");
			}
		}
	}
}
