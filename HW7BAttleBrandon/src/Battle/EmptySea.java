package Battle;

public class EmptySea extends Ship {

	private static final String SHIP_TYPE = "empty";
	private static final int SHIP_LENGTH = 1;

	public EmptySea() {
		super(EmptySea.SHIP_LENGTH);
	}

	@Override
	boolean shootAt(int row, int column) {
		super.shootAt(row, column);
		return false;
		// this.getHit()[0] = true;
		// return false;
	}

	@Override
	boolean isSunk() {
		return false;
	}

	@Override
	public String toString() {
		return "- ";
	}

	/**
	 * Overrides the getShipType that is inherited from ship.
	 */
	@Override
	public String getShipType() {
		return EmptySea.SHIP_TYPE;
	}
}
