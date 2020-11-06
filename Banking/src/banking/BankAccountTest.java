package banking;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

	// declare objects for testing
	Customer customer;
	BankAccount myCheckingAccount;
	BankAccount mySavingsAccount;

	@BeforeEach
	void setUp() throws Exception {
		// initialize objects for testing
		this.customer = new Customer("Mehdi");
		this.myCheckingAccount = new BankAccount("checking", this.customer);
		this.mySavingsAccount = new BankAccount("savings", this.customer);
	}

	@Test
	void testDeposit() {

		// make deposit
		this.myCheckingAccount.deposit(100);
		// test that current balance is 100
		assertEquals(100, this.myCheckingAccount.balance);

		// make deposit of negative amount
		this.myCheckingAccount.deposit(-100);

		assertEquals(100, this.myCheckingAccount.balance);
		// deposit 0
		this.myCheckingAccount.deposit(0);

		assertEquals(100, this.myCheckingAccount.balance);
	}

	@Test
	void testWithdraw() {

		this.mySavingsAccount.deposit(100);

		assertEquals(100, this.mySavingsAccount.balance);
		// try to maker withdrawals of 80
		try {
			this.mySavingsAccount.withdraw(80);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// balance should be 20
		assertEquals(20, this.mySavingsAccount.balance);
		// try to withdraw amount greater than balance
		// expect exception
		assertThrows(Exception.class, () -> {
			this.mySavingsAccount.withdraw(21);
		});

		assertEquals(20, this.mySavingsAccount.balance);

		// try to make withdraw does not throw exception
		assertDoesNotThrow(() -> {
			this.mySavingsAccount.withdraw(19);
		});
		// balance should be 1
		assertEquals(1, this.mySavingsAccount.balance);
	}

	@Test
	void testFastWithdraw() {
		this.myCheckingAccount.deposit(100);

		// try to make fast withdraw default60
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// balance should be 40
		assertEquals(40, this.myCheckingAccount.balance);

		// reset fastCash
		this.myCheckingAccount.setFastCashAmount(20);

		assertDoesNotThrow(() -> {
			this.myCheckingAccount.fastWithdraw();
		});

		// check balance
		assertEquals(20, this.myCheckingAccount.balance);

		// set fast cash to negative. should be ignored
		this.myCheckingAccount.setFastCashAmount(-50);

		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(0, this.myCheckingAccount.balance);

		// expecting exception when making fast withdrawal because of 0 balance
		assertThrows(Exception.class, () -> {
			this.myCheckingAccount.fastWithdraw();
		});

	}

}
