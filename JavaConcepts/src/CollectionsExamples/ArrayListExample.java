package CollectionsExamples;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList list = new ArrayList();
		System.out.println(list);

		list.add(10);
		list.add("bb");
		list.add(10.33);
		list.add('d');
		list.add(true);
		list.add(null);
		list.add("bb");

		// typecasting Obj in array to int
		int var = (Integer) list.get(0);

		/*
		 * System.out.println(list); System.out.println(list.size());
		 * 
		 * System.out.println(list.get(1)); System.out.println(list.get(6));
		 * 
		 * list.remove(1); System.out.println(list); System.out.println(list.size());
		 * 
		 * for (int i = 0; i < list.size(); i++) { System.out.println(list.get(i)); }
		 * 
		 * for (Object var : list) { System.out.println(var); }
		 * 
		 * Iterator itr = list.iterator(); while (itr.hasNext()) {
		 * System.out.println(itr.next()); }
		 */

	}

}
