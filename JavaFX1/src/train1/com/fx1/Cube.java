package train1.com.fx1;

public class Cube {

	int length;
	int height;
	int breadth;

	public int Volume() {
		return (length * height * breadth);
	}

	Cube() {
		// never returns any values
		System.out.println("We are in the constructor");
		length = 50;
		breadth = 30;
		height = 20;
	}

	Cube(int l, int b, int h) {
		// never returns any values
		System.out.println("We are in the constructor");
		length = l;
		breadth = b;
		height = h;
	}
}
