import java.util.ArrayList;
import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("there");
		//words.remove(0);
//		words.add(10);
//		words.add(12.00);
//		words.add('H');
		
		String item1 = (String) words.get(0);
		String item2 = (String) words.get(1);
		
		System.out.println(item1);
		System.out.println(item2);
		
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.removeFirst();
		
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

	}

}
