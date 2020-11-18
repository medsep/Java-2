package battleship;

/**
 * Extends Ship and represents Cruiser.
 * 
 * @author meh
 *
 */
public class Cruiser extends Ship {

	/**
	 * TYpe of ship.
	 */
	static final String SHIP_TYPE = "cruiser";
	/**
	 * Length of ship.
	 */
	static final int SHIP_LENGTH = 3;

	/**
	 * Creates a cruiser of default length
	 */
	public Cruiser() {
		// calls the constructor in the superclass
		super(Cruiser.SHIP_LENGTH);
	}

	/**
	 * Overrides getShipType() that is inherited from Ship.
	 */

	@Override
	public String getShipType() {
		return Cruiser.SHIP_TYPE;
	}

}
