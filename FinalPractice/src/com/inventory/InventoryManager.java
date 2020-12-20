package com.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

	/*
	 * ArrayList is not thread safe. (no synchronized in method signature :Line 38
	 * in ArrayList.class)
	 */
	List<Product> soldProductsList = new CopyOnWriteArrayList<>();
	List<Product> purchasedProductsList = new ArrayList<>();

	public void populateSoldProducts() {
		for (int i = 0; i < 1000; i++) {
			Product product = new Product(i, "test_product_" + i);
			soldProductsList.add(product);
			System.out.println("Added: " + product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void displaySoldProducts() {
		for (Product product : soldProductsList) {
			System.out.println("Printing the Sold: " + product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
