
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Start");

			int div = 33 / 0;
			System.out.println(div);
		} catch (Exception e) {
			System.out.println("Error occured");
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		System.out.println("End");
	}

}
