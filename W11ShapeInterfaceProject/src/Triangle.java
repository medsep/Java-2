/***
 * Abstract Class represents a triangle Implements Shape Abstracts allows us to
 * implemnt methods from Shape interface
 * 
 * @author meh
 *
 */
public abstract class Triangle implements Shape {
	// because this class is abstract we can't create instances of this class i.e.
	// for different types of triangles

	// instance vars

	/**
	 * Sides of triangle accessible in this class and subclasses of triangle.
	 */
	protected double sideA, sideB, sideC;

	// constructor

	/**
	 * Creates triangle with 3 given sides
	 * 
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 */
	public Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	/**
	 * Returns perimeter of triangle.
	 */

	@Override
	public double perimeter() {
		return this.sideA + this.sideB + this.sideC;
	}

	/**
	 * Draws a triangle
	 */
	@Override
	public void draw() {
		System.out.println("Drawing a triangle with sides: " + this.sideA + ", " + this.sideB + ", " + this.sideC);
	}

}
