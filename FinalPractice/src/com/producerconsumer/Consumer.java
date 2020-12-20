package com.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> questionQueue;

	public Consumer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				int number = questionQueue.take();
				System.out.println("Answered Question: " + number);
				if (number == 20) {
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
