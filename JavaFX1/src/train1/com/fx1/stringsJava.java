package train1.com.fx1;

public class stringsJava {

	public static void main(String[] args) {
		String myString = "Hello World";
		int myStringLength = myString.length();
		String myStringLowerCase = myString.toLowerCase();
		String myStringUpperCase = myString.toUpperCase();
		System.out.println(myStringLength);
		System.out.println(myStringLowerCase);

		System.out.println(myString.replace('e', 'a'));

		String a = "Alan";
		String b = " Turing";

		String c = a.concat(b);
		System.out.println(c);
		System.out.println(a + b);

		System.out.println(myString.indexOf('W'));
	}

}
