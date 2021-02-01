package train1.com.fx1;

public class MyClass3 {

	public static void main(String[] args) {

		Cube cube1 = new Cube();

		System.out.println(cube1.Volume());

		Cube cube2 = new Cube(20, 20, 10);

		System.out.println(cube2.Volume());
	}

}
