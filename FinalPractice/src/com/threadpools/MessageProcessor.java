package com.threadpools;

public class MessageProcessor implements Runnable {

	private int message;

	public MessageProcessor(int message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "[Received] Message = " + message);
		responseToMessage(); // make thread sleep to simulate doing some work
		System.out.println(Thread.currentThread().getName() + "(Done) Processing Message = " + message);

	}

	private void responseToMessage() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Unable to process messaage " + message);
			e.printStackTrace();
		}

	}
}
