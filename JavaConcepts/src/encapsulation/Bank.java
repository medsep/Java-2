package encapsulation;

public class Bank {

	public int accountNo = 123456;
	private int pinNo = 1234;
	private double balanceAmount = 1000000;

	public void setPinNo() {

	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getPinNo() {
		return pinNo;
	}

	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public void withdrawAmount(int accNo, int pin, int amount) {

		if (accountNo == accNo && pin == pinNo) {

			if (amount <= balanceAmount) {
				balanceAmount -= amount;
				System.out.println("Amount withdrawn :" + amount);
			} else {
				System.out.println("Insufficient balance!!!!");
			}
		} else {
			System.out.println("Invalid credentials!!!");

		}
	}

	public void updatePin(int accNo, int oldPin, int newPin) {

		if (accNo == accountNo && oldPin == pinNo) {
			pinNo = newPin;
			System.out.println("Pin change successful!!!");
		}
	}

	public double depositCash(int accNo, int pin, double amount) {

		if (accNo == accountNo && pin == pinNo) {

			balanceAmount += amount;
			return amount;

		} else {
			System.out.println("Invalid Credentials!!!");
			return balanceAmount;
		}

	}

}
