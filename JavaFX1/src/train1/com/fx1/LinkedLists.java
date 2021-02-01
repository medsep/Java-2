package train1.com.fx1;

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
