package train1.com.fx1;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedVArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = (long) 1E7;

		ArrayList arrayList = new ArrayList();
		long milis = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			arrayList.add(i);
		}
		System.out.println("Insert arraylist takes " + (System.currentTimeMillis() - milis));

		LinkedList linkedList = new LinkedList();
		milis = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			linkedList.add(i);
		}
		System.out.println("Insert linkedList takes " + (System.currentTimeMillis() - milis));

		milis = System.currentTimeMillis();
		arrayList.remove(1E5);
		System.out.println("Del arraylist takes " + (System.currentTimeMillis() - milis));

		milis = System.currentTimeMillis();
		linkedList.remove(1E5);
		System.out.println("Del linkedList takes " + (System.currentTimeMillis() - milis));

		milis = System.currentTimeMillis();
		arrayList.get((int) n / 2);
		System.out.println("get arraylist takes " + (System.currentTimeMillis() - milis));

		milis = System.currentTimeMillis();
		linkedList.get((int) n / 2);
		System.out.println("get linkedList takes " + (System.currentTimeMillis() - milis));

	}

}
