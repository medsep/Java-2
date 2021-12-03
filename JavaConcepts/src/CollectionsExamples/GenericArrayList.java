package CollectionsExamples;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayList {

	public static void main(String[] args) {
		// avoids typecasting

		List<Integer> list = new ArrayList();
		list.add(10);
		// list.add(10.25);
		list.add(null);

		int i = list.get(0);
		System.out.println(i);

	}

}
