package CollectionsExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Key value pair header is key, value is pair
 * 
 * @author mehdi
 *
 */
public class HashMapExamples {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("FirstName", "Bob");
		map.put("FirstName", "Steve");
		map.put("LastName", "Jones");
		map.put("Subject", "CS");
		map.put("Location", "India");

		System.out.println(map);
		System.out.println(map.size());
		System.out.println(map.get("FirstName"));

		Set<String> keys = map.keySet();

		for (String key : keys) {
			System.out.println("Key -->" + key + " value --> " + map.get(key));
		}

		Map<String, List<String>> map1 = new HashMap<String, List<String>>();
		List<String> listOfEmails = new ArrayList<String>();

		listOfEmails.add("abc@email.com");
		listOfEmails.add("bbc@email.com");
		listOfEmails.add("cbc@email.com");
		listOfEmails.add("dbc@email.com");
		listOfEmails.add("ebc@email.com");

		map1.put("email", listOfEmails);

		Map<String, Map<String, String>> map2 = new HashMap<String, Map<String, String>>();

	}
}