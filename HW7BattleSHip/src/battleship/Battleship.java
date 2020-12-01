package battleship;

/**
 * Extends Ship representing a Battleship.
 * 
 * @author meh
 *
 */
public class Battleship extends Ship {
	/**
	 * Type of ship
	 */
	static final String SHIP_TYPE = "battleship";
	/**
	 * Length of ship
	 */
	static final int SHIP_LENGTH = 4;

	/**
	 * Creates the Battle ship with default length
	 */
	public Battleship() {
		// calls the constructor in the ship class
		super(Battleship.SHIP_LENGTH);
	}

	/**
	 * Overrides getShipTYpe() that is inherited from Ship.
	 * 
	 */
	@Override
	public String getShipType() {
		return Battleship.SHIP_TYPE;
	}
}
