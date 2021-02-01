package train1.com.fx1;

public class Methods2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello = new Hello();
		Hello.DoSomething("Hello again");
		Hello.age = 10;

		hello.DoSomethingElse("Hello again");
		hello.year = 2021;

		System.out.println(hello.year);
	}

}
