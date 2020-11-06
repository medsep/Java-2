/**
 * Represents a counter with methods for manipulating count.
 */

package Week9;

public class Counter {
	// instane var

	/**
	 * Internal count for counter
	 */
	int count;

	// constructor

	/**
	 * Creates counter with given initial count.
	 * 
	 * @param initialCount
	 */
	public Counter(int initialCount) {
		this.setCount(initialCount); // call setCount with given initial count
	}

	// methods

	/**
	 * Increments internal count by 1
	 */
	public void increment() {
		this.count++;
	}

	/**
	 * Return internal count
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Set count to internal count
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
