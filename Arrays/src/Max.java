public class Max {

	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		for (String arg : args) {
			int value = Integer.parseInt(arg);
			if (value > max) {
				max = value;
			}
		}
		System.out.println("The max is " + max);

	}

}