package battleship;

/**
 * The abstract Ship class has the instance variables below
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

	/**
	 * get ship length
	 * 
	 * @return the ship length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * get the bow row of this ship
	 * 
	 * @return the row corresponding to the position of the bow
	 */
	public int getBowRow() {
		return this.bowRow;

	}

	/**
	 * get the bow column of this ship
	 * 
	 * @return the bow column location
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/**
	 * get hit array
	 * 
	 * @return the hit array
	 */
	public boolean[] getHit() {
		return this.hit;
	}

	/**
	 * check if this ship is horizontal
	 * 
	 * @return whether the ship is horizontal or not
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}

	/**
	 * Sets the value of bowRow
	 * 
	 * @param row the value of bowRow
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * Sets the value of bowColumn
	 * 
	 * @param column the value of bowColumn
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * Sets the value of the instance variable horizontal
	 * 
	 * @param horizontal horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Returns the type of ship as a String. Every specific type of Ship (e.g.
	 * BattleShip, Cruiser, etc.) has to override and implement this method and
	 * return the corresponding ship type.
	 * 
	 * @return the type of ship
	 */
	public abstract String getShipType();

	/**
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
		int shipLength = this.getLength();
		Ship[][] shipArray = ocean.getShipArray();

		if (horizontal) {
			int stern = column - (shipLength - 1);
			if (stern < 0) {
				return false;
			}

			// check all around the ship for adjacent ships
			for (int i = column; i >= stern; i--) {

				// check if there another ship at this location
				if (!this.isEmpty(shipArray[row][i])) {
					return false;
				}

				// if it is the ships's bow
				if (i == column) {
					// adjacent right
					if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
						if (!this.isEmpty(shipArray[row][column + 1])) {
							return false;
						}
					}
					// top
					if ((row - 1) >= 0) {
						// adjacent top-right
						if ((i + 1) <= (Ocean.OCEAN_SIZE - 1)) {
							if (!this.isEmpty(shipArray[row - 1][i + 1])) {
								return false;
							}

						}

						// adjacent top
						if (!this.isEmpty(shipArray[row - 1][i])) {
							return false;
						}
					}
					// bottom
					if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
						// adjacent bottom-right
						if ((i + 1) <= (Ocean.OCEAN_SIZE - 1)) {
							if (!this.isEmpty(shipArray[row + 1][i + 1])) {
								return false;
							}
						}
						// adjacent bottom
						if (!this.isEmpty(shipArray[row + 1][i])) {
							return false;
						}
					}
				}
				// every other location
				if ((i < column) && (i > stern)) {

					// adjacent top
					if ((row - 1) >= 0) {
						if (!this.isEmpty(shipArray[row - 1][i])) {
							return false;
						}
					}
					// adjacent bottom
					if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
						if (!this.isEmpty(shipArray[row + 1][i])) {
							return false;
						}
					}
				}
			}

		} else if (!horizontal) {
			int stern = row - (shipLength - 1);
			if (stern < 0) {
				return false;
			}
			// check all around the ship for other adjacent ships
			for (int i = row; i >= stern; i--) {
				// check is another ship in this location
				if (!this.isEmpty(shipArray[i][column])) {
					return false;
				}
				// if it's the bow
				if (i == row) {
					// adjacent bottom
					if ((i + 1) <= (Ocean.OCEAN_SIZE - 1)) {
						if (!this.isEmpty(shipArray[i + 1][column])) {
							return false;
						}
					}
					// left
					if ((column - 1) >= 0) {
						// adjacent bottom-left
						if ((i + 1) <= (Ocean.OCEAN_SIZE - 1)) {
							if (!this.isEmpty(shipArray[i + 1][column - 1])) {
								return false;
							}
						}
						// adjacent left
						if (!this.isEmpty(shipArray[i][column - 1])) {
							return false;
						}
					}
					// adjacent bottom-right
					if (((i + 1) <= (Ocean.OCEAN_SIZE - 1) && ((column + 1) <= (Ocean.OCEAN_SIZE - 1)))) {
						if (!this.isEmpty(shipArray[i + 1][column + 1])) {
							return false;
						}
					}
					// adjacent right
					if ((column + 1) <= (Ocean.OCEAN_SIZE - 1)) {
						if (!this.isEmpty(shipArray[i][column + 1])) {
							return false;
						}
					}
				}
				// if it is the stern
				if (i == stern) {
					// adjacent left
					if ((i - 1) >= 0) {
						if (!this.isEmpty(shipArray[row][i - 1])) {
							return false;
						}
					}
					// top
					if ((row - 1) >= 0) {
						// adjacent top-left
						if ((i - 1) >= 0) {
							if (!this.isEmpty(shipArray[row - 1][i - 1])) {
								return false;
							}
						}
						// adjacent-top
						if (!this.isEmpty(shipArray[row - 1][i])) {
							return false;
						}
					}
					// bottom
					if ((row + 1) <= (Ocean.OCEAN_SIZE - 1)) {
						// adjacent bottom-left
						if ((i - 1) >= 0) {
							if (!this.isEmpty(shipArray[row + 1][i - 1])) {
								return false;
							}
						}
						// adjacent bottom
						if (!this.isEmpty(shipArray[row + 1][i])) {
							return false;
						}
					}
				}
				// every other location
				if ((i < column) && (i > stern)) {
					// adjacent top
					if ((row - 1) >= 0) {
						if (!this.isEmpty(shipArray[row - 1][i])) {
							return false;
						}
					}
					// adjacent bottom
					if ((row + 1) <= Ocean.OCEAN_SIZE - 1) {
						if (!this.isEmpty(shipArray[row + 1][i])) {
							return false;
						}
					}
				}
			}

		}
		return true;
	}

	/**
	 * Return is ship is in an empty sea
	 */
	private boolean isEmpty(Ship ship) {
		return "empty".equals(ship.getShipType());
	}

	/**
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

	/**
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

	/**
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

	/**
	 * Returns a single-character String to use in the Ocean to print method. This
	 * method should return ""s"" if the ship has been sunk and "x" if it has not
	 * been sunk. This method can be used to print out locations in the ocean that
	 * have been shot at; it should not be used to print locations that have not
	 * been shot at. Since toString behaves exactly the same for all ship types.
	 */
	@Override
	public String toString() {
		boolean sunk = this.isSunk();
		// System.out.println(sunk);
		if (sunk) {
			return "s";
		} else {
			return "x";
		}
	}
}
