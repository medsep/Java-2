
public class Arrays1d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[10];
		String[] myArray = new String[13];

		System.out.println(myArray.length);

		System.out.println(array);

		array[0] = 25;
		array[2] = 20;
		array[4] = 30;

		System.out.println(array[2]);

		for (int i = 0; i < array.length; i++) {

			array[i] = (int) (Math.random() * 1000);
			System.out.println(array[i]);
		}

		for (int var : array) {
			System.out.println(var);
		}

		System.out.println("---Print in reverse order---inventer");
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
	}

}
