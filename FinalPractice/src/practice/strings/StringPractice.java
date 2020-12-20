package practice.strings;

public class StringPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABCDEFG";
		String extractedString = str.substring(0,2);
		
		System.out.println(extractedString);
		
		String a = "hello";
		String b = "there";
		
		if (a == "hello") {
			//This is a TRAP, don't do this
		}
		
		if (a.equals("hello")) {
			//Use this instead, because String not a primitive type
		}
		//======================
		if (b.equals("there")) {
			System.out.println("Printed: there");
		}
		if (b.equals("There")) {
			System.out.println("Printed: There");
		}
		if (b.equalsIgnoreCase("There")) {
			System.out.println("Printed: There");
		}
		
		System.out.println(a.charAt(a.length()-1));
		
		//======================
		String aString = "Hello there yogi, there";
		System.out.println(aString.indexOf("there"));
		System.out.println(aString.indexOf("there",7));
		System.out.println(aString.lastIndexOf("yogi"));
	}

}
