package battleship;

/**
 * The abstract Ship class that is used to place ships in the Ocean. Methods
 * will be inherited by 4 ship classes.
 */
public abstract class Ship {

	/** The row that contains the bow (front part of the ship) */
	private int bowRow;

	/** The column that contains the bow (front part of the ship) */
	private int bowColumn;

	/** The length of the ship */
	private int length;

	/**
	 * A boolean that represents whether the ship is going to be placed horizontally
	 * or vertically
	 */
	private boolean horizontal;

	/**
	 * An array of booleans that indicate whether that part of the ship has been hit
	 * or not
	 */
	private boolean[] hit;

	/**
	 * This constructor sets the length property of the particular ship and
	 * initializes the hit array
	 * 
	 * @param length length of the ship
	 */
	public Ship(int length) {
		this.length = length;
		this.hit = new boolean[4];
		for (int n = 0; n <= 3; n++) {
			hit[n] = false;
		}
	}

	/************************************************************************************
	 * Getter: get ship length
	 * 
	 * @return the ship length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Getter: get the bow row of this ship
	 * 
	 * @return the row corresponding to the position of the bow
	 */
	public int getBowRow() {
		return this.bowRow;

	}

	/**
	 * Getter: get the bow column of this ship
	 * 
	 * @return the bow column location
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/**
	 * Getter: get hit array
	 * 
	 * @return the hit array
	 */
	public boolean[] getHit() {
		return this.hit;
	}

	/**
	 * Getter: check if this ship is horizontal
	 * 
	 * @return whether the ship is horizontal or not
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}

	/************************************************************************
	 * Setter: Sets the value of bowRow
	 * 
	 * @param row the value of bowRow
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * Setter: Sets the value of bowColumn
	 * 
	 * @param column the value of bowColumn
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * Setter: Sets the value of the instance variable horizontal
	 * 
	 * @param horizontal horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/************************************************************************
	 * Returns the type of ship as a String. Every specific type of Ship (e.g.
	 * BattleShip, Cruiser, etc.) has to override and implement this method and
	 * return the corresponding ship type.
	 * 
	 * @return the type of ship
	 */
	public abstract String getShipType();

	/************************************************************************
	 * Based on the given row, column, and orientation, returns true if it is okay
	 * to put a ship of this length with its bow in this location; false otherwise.
	 * The ship must not overlap another ship, or touch another ship (vertically,
	 * horizontally, or diagonally) Does not actually change either the ship or the
	 * Ocean it just says if it is legal to do so.
	 * 
	 * @param row        row of ship
	 * @param column     column of ship
	 * @param horizontal the orintation of ship
	 * @param ocean
	 * @return if it is legal to place ship
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// check the range
		if (row > 9 || row < 0)
			return false;
		else if (column > 9 || column < 0)
			return false;
		if (horizontal == true) {
			if ((column - this.getLength() + 1) < 0)
				return false;
		} else {
			if ((row - this.getLength() + 1) < 0)
				return false;
		}

		// compute the check range(the rectangle)
		int row0 = Math.min(row + 1, 9); // the minimum coordinate is (0,0)
		int column0 = Math.min(column + 1, 9);
		int row1, column1;
		if (horizontal == true) {
			row1 = Math.max(row - 1, 0); // the maximum coordinate is (9,9)
			column1 = Math.max(column - this.getLength(), 0);
		} else {
			row1 = Math.max(row - this.getLength(), 0);
			column1 = Math.max(column - 1, 0);
		}

		// check the occupancy
		for (int i = row0; i >= row1; i--) {
			for (int j = column0; j >= column1; j--) {
				if (ocean.isOccupied(i, j) == true)
					return false;
			}
		}
		return true;
	}

	/************************************************************************
	 * place the ship in ocean This involves giving values to the bowRow, bowColumn,
	 * and horizontal instance variables in the ship, and it also involves putting a
	 * reference to the ship in each of 1 or more locations (up to 4) in the ships
	 * array in the Ocean object. (Note: This will be as many as four identical
	 * references; you can refer to a part of a ship, only to the whole ship.)
	 * horizontal ships face East vertical ships face South
	 * 
	 * @param row        bowRow
	 * @param column     bowColumn
	 * @param horizontal horizontal instance variables
	 * @param ocean      Ocean object
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.setBowColumn(column);
		this.setBowRow(row);
		this.setHorizontal(horizontal);
		if (!horizontal) {
			// Place the ship it is horizontal
			for (int i = row; i >= row - this.length + 1; i--) {
				ocean.getShipArray()[i][column] = this;
			}
		} else {
			// Place the ship if it is vertical
			for (int j = column; j >= column - this.length + 1; j--) {
				ocean.getShipArray()[row][j] = this;
			}
		}
	}

	/************************************************************************
	 * If a part of the ship occupies the given row and column, and the ship hasn't
	 * been sunk, mark that part of the ship as "hit"
	 * 
	 * @param row
	 * @param column
	 * @return true after mark "hit"; otherwise return false
	 */
	/**
	 * 
	 */
	boolean shootAt(int row, int column) {
		if (!this.isSunk()) {
			int shipSpaceCount = 0;
			if (this.isHorizontal()) {
				int stern = this.getBowColumn() - (this.getLength() - 1);
				if (row == this.getBowRow()) {
					for (int i = this.getBowColumn(); i >= stern; i--) {
						if (column == i) {
							shipSpaceCount = this.getBowColumn() - i;
							this.getHit()[shipSpaceCount] = true;
							return true;
						}
					}
				}
			} else if (!this.isHorizontal()) {
				int stern = this.getBowRow() - (this.getLength() - 1);
				if (column == this.getBowColumn()) {
					for (int i = this.getBowRow(); i >= stern; i--) {
						if (row == i) {
							shipSpaceCount = this.getBowRow() - i;
							this.getHit()[shipSpaceCount] = true;
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/************************************************************************
	 * Return true if every part of the ship has been hit, false otherwise.
	 * 
	 * @return if every part of the ship has been hit
	 */
	boolean isSunk() {
		boolean[] hit;
		hit = getHit();
		int hits = 0;
		for (int i = 0; i < 4; i++) {
			if (hit[i] == true) {
				hits += 1;
			}
		}
		if (hits == this.getLength()) {
			// if the number of the hit true is equal to the length of the ship, then return
			// true
			return true;
		} else {
			return false;
		}
	}

	/************************************************************************
	 * Returns a single-character String to use in the Ocean to print method. This
	 * method should return ""s"" if the ship has been sunk and "x" if it has not
	 * been sunk. This method can be used to print out locations in the ocean that
	 * have been shot at; it should not be used to print locations that have not
	 * been shot at. Since toString behaves exactly the same for all ship types.
	 */
	@Override
	public String toString() {
		boolean sunk = this.isSunk();
		if (sunk) {
			return "s";
		} else {
			return "x";
		}
	}
}
