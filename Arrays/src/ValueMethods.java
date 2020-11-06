
public class ValueMethods {

	public static void countup(int n) {
		if (n == 0) {
			System.out.println("Blastoff!");
		} else {
			countup(n - 2);
			System.out.println(n);
		}
	}

	public static double calculateArea(double radius) {
		double result = Math.PI * radius * radius;
		return result;
	}

	public static double absoluteValue(double x) {
		if (x < 0) {
			return -x;
		} else {
			return x;
		}
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		double dsquared = dx * dx + dy * dy;
		double result = Math.sqrt(dsquared);
		return result;
	}

	public static double circleArea(double xc, double yc, double xp, double yp) {
		double radius = distance(xc, yc, xp, yp);
		double area = calculateArea(radius);
		return area;
	}

	// public static double calculateArea(double xc, double yc, double xp, double
	// yp) {
	// return calculateArea(distance(xc, yc, xp, yp));
	// }

	/**
	 * overloading
	 * 
	 * @param xc
	 * @param yc
	 * @param xp
	 * @param yp
	 * @return
	 */
	public static double calculateArea(double xc, double yc, double xp, double yp) {
		return calculateArea(distance(xc, yc, xp, yp));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// countup(6);
		// System.out.println("Have a nice day.");
		// System.out.println(calculateArea(56.0));
		// System.out.println(absoluteValue(-66));
		// System.out.println(distance(66, 80, 76, 90));
		// System.out.println("dsquared is " + distance(9, 8, 7, 5));
		System.out.println(calculateArea(18, 29, 8, 9));
	}
}
