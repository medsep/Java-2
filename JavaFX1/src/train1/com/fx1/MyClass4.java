package train1.com.fx1;

public class MyClass4 {

	public static void main(String[] args) {

		Student3 stud = new Student3();
		stud.setName("Mark");

		System.out.println(stud.getName());

		System.out.println(Add(18, 35));
		System.out.println(Add(18.666, 35.9898));
		System.out.println(Add("What's", " up?"));

		Student3 Alex = new Student3();

	}

	public static int Add(int a, int b) {
		return (a + b);
	}

	public static double Add(double a, double b) {
		return (a + b);
	}

	public static String Add(String a, String b) {
		return (a + b);
	}

}
