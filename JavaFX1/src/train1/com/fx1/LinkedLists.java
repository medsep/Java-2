package train1.com.fx1;

/**
 * linked list
 * 1- better element insertion as it maintains 2 pointers right before and after the element
 * 2- ArrayList search is faster. In LinkedList you need to ieterate over the list
 * 3- LinkedList eleemnt deletion is faster
 * 4- LinkedList has more memory than ArrayList. This means that In Arraylist the index only holds 
 * the object but in LinkedList each nodes holds the data and address. 
 */

import java.util.LinkedList;

public class LinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> name = new LinkedList<String>();
		name.add("pat");
		name.add("mat");
		name.add("john");
		name.add("tom");

		name.addFirst("John");
		name.addLast("Jack");

		name.removeLast();
		name.removeFirst();

		// name.add(1, "Andy");
		// name.remove(1);

		name.set(1, "Patrick");

		// name.clear();

		System.out.println(name.size());

		for (String x : name)
			System.out.println(x);

	}

}
