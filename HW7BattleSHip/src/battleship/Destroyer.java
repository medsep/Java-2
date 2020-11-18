package battleship;

/**
 * Extends Ship and represents a Destroyer.
 * 
 * @author meh
 *
 */
public class Destroyer extends Ship {
	/**
	 * TYpe of ship
	 */
	static final String SHIP_TYPE = "destroyer";

	/**
	 * The length of ship
	 */
	static final int SHIP_LENGTH = 2;

	/**
	 * Creates the destroyer
	 */
	public Destroyer() {
		// call constructor in superclass with length of this ship
		super(Destroyer.SHIP_LENGTH);
	}

	/**
	 * Overrides getShipType() that is inherited from ship. Returns a string
	 * representing Destroyer.
	 */
	@Override
	public String getShipType() {
		return Destroyer.SHIP_TYPE;
	}

}
