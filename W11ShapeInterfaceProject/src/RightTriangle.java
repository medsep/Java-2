/**
 * Represents right angles triangle due to abstraction of Triangle method
 * Extends triangle
 * 
 * @author meh
 *
 */
public class RightTriangle extends Triangle {

	// constructor

	/**
	 * creates right triangle with given 2 sides calculates 3rd side the hypothonuse
	 * 
	 * @param sideA
	 * @param sideB
	 */
	public RightTriangle(double sideA, double sideB) {
		// call constructor in abstract class triangle with given sides A,B and
		// calculated sideC
		super(sideA, sideB, RightTriangle.getHypotenuse(sideA, sideB));

	}

	/**
	 * Returns hypotenuse based on 2 given sides
	 * 
	 * @param sideA
	 * @param sideB
	 * @return
	 */
	public static double getHypotenuse(double sideA, double sideB) {
		return Math.sqrt((sideA * sideA) + (sideB * sideB));
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (this.sideA * this.sideB) / 2;
	}

}
