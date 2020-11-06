package Cars;

public class Car {
	/**
	 * Make of car
	 */
	String make;

	/**
	 * Model
	 */
	String mode;

	/**
	 * Max speed
	 */
	int maxSpeed;

	/**
	 * Transmission type
	 */
	String transmission;

	/**
	 * set state of car
	 */
	boolean moving;

	Driver driver;
	Passenger passenger1;
	Passenger passenger2;
	Passenger passenger3;

	public Car(String make, String mode, int maxSpeed, String trasmission, Driver driver) {
		this.make = make;
		this.mode = mode;
		this.maxSpeed = maxSpeed;
		this.transmission = transmission;
		this.driver = driver;
	}

	/**
	 * Start driving
	 */
	void drive() {
		System.out.println("Car is moving!");

		this.moving = true;

		this.passenger1.setCarSick(true);
	}

	/**
	 * Stop method.
	 */

	void stop() {
		System.out.println("Car stopped!");

		this.moving = false;

		this.passenger1.setCarSick(false);
	}

}
