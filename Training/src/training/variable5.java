package training;

public class variable5 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 10;
		byte c = (byte) (a + b); // compile time error
		System.out.println(c);
	}
}
