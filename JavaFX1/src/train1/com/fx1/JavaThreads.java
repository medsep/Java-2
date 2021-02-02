package train1.com.fx1;

/**
 * MultiThreading is multiple threads of control in a single program
 * MultiTasking is the abilit to perform multiple tasks concurrently. Cocurrency
 * muyltiple tasks on single CPU based on priority given by CPU Multiple CPUs
 * 
 * @author mehdi
 **/
class MyClass5 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getId() + " Value " + i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class JavaThreads {

	public static void main(String[] args) {
		MyClass5 myClass = new MyClass5();
		myClass.start();

		MyClass5 myClass1 = new MyClass5();
		myClass1.start();
	}

}
