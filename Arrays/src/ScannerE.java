import java.util.Scanner;

public class ScannerE {

	public static void main(String[] args) {
		String name;
		int age;
		Scanner in = new Scanner(System.in);
		System.out.print("What is your age? \n");
		age = in.nextInt();
		in.nextLine();
		System.out.print("What is your name? ");
		name = in.nextLine();
		in.close();
		System.out.printf("Hello %s, age %d\n", name, age);

	}

}
