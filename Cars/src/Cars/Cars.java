package Cars;

public class Cars {

	Car car1;

	Car car2;

	Car car3;

	/**
	 * runs the program by initiating cars, drivers, passengers
	 * 
	 * @param args
	 */

	private void run() {
		// create driver
		Driver driver1 = new Driver("Mehdi", 37, true, false);
		// create car
		this.car1 = new Car("Toyota", "Corolla", 100, "Manual", driver1);
		// create passenger
		Passenger passenger1 = new Passenger("Moe", 34);

		// add passenger to car
		car1.passenger1 = passenger1;

		// print driver name and age
		System.out.println("Driver name: " + car1.driver.getName());
		System.out.println("Driver age: " + car1.driver.getAge());

		System.out.println("----------------------------------------");

		// create driver
		Driver driver2 = new Driver("Ahmad", 35, true, true);
		// create car
		this.car2 = new Car("VW", "Polo", 100, "Automatic", driver2);
		// create and add 3 passengers to car
		this.car2.passenger1 = new Passenger("Mary", 32);
		this.car2.passenger2 = new Passenger("Matty", 22);
		this.car2.passenger3 = new Passenger("Micky", 12);

		// tells car to stop
		this.car2.stop();

		// if passenger are sick
		System.out.println("Passenger 1 car sick " + car1.passenger1.carSick);
		System.out.println("Passenger 2 car sick " + car2.passenger2.carSick);

		System.out.println("----------------------------------------");

		// create driver3
		Driver driver3 = new Driver("Abbas", 42, true, true);
		// create car
		this.car3 = new Car("Nissan", "Pulsar", 100, "Automatic", driver3);
		// create and add 3 passengers to car
		this.car3.passenger1 = new Passenger("Manny", 32);

		// set car 3 to drive
		this.car3.drive();

		// print id driver has license
		System.out.println("Does driver have license: " + car3.driver.hasLicense);

	}

	public static void main(String[] args) {
		// create instance of cars
		Cars cars = new Cars();

		// run the program
		cars.run();

	}

}
