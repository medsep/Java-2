
public class finally_block {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// final int x = 1000;

		try {

			// db connection
			// excecute qury
			// validate data
			// close conncetion

			int i[] = new int[5];

			i[5] = 55;

			System.out.println("Close the DB in try block");

		} catch (Exception e) {

			System.out.println("Error occurred");

		} finally {
			System.out.println("Closing the DB connection");
		}

	}

}
