package train1.com.fx1;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * 4 types of list iterator 1- boolean hasNext() 2- Object next() 3-boolean
 * hasPrevious() 4- object previous()
 * 
 * @author mehdi
 *
 */

public class ListIterators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Al");
		names.add("Tom");
		names.add("Ron");
		names.add("Som");
		names.add("Jack");

		ListIterator<String> itr = names.listIterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("");
		System.out.println("");

		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}

}
