package train1.com.fx1;

public class InheritanceMain {

	public static void main(String[] args) {

		Rectangle rect = new Rectangle();
		Triangle tri = new Triangle();

		rect.set_values(10, 10);
		tri.set_values(20, 15);

		System.out.println("Rect area = " + rect.area());
		System.out.println("Tri area = " + tri.area());
	}

}
