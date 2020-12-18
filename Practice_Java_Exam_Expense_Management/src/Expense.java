//package expenses;

/**
 * Represents a single expense for a particular month.
 */
public class Expense {

	/**
	 * Number of month for expense.
	 */
	private int month;

	/**
	 * Amount of expense.
	 */
	private double amount;

	/**
	 * Creates Expense with given month number and amount.
	 * 
	 * @param month  for expense
	 * @param amount for expense
	 */
	public Expense(int month, double amount) {
		this.month = month;
		this.amount = amount;
	}

	/**
	 * Get month of expense.
	 * 
	 * @return month
	 */
	public int getMonth() {
		// TODO Implement method

		return this.month;
	}

	/**
	 * Get amount of expense.
	 * 
	 * @return amount
	 */
	public double getAmount() {
		// TODO Implement method

		return this.amount;
	}

	/**
	 * Returns the month number and amount for expense.
	 */
	@Override
	public String toString() {
		// TODO Implement method

		return "month number: " + this.month + " : " + "Expense amount: " + this.amount;
	}

	/**
	 * Compares two Expense objects for equality, based on the amounts. If the
	 * amounts are equal, the Expense objects are equal.
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Implement method
		Double delta = 0.000001;
		Expense otherExpense = (Expense) o;

		// if (this.month == otherExpense.month) {
		if ((this.amount == otherExpense.amount)) {
			return true;
		}
		// }

		return false;

	}

}