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

		Investment invest = new Investment(INITIAL_BALANCE, RATE);
		invest.waitForBalance(2 * INITIAL_BALANCE);
		// int years = invest.getYears();
		invest.waitYears(YEARS);
		double balance = invest.getBalance();
		System.out.println("Investment doubled after " + YEARS + " years with a " + "balance of "
				+ String.format("%.2f", balance));
	}
}
