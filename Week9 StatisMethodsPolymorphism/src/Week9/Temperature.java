package Week9;

public class Temperature {
	static int maxTemperature = 0;
	int temperature;

	public Temperature(int t) {
		if (t > Temperature.maxTemperature) {
			Temperature.maxTemperature = t;
		}
		this.temperature = t;
	}

	public static void main(String[] args) {
		Temperature t1 = new Temperature(65);
		Temperature t2 = new Temperature(90);
		Temperature t3 = new Temperature(55);
		System.out.println("Max Temperature: " + Temperature.maxTemperature);
	}
}