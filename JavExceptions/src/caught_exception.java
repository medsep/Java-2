
public class caught_exception {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int i[] = new int[5];

		i[5] = 55;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(1000);
		Thread.sleep(1000);
	}

}
