/**
 * Represents equaliateral triangle and Extends triangle
 * 
 * @author meh
 *
 */
public class EqualiateralTriangle extends Triangle {

	// constructor

	public EqualiateralTriangle(double sideLength) {
		// calls constructor in superclass triangle
		// with given sidelength
		super(sideLength, sideLength, sideLength);
	}

	@Override
	public double area() {
		// inherits sideA from triangle class
		return (Math.sqrt(3) / 4) * (this.sideA * this.sideA);
	}
}
