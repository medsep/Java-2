package Week9;

public class Numbers {

	int number1 = 3;
	static int number2 = 5;

	public Numbers(int number1, int number2) {

		if (number2 < 20) {
			Numbers.number2 = number2;
		}
		number1 = number1;
	}

	public static void main(String args[]) {

		Numbers numbers1 = new Numbers(6, 5);
		Numbers numbers2 = new Numbers(23, 11);

		System.out.println(numbers1.number1 + " " + numbers1.number2 + " " + numbers2.number1 + " " + numbers2.number2);

	}
}