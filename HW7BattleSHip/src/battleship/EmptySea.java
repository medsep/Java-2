package battleship;

/**
 * Extends the ships class. By putting a non-null value in empty locations,
 * denoting the absence of a ship, we can save all that null checking.
 * 
 * @author meh
 *
 */
public class EmptySea extends Ship {

	private static final String SHIP_TYPE = "empty";
	private static final int SHIP_LENGTH = 1;

	/**
	 * This zero-argument constructor sets the length variable to 1 by calling the
	 * constructor in the super clas
	 */
	public EmptySea() {
		super(EmptySea.SHIP_LENGTH);
	}

	/**
	 * This method overrides shootAt(int row, int column) that is inherited from
	 * Ship, and always returns false to indicate that nothing was hit
	 */
	@Override
	boolean shootAt(int row, int column) {
		super.shootAt(row, column);
		return false;
	}

	/**
	 * This method overrides isSunk() that is inherited from Ship, and always
	 * returns false to indicate that you didn’t sink anything
	 */
	@Override
	boolean isSunk() {
		return false;
	}

	/**
	 * Returns the single-character “-“ String to use in the Ocean’s print method.
	 * (Note, this is the character to be displayed if a shot has been fired, but
	 * nothing has been hit.)
	 */
	@Override
	public String toString() {
		return "- ";
	}

	/**
	 * Overrides the getShipType that is inherited from ship. This method just
	 * returns the string “empty”
	 */
	@Override
	public String getShipType() {
		return EmptySea.SHIP_TYPE;
	}
}
