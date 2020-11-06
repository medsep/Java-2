package banking;

/**
 * Represents a checking/savings account for a customer
 * 
 * @author meh
 *
 */
public class BankAccount {
	// instance vars
	String accountType;
	double balance;

	/**
	 * customer for this account
	 */
	Customer customer;

	/*
	 * fixed amount for quick withdrawals
	 */
	double fastCashAmount;

	/**
	 * create bank account for given customer
	 * 
	 * @param accountType
	 * @param customer
	 */
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType;
		this.customer = customer;

		this.fastCashAmount = 60;

	}
	// methods

	/**
	 * deposits the given amount
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}

	/**
	 * withdraws the given amount from balance
	 */

	public void withdraw(double amount) throws Exception {
		if (amount > this.balance)
			throw new Exception("Amount is greater than available balance");
		this.balance -= amount;
	}

	/*
	 * Withdraws fast cash amount throws Exception if given fast cash amount is
	 * greater than available balance
	 */
	public void fastWithdraw() throws Exception {
		this.withdraw(this.fastCashAmount);
	}

	/*
	 * sets fast cashamount is greater than 0
	 */
	public void setFastCashAmount(double amount) {
		if (amount > 0) {
			this.fastCashAmount = amount;
		}
	}

	/**
	 * basic account info
	 */
	public String getAccountInfo() {
		return this.accountType + ": " + this.balance;
	}

	public String getCustomerInfo() {
		return this.customer.getName() + " from " + this.customer.getAddress();
	}

}
