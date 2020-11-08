package pet;

/**
 * This represents generic food for a pet
 * 
 * @author meh
 *
 */
public class Food {

	// instance vars

	/**
	 * Calories for food
	 */
	private int calories;

	// constructor

	/**
	 * Creates instance of food with given calories amount
	 * 
	 * @param calories
	 */
	public Food(int calories) {
		this.calories = calories;
	}

	// getters and setters

	/**
	 * Gets calories
	 * 
	 * @return
	 */

	public int getCalories() {
		return calories;
	}

	/**
	 * Sets the calories
	 * 
	 * @param calories
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}

}
