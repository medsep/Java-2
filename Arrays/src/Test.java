import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		int inch;
		double cm;
		Scanner in = new Scanner(System.in);
		// prompt user input
		System.out.print("How many inches? ");
		inch = in.nextInt();
		// conversion
		cm = inch * 2.54;
		System.out.print(inch + " in = ");
		System.out.println(cm + " cm");
		double cmPerInch = 2.54;
		cm = inch * cmPerInch;
		final double CM_PER_INCH = 2.54;

		System.out.printf("Four thirds = %.3f", 4.0 / 3.0);

		int inch1 = 100;
		double cm1 = inch1 * CM_PER_INCH;
		System.out.printf("%d in = %f cm\n", inch1, cm1);

	}
}