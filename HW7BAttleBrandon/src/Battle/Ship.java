package Battle;

public abstract class Ship {
	/**
	 * ships bow
	 */
	private int bowRow;

	/**
	 * ships bow
	 */
	private int bowColumn;

	/**
	 * Ship length
	 */
	private int length;

	/**
	 * boolean represents placing ship horizontal or vertical
	 */
	private boolean horizontal;

	/**
	 * this boolean array to assess ship or part of it has been hit
	 */
	private boolean[] hit;

	/**
	 * Constructor sets ships length initiliazes array to see if the ship has been
	 * hit
	 * 
	 * @param lenght
	 */
	public Ship(int length) {
		// set length of the ship
		this.length = length;

		// set the hit tracker
		this.hit = new boolean[4];
	}

	/**
	 * row repenting the front of the ship
	 * 
	 * @return
	 */

	public int getBowRow() {
		return this.bowRow;
	}

	/**
	 * column repenting the front of the ship
	 * 
	 * @return
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/**
	 * Return the boolean array for hit
	 * 
	 * @return
	 */
	// public int getHit() {
	// return this.getHit();
	// }

	/**
	 * Returns the ships' hit array.
	 * 
	 * @return
	 */
	public boolean[] getHit() {
		return this.hit;
	}

	/**
	 * Length of the ship
	 * 
	 * @return length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Ship is horizontal or not
	 * 
	 * @return true if horizontal, no otherwise.
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}

	/**
	 * set the row of the bow
	 * 
	 * @param row
	 */

	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * sets the column of the bow
	 * 
	 * @param column
	 */

	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * set value of horizontal instance
	 * 
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * This is a string representing the ship type. All ships will implement this
	 * method.
	 * 
	 * @return String representing the ship
	 */
	public abstract String getShipType();

	/**
	 * PLace ship
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
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
	 * Puts ships in ocean.
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);

		// calculate to place ship
		int shipLength = this.getLength();
		if (this.isHorizontal()) {
			int stern = column - (shipLength - 1);
			for (int i = column; i >= stern; i--) {
				ocean.getShipArray()[row][i] = this;
			}
		} else if (!this.isHorizontal()) {
			int stern = row - (shipLength - 1);
			for (int i = row; i >= stern; i--) {
				ocean.getShipArray()[i][column] = this;
			}
		}
	}

	/**
	 * determines if ship has been hit in the given location.
	 */
	boolean getLocationHit(int row, int column) {
		int shipSpaceCount = 0;
		if (this.isHorizontal()) {
			shipSpaceCount = this.getBowColumn() - column;
			return this.getHit()[shipSpaceCount];
		} else if (!this.isHorizontal()) {
			shipSpaceCount = this.getBowRow() - row;
			return this.getHit()[shipSpaceCount];
		}
		return false;
	}

	/**
	 * Return true for every part of shit hit.
	 */
	boolean isSunk() {
		for (int i = 0; i <= this.getLength() - 1; i++) {
			if (!this.getHit()[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Overides the toString method
	 */
	@Override
	public String toString() {
		String shipCharacter = " ";
		if (this.isSunk()) {
			shipCharacter = "s ";
		} else {
			shipCharacter = "x ";
		}
		return shipCharacter;
	}

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

	@Override
	public boolean equals(Object o) {
		// before casting, confirm o is an instance of ship
		if (!(o instanceof Ship)) {
			return false;
		}

		// cast to Ship
		Ship otherShip = (Ship) o;

		// Compare this to the ship passed in
		return this.hashCode() == otherShip.hashCode();
	}

}
