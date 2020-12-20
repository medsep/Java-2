package com.client;

import com.inventory.InventoryManager;

public class Applicaiton {

	public static void main(String[] args) throws InterruptedException {
		InventoryManager inventoryManager = new InventoryManager();

		Thread inventoryTask = new Thread(new Runnable() {

			@Override
			public void run() {
				inventoryManager.populateSoldProducts();

			}
		});

		Thread displayTask = new Thread(new Runnable() {

			@Override
			public void run() {
				inventoryManager.displaySoldProducts();

			}
		});

		inventoryTask.start();
		// inventoryTask.join();
		Thread.sleep(2000);
		displayTask.start();

	}

}
