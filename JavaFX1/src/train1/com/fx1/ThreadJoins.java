package train1.com.fx1;

public class ThreadJoins {
	private static int count = 0;
	// private static int i = 0;

	public static synchronized void inccount() {
		count++;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					inccount();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					inccount();
				}
			}
		});

		t1.start();
		t2.start();
		// join on t1 and t2

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Value: " + count);
	}
}
