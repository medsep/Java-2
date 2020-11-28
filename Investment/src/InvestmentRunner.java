import java.util.Scanner;

/**
 * Calculate how long it takes for balance to double
 * 
 * @author meh
 *
 */
public class InvestmentRunner {

	static final double INITIAL_BALANCE = 10000;
	static final double RATE = 5;
	static final int YEARS = 20;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Welcome to the investment calculator.\n" + "We will caculate the return on your investment.\n"
				+ "Happy investing!\n" + "To start please enter the amount you wish to invest: ");

		// Ask user for input and pass in corresponding method 1 or 2
		int amount = sc.nextInt();
		System.out.print("Enter your desired rate of return: ");
		int rate = sc.nextInt();
		// Investment invest = new Investment(INITIAL_BALANCE, RATE);.
		Investment invest = new Investment(amount, rate);
		// int years = invest.getYears();
		System.out.print("Enter your inestment horizon in years: ");
		int wait = sc.nextInt();

		invest.waitForBalance(amount);
		invest.waitYears(wait);
		double balance = invest.getBalance();
		System.out.println(
				"Investment after " + wait + " years with a " + "balance of \n " + String.format("%.2f", balance));

		sc.close();
	}
}