/**
 * Counts at a given start value
 */
package hw7;

/**
 * @author meh
 *
 */

public class Counter1 {
	// inital value
	int count;

	public Counter1(int start) {
		this.count = start;
	}

	/**
	 * create a counter starting at 0
	 * 
	 * @param args
	 */
	public Counter1() {
		this.count = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter1 counter2 = new Counter1(2);
		System.out.println(counter2.count);

		Counter1 counter3 = new Counter1();
		System.out.println(counter3.count);

	}

}
