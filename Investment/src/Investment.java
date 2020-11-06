/**
 * Monitors growth of an investment
 * 
 * @author meh
 *
 */
public class Investment {

	private double rate;
	private double balance;
	private int year;
	private int n;

	/**
	 * Creates an investment object
	 * 
	 * @param aBalance
	 * @param aRate
	 */
	public Investment(double aBalance, double aRate) {
		this.balance = aBalance;
		this.rate = aRate;
		year = 0;
	}

	/**
	 * Keep accumulating interest until target reached.
	 * 
	 * @param targetBalance
	 */
	public void waitForBalance(double targetBalance) {
		while (balance < targetBalance) {
			year++;
			double interest = balance * rate / 100;
			balance += interest;
		}
	}

	public void waitYears(int numberOfYears) {
		for (int i = 1; i <= numberOfYears; i++) {
			double interest = balance * rate / 100;
			balance += interest;
		}
		year = year + n;
	}

	/**
	 * Gets the balance
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Get the number of years that accumulated interest.
	 * 
	 * @return year
	 */
	public int getYears() {
		return year;
	}

}
