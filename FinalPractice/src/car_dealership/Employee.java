package car_dealership;

public class Employee {
	public void handleCustomer(Customer customer, boolean finance, Vehicle vehicle) {
		if (finance == true) {
			double loanAmount = vehicle.getPrice() - customer.getCashOnHand();
			runCreditHistory(customer, loanAmount);
		}else if (vehicle.getPrice() <= customer.getCashOnHand()) {
			processTansaction(customer, vehicle);
		}else {
			System.out.println("Customer needs more money to purchase.");
		}
	}

	private void processTansaction(Customer customer, Vehicle vehicle) {
		System.out.println("Customer has purchased this vehicle: " + vehicle + " for the price " + vehicle.getPrice());
		
	}

	private void runCreditHistory(Customer customer, double loanAmount) {
		System.out.println("Ran credit history for customer...");
		System.out.println("Customer has been approved to purchase the vehicle");
	}
}
