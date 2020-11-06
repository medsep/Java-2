/**
 * Represents a point with x and y.
 * 
 * @author meh
 *
 */
public class Point {

	// instance vars
	int x;
	int y;
	int sum;

	// constructors

	/**
	 * Creates a point of x and y, and then returns the sum.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.sum = x + y;
	}

	/**
	 * Overload constructors
	 * 
	 * @param args
	 */
	public Point() {
		// calls constructor with 0,0
		this(5, 5);
	}

	public static void main(String[] args) {

		Point point1 = new Point(2, 4);
		System.out.println(point1.x);
		System.out.println(point1.y);
		System.out.println(point1.sum);

		Point point2 = new Point();
		System.out.println(point2.x);
		System.out.println(point2.y);
		System.out.println(point2.sum);
	}

}
