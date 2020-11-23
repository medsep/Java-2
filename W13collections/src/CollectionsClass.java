import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class with various methods for using different kinds of collections
 * 
 * @author meh
 *
 */
public class CollectionsClass {

	/**
	 * Takes a given list and removes elemenst in range min-max inclusive
	 * 
	 * @param list, through use of iterator
	 * @param min   range
	 * @param max   range
	 */
	public static void removeRange(ArrayList<Integer> list, int min, int max) {

		// Create iterator to iterate over list and remove items in place
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if (next >= min && next <= max) {
				iterator.remove();
			}
		}

	}

	/**
	 * Takes a list and adds a stars between elements
	 */
	public static void addStars(ArrayList<String> list) {
		// copy alll values in arraylist to array
		// toArray takes an input an empty array into which it will be stored
		String[] array = list.toArray(new String[list.size()]);

		// empty original arrayList
		list.removeAll(Arrays.asList(array));

		// add stars and values back to original list
		list.add("*");
		for (String s : array) {
			list.add(s);
			list.add("*");
		}
	}

	/**
	 * Takes a given array and returns map with a key for each strnig and valie for
	 * number of times string appears in the array. Demosntrates use of hash map
	 * 
	 * @param strings
	 * @return
	 */
	public static Map<String, Integer> wordCount(String[] strings) {

		// create a hash map (no order)
		Map<String, Integer> map = new HashMap<String, Integer>();

		// iterate over array of strings
		for (String s : strings) {

			// if map doesnt contain key for string, add it
			if (!map.containsKey(s)) {

				// add key with default count 1
				map.put(s, 1);
			} else {

				map.replace(s, map.get(s) + 1);
			}
		}
		return map;
	}

	/**
	 * Takes array of words and counts unique words using HashSet Case-Sensitive are
	 * considered different words
	 * 
	 * @param words
	 * @return
	 */
	public static int countUniqueWords(String[] words) {
		// creates hashSet (hash no order) to remove duplicates
		Set<String> hashSetWords = new HashSet<String>(Arrays.asList(words));

		// return count of unique elements in given array
		return hashSetWords.size();
	}

	/**
	 * Takes array of words and counts unique words using TREESET Case-Insensitive
	 * are considered different words
	 * 
	 * @param words
	 * @return
	 */
	public static int countUniqueWordsCaseInSensitive(String[] words) {

		// CREATE TREESET but ordered
		// String.Case_insetive forces treeset to compare its eleemnts in a
		// case-insenstive way
		Set<String> treeSetWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		// add all elemnts to treeset
		treeSetWords.addAll(Arrays.asList(words));
		return treeSetWords.size();
	}

	/**
	 * Takes a give arrayList of integers and modfifies by removing duplicates using
	 * linkedhashset
	 * 
	 * @param list list in ints
	 */
	public static void removeDuplicates(ArrayList<Integer> list) {
		// maintain insertion order
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>(list);

		// remove all items from original list
		list.removeAll(list);

		// add all elemnts from linkedhashset to original list
		list.addAll(linkedHashSet);
	}

	/***
	 * Take a map of food keys and topping values and midfies map as follows If key
	 * icecream is present set it to cherry in all cases set the key break to have
	 * teh value of butter
	 * 
	 * @param map of food items and toppings
	 * @return
	 */
	public static Map<String, String> setToppings(Map<String, String> map) {

		// set bread to buuter
		if (!map.containsKey("bread")) {
			map.put("bread", "butter");
		}

		if (map.containsKey("ice cream")) {
			map.replace("ice cream", "cherry");
		}
		return map;
	}

	/**
	 * Takes a map and reads friend relationships and stores them into a compound
	 * collection that is returned.
	 * 
	 * Creates a new map where each key is a person's name and the value is the set
	 * of all friends of that person.
	 * 
	 * Friendships are bi-directional: If Marty is friends with Danielle, then
	 * Danielle is friends with Marty
	 * 
	 * The map parameter contains one friend relationship per key/value pair,
	 * consisting of two names. For example, if the map parameter friendMap looks
	 * like this: {Marty: Cynthia, Danielle: Marty}
	 * 
	 * Then the call of friendList(friendMap) should return a map with the
	 * following: {Cynthia:[Marty], Danielle:[Marty], Marty:[Cynthia, Danielle]}
	 * 
	 * Demonstrates use of a TreeMap of TreeSets
	 * 
	 * @param friendMap of friendships
	 * @return map where the key is a person's name and the value is the set of all
	 *         friends
	 */
	public static TreeMap<String, TreeSet<String>> friendList(Map<String, String> friendMap) {

		// create a tree map of tree sets like hashsets but ordered
		TreeMap<String, TreeSet<String>> treeMap = new TreeMap<String, TreeSet<String>>();

		// iterate over the entry set (key/value pars)
		for (Entry<String, String> friendShip : friendMap.entrySet()) {

			// get 2 freinds and freindship
			// gey key
			String friend1 = friendShip.getKey();

			// get value
			String friend2 = friendShip.getValue();

			// if tree map doesnt contain key for friend 1
			if (!treeMap.containsKey(friend1)) {
				// put friend1 with empty treeset as value
				treeMap.put(friend1, new TreeSet<String>());
			}
			// add friend2 to friend1 tree seyy
			treeMap.get(friend1).add(friend2);

			// if tree map doesnt contain key for friend 2
			if (!treeMap.containsKey(friend2)) {
				// put freind2 with empty treeset as value
				treeMap.put(friend2, new TreeSet<String>());
			}

			treeMap.get(friend2).add(friend1);

		}

		return treeMap;

	}

	/**
	 * Takes as a parameter, a HashSet of TreeSets of integers, and returns a
	 * TreeSet of integers representing the union of all the sets of ints.
	 * 
	 * A union is the combination of everything (without duplicates) in each set.
	 * 
	 * For example, calling the method on the following set of sets: {{1, 2}, {2, 3,
	 * 4, 5}, {3, 5, 6, 7}, {42}} Should cause the following set of integers to be
	 * returned: {1, 2, 3, 4, 5, 6, 7, 42}
	 * 
	 * Demonstrates use of HashSet<TreeSet<Integer>>.
	 * 
	 * @param sets to union
	 * @return union of all sets
	 */
	public static TreeSet<Integer> unionSets(HashSet<TreeSet<Integer>> sets) {

		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		for (TreeSet<Integer> ts : sets) {
			treeSet.addAll(ts);
		}
		return treeSet;
	}

	public static void main(String[] args) {

		// removeRange
		// create array of ints
		Integer[] removeRangeArray = { 7, 9, 4, 2, 7, 7, 5, 3, 5, 1, 7, 8, 6, 7 };
		ArrayList<Integer> list = new ArrayList<Integer>();

		// add all items from array to arraylist
		list.addAll(Arrays.asList(removeRangeArray));

		CollectionsClass.removeRange(list, 5, 7);

		System.out.println("removeRange: " + list);
		System.out.println("");

		// add stars
		// create array of strings
		String[] addStar = { "the", "quick", "brown", "fox" };

		// add all items in array to arraylist
		ArrayList<String> sList = new ArrayList<String>();
		sList.addAll(Arrays.asList(addStar));

		CollectionsClass.addStars(sList);

		System.out.println("addStars: " + sList);
		System.out.println();

		// word count
		String[] strings = { "a", "b", "a", "c", "b" };
		Map<String, Integer> ret = CollectionsClass.wordCount(strings);

		System.out.println("WordCount: " + ret);
		System.out.println();

		// couunt unique words
		String[] countUniqueWordsArray = { "hello", "Hello", "lizzy", "and", "Elise", "and", "Louise", "Heel", "and" };

		System.out.println("countUniqueWords: " + CollectionsClass.countUniqueWords(countUniqueWordsArray));
		System.out.println();

		// caseINsensitive count
		System.out.println(
				"countUniqueWords: " + CollectionsClass.countUniqueWordsCaseInSensitive(countUniqueWordsArray));
		System.out.println();

		// remove dullicates
		Integer[] removeDuplicatesArray = { 4, 0, 2, 9, 4, 7, 2, 0, 0, 9, 6, 6 };
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(Arrays.asList(removeDuplicatesArray));

		CollectionsClass.removeDuplicates(list2);

		System.out.println("removeDuplicates: " + list2);
		System.out.println();

		// set topings
		// create hash map
		Map<String, String> food = new HashMap<String, String>();
		food.put("ice cream", "peanuts");

		Map<String, String> m = CollectionsClass.setToppings(food);
		System.out.println("setTopings: " + m);
		System.out.println();

		// friend method
		HashMap<String, String> friendShips = new HashMap<String, String>();
		friendShips.put("Marty", "Cynthia");
		friendShips.put("Dani", "Marety");

		TreeMap<String, TreeSet<String>> friendList = CollectionsClass.friendList(friendShips);

		System.out.println("friendlist: " + friendList);
		System.out.println();

		// union sets
		HashSet<TreeSet<Integer>> hashSet = new HashSet<TreeSet<Integer>>();

		TreeSet<Integer> ts = new TreeSet<Integer>();
		Integer[] arr1 = { 1, 3 };
		ts.addAll(Arrays.asList(arr1));
		hashSet.add(ts);

		ts = new TreeSet<Integer>();
		Integer[] arr2 = { 5, 4, 3, 2 };
		ts.addAll(Arrays.asList(arr2));
		hashSet.add(ts);

		ts = new TreeSet<Integer>();
		Integer[] arr3 = { 3, 5, 6, 7 };
		ts.addAll(Arrays.asList(arr3));
		hashSet.add(ts);

		ts = new TreeSet<Integer>();
		Integer[] arr4 = { 42 };
		ts.addAll(Arrays.asList(arr4));
		hashSet.add(ts);

		TreeSet<Integer> treeSet = CollectionsClass.unionSets(hashSet);

		System.out.println("unionSets: " + treeSet);
		System.out.println();

	}

}
