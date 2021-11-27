
public class ArrayException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int i[] = new int[5];

			i[5] = 55;

			Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("Error occured");

			// for selenium
			// screenshot with error message

			e.printStackTrace();
		}

		System.out.println("Ends");
	}

}
