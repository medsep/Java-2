/**
 * Allows to dynammically update array size
 * @param args
 */

package train1.com.fx1;

import java.util.ArrayList;

public class Arraylists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int simple_array[] = new int[5];

		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(9);
		myList.add(6);
		myList.add(8);
		myList.add(66);
		myList.add(86);

		for (Integer x : myList) {
			System.out.println(x);
		}

		System.out.println("");
		myList.remove(2);

		// another method to remove index
		myList.set(0, 55);

		for (Integer x : myList) {
			System.out.println(x);
		}

		// empties the array
		// myList.clear();

		myList.trimToSize();

		System.out.println("size = " + myList.size());

	}

}
