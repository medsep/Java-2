package CollectionsExamples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<String>();
		set.add("Andi");
		set.add("Andy");
		set.add("Randi");
		set.add("Bandi");
		set.add("Dandi");
		set.add("Randi");

		System.out.println(set);
		/*
		 * for (String var : set) { System.out.println(set); }
		 */
		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) {
			// System.out.println(itr.next());
			String var = itr.next();
			if (var.equals("Andi")) {
				System.out.println(var);
			}
		}

	}
}