import java.util.Scanner;
/**
 * Another java class
 * @author meh
 *
 */
public class FirstClass {
	/**
	 * This is the main method. The entry point to any java program.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println();
		/*
		 * Defining variables 
		 */
		int x = 5;
		double y = 5.0;
		boolean flag = true;
		
		System.out.println("x " + x);
		System.out.println("y " + y);
		System.out.println("flag " + flag);
		
		/*
		 * Strings and chars
		 */
		
		String dept = "cit";
		char letter =  'a';
		
		String course = dept + 590;
		String grade = letter + "";
		
		String courseInformation = course + ": " + grade;
		System.out.println(courseInformation);
		
		/*
		 * Math operations
		 */
		
		double d = 2 *x + 10;
		double z = 2 *y + 5;
		
		System.out.println();
		System.out.println("d: " +d);
		System.out.println("z: " +z);
		
		//div with ints
		
		System.out.println("x / 2: "+ (x/2));
		
		//div with floats
		System.out.println("x / 2.0: "+ (x/2.0));
		
		//power operation
		System.out.println("x pow 4 : "+ Math.pow(x,4));
		
		/*
		 * string operations
		 */
		//string concat
		String fullName = "Mehdi"+" "+"Sepahvand";
		String fullNameUpper = fullName.toUpperCase();
		System.out.println(fullNameUpper);
		
		/*
		 * Conditionals and loops
		 */
		//if x is even using modulus
		System.out.println();
		System.out.println("x: "+ (x));
		
		if(x%2 ==0) {
			System.out.println(x + " is even");
		}else {
			System.out.println(x + " is odd");
		}
	
	double e=2.3;
	double f=2.4;
	double g=2.5;

	System.out.println();	//blank
	if (e>2 && e<f){
		System.out.println(e + "is between 2 " + f);		
	}
	//
	if (f>e || f>g) {
		System.out.println(f +" is greater than" + e + " or greater than "+ g);
	}
	//
	String a = "Hello"; 
	char b = '!'; 
	int c = 0; 
	System.out.println(a + b + c);
	
	
	//! not 
	if (g !=2.6) {
		System.out.println(g + " is not equal to 2.6");
			}
	//while loops
	int i =0;
	System.out.println();
	while (i<5) {
		System.out.println("i: "+ i);
		i++;
	}
	//for loops
	System.out.println();
	
	for(int k =0; k<10; k++) {
		System.out.println("k: " + k);
	}
	//casting
	//int to string
	String intToString = Integer.toString(1);
	
	String doubleToString = Double.toString(1.1);
	
	//print values and type of values
	System.out.println();
	System.out.println(intToString+ " "+ intToString.getClass());
	System.out.println(doubleToString+ " "+ doubleToString.getClass());
	
	//cast string to int
	int stringToInt=Integer.parseInt("1");
	
	double stringToDouble=Double.parseDouble("10.1");
	
	System.out.println(stringToInt);
	//type is not easy. first cast to object then getclass
	System.out.println(((Object)stringToInt).getClass());
	System.out.println(((Object)stringToDouble).getClass());
	
	//user input
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter a number");
	int myInt = scan.nextInt();
	System.out.println("Your number is: " + myInt);
	
	//print multiplication table upto 10 for my int
	for (int t =1; t<11; t++) {
		System.out.println(t + "x" + myInt +": " + (t* myInt));
	}
	System.out.println();
	System.out.println("Enter a String: ");
	String myStr =scan.next();
	
	for (int u =0; u<myStr.length();u++) {
		System.out.println(myStr.charAt(u));
	}
	
	scan.close();
	
	}
}
