package Battle;

/**
 * Extends Ship and represents a Submarine
 * 
 * @author meh
 *
 */
public class Submarine extends Ship {
	/**
	 * TYpe of ship
	 */
	static final String SHIP_TYPE = "submarine";

	/**
	 * Length of ship
	 */
	static final int SHIP_LENGTH = 1;

	/**
	 * Creates a submarine
	 */
	public Submarine() {
		// Calls the constructor in the superclass with length of this ship
		super(Submarine.SHIP_LENGTH);
	}

	/**
	 * Overides the getShipTYpe method.
	 */
	@Override
	public String getShipType() {
		return Submarine.SHIP_TYPE;
	}
}
