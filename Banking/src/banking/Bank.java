package banking;

import java.util.Scanner;

/**
 * Represents a bank for managing customers and their bank accounts
 * @author meh
 *
 */
public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		
		//calls the run method in bank class
		bank.run();

	}
	/**
	 * runs the program by initializing and managing bank accounts and customers
	 */
	public void run() {
		System.out.println("Welcome to the bank! What is your name?");
		
		Scanner scanner = new Scanner(System.in);
		//get the next token or work which is customer's name
		String name = scanner.next();
		System.out.println("Hello" + name + "! We are creating checking and saving accounts for you.");
		
		Customer customer = new Customer(name);
		//get address 
		System.out.println("What is your address?");
		//get next token or work which is the customer's address
		String address = scanner.next();
		//address
		customer.setAddress(address);
		//checking account
		BankAccount checkingAccount = new BankAccount("Checking", customer);
		//create a savings account for customer
		BankAccount savingsAccount = new BankAccount("Savings", customer);
		//gets and prints customer info
		System.out.println();
		System.out.println("Customer info: ");
		System.out.println(checkingAccount.getCustomerInfo());
		
		System.out.println("Checkimg account: ");
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println("Savings account: ");
		System.out.println(checkingAccount.getAccountInfo());
		
		//deposits
		//into checkings
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your checking account");
		double amount = scanner.nextDouble();
		checkingAccount.deposit(amount);
		
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your checking account?");
		amount = scanner.nextDouble();
		savingsAccount.deposit(amount);
		
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		//making withdrawals
		//from checking 
		System.out.println();
		System.out.println("Amount (decimal) to withdraw from your checking account");
		amount = scanner.nextDouble();
		
		try {
			checkingAccount.withdraw(amount);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		//from savings
				System.out.println();
				System.out.println("Amount (decimal) to withdraw from your savings account");
				amount = scanner.nextDouble();
		
		try {
			checkingAccount.withdraw(amount);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println(savingsAccount.getAccountInfo());
		
		scanner.close();
		
		}

}
