package train1.com.fx1;

import java.util.HashSet;
import java.util.Iterator;

/**
 * list conatins duplicats, sets can't
 * 
 * @author mehdi
 *
 */
public class HashSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<String> name = new HashSet<String>();
		name.add("Matt");
		name.add("Bob");
		name.add("Rob");
		name.add("Tod");
		name.add("Matt");
		name.add("Pod");

		Iterator<String> itr = name.iterator();

		while (itr.hasNext())
			System.out.println(itr.next());

	}

}
