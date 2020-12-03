package training;

public class variables7 {

	String myInstanceVar = "instance variable";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		variables7 obj1 = new variables7();
		variables7 obj2 = new variables7();
		variables7 obj3 = new variables7();

		System.out.println(obj1.myInstanceVar);
		System.out.println(obj2.myInstanceVar);
		System.out.println(obj3.myInstanceVar);

		obj2.myInstanceVar = "Changed Text";
		System.out.println(obj1.myInstanceVar);
		System.out.println(obj2.myInstanceVar);
		System.out.println(obj3.myInstanceVar);

	}

}
