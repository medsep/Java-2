import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 100);
		map.put("b", 200);
		map.put("c", 300);
		map.put("d", 400);

		// Gets EntrySet view of keys and values
		Set<Map.Entry<String, Integer>> mapSet = map.entrySet();

		for (Map.Entry<String, Integer> entrance : mapSet) {
			System.out.print(entrance.getKey() + ":");
			System.out.println(entrance.getValue());
		}
	}
}
