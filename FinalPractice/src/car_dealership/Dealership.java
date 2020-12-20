package car_dealership;

public class Dealership {

	public static void main(String[] args) {
		
		Customer cust1 = new Customer();
		cust1.setName("Tom");
		cust1.setAddress("123 Anything St.");
		cust1.setCashOnHand(12000);
		
		Vehicle vehicle = new Vehicle("Honda", "Accord", 10000);
//		vehicle.setMake("Honda");
//		vehicle.setModel("Accord");
//		vehicle.setPrice(10000);
		Vehicle car = new Vehicle("Honda", "Accord", 10000);
		
		boolean boo =  car.equals(vehicle);
		System.out.println(boo);
		
		Employee emp = new Employee();
		
		cust1.purChaseCar(vehicle, emp, false);
		
	}

}
