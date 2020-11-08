/**
 * Represents a square. Implements shape and cube.
 * 
 * @author meh
 *
 */
public class Square implements Shape, Cube {

	// instance vars

	/**
	 * Length of side of square
	 */
	private double sideLength;

	// constructor

	/**
	 * Creates a square based on given side length
	 * 
	 * @param sideLength
	 */

	public Square(double sideLength) {
		this.sideLength = sideLength;
	}

	/**
	 * returns volume of cube made of squares
	 */
	@Override
	public double volume() {
		return Math.pow(this.sideLength, 3);
	}

	/**
	 * Returns area of square
	 */
	@Override
	public double area() {
		return this.sideLength * this.sideLength;
	}

	/**
	 * Returns perimeter of square.
	 */
	@Override
	public double perimeter() {
		return 4 * this.sideLength;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a square with this side length: " + this.sideLength);

	}

}
