package train1.com.fx1;

public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		newMehtod("mehdi");

		int sum = Add(3, 5, 8);
		System.out.println(sum);

	}

	public static void newMehtod(String name) {
		System.out.println("Hello again " + name);
	}

	public static int Add(int a, int b, int c) {

		// System.out.println(a + b);
		return (a + b + c);
	}

}
