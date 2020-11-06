/*
 * Represents a counter with methods
 */
public class Counter {
	// instance variables
	int count;

	// methods
	/*
	 * increments counts and returns value of new count
	 */
	public int increment() {
		this.count++;

		return this.count;
	}

	/*
	 * Decrement internal count. returns value of new count.
	 */
	public int decrement() {
		this.count--;
		return this.count;
	}

	/*
	 * Return current value of count. Return the count.
	 */

	public int getCount() {
		return this.count;
	}

}
