package com.threading;

public class Application {
	public static void main(String args[]) {

		System.out.println("Starting Thread A");
		Task taskRunner1 = new Task("Thread_A");
		taskRunner1.start();

		System.out.println("Starting Thread B");
		Thread t1 = new Thread(new TaskImplementsRunnable("Thread_B"));
		t1.start();
		// Task taskRunner2 = new Task("Thread_B");
		// taskRunner2.start();

		System.out.println("Starting Runnable:");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Thread.currentThread().setName("anonymous runnable");
				for (int i = 0; i < 20; i++) {
					String threadName = Thread.currentThread().getName();
					System.out.println("Thread Name [" + threadName + "] prints number: " + i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();

	}
}

class Task extends Thread {

	private String threadName = "";

	public Task(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		Thread.currentThread().setName(this.threadName);
		for (int i = 0; i < 20; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread Name [" + threadName + "] prints number: " + i);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TaskImplementsRunnable implements Runnable {

	private String threadName = "";

	public TaskImplementsRunnable(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		Thread.currentThread().setName(this.threadName);
		for (int i = 0; i < 20; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread Name [" + threadName + "] prints number: " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
