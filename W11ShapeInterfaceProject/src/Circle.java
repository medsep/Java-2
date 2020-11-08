/**
 * represents circle implements shape
 * 
 * @author meh
 *
 */
public class Circle implements Shape {

	/**
	 * Value of PI
	 */
	private static final double PI = Math.PI;

	// instance vars

	/**
	 * creates radius of circle
	 */
	private double radius;

	// constrcutor

	/**
	 * creates circle with radius
	 * 
	 * @param radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/**
	 * Returns area of circle
	 */
	@Override
	public double area() {
		return Circle.PI * this.radius * this.radius;
	}

	/**
	 * Returns perimeter of circle
	 */
	@Override
	public double perimeter() {
		return 2 * Circle.PI * this.radius;
	}

	/**
	 * Draws circle
	 */

	@Override
	public void draw() {
		System.out.println("Drawing a circle with radius: " + this.radius);
	}

	public static void main(String[] args) {
		System.out.println("Circle");

		// create circle with given radius
		Circle circle = new Circle(4);

		System.out.println(circle.area());
		System.out.println(circle.perimeter());
		circle.draw();

		System.out.println("");
		System.out.println("Square");

		// create square with given length of side
		// create circle with given radius
		Square square = new Square(4);
		// calls method from shape interface, implemented in square class
		System.out.println(square.area());
		System.out.println(square.perimeter());
		square.draw();

		// call method from interface and implement in square class
		System.out.println(square.volume());

		System.out.println("");
		System.out.println("Triangles");

		// create right triangle with 2 given sides
		RightTriangle rightTriangle = new RightTriangle(3, 5);

		// calls method implemented in right Triangle class
		System.out.println(rightTriangle.area());

		// calls method implemented in right Triangle class
		System.out.println(rightTriangle.perimeter());
		rightTriangle.draw();

		System.out.println("");
		// create equalateral triangle with size of 1 side
		EqualiateralTriangle equaliateralTriangle = new EqualiateralTriangle(3);

		// calls method implemented in equaliateral Triangle class
		System.out.println(equaliateralTriangle.area());

		// calls method implemented in equaliateral Triangle class
		System.out.println(equaliateralTriangle.perimeter());
		equaliateralTriangle.draw();
	}
}
