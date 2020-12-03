package hangman;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The harder version Extends the nrmal game
 * 
 * @author meh
 *
 */
public class HangmanEvil extends Hangman {

	private String longDictionary;

	public HangmanEvil() {
		super();
	}

	public ArrayList<String> newDictionary(String filename) {
		String word = super.selectWord(filename);

		ArrayList<String> dict = Hangman.readWords(filename);
		ArrayList<String> wordDict = new ArrayList<String>();

		for (String each : dict) {
			if (each.length() == word.length()) {
				wordDict.add(each);
			}
		}
		return wordDict;
	}

	public HashMap<String, ArrayList<String>> buildDictionary(ArrayList<String> wordDict, String letter) {

		HashMap<String, ArrayList<String>> family = new HashMap<String, ArrayList<String>>();

		ArrayList<String> familyList;

		for (String each : wordDict) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < each.length(); i++) {
				if (Character.toString(each.charAt(i)).contentEquals(letter)) {
					sb.append(letter);
				} else {
					sb.append("-");
				}
			}
			String s = sb.toString();

			if (!family.containsKey(s)) {

				familyList = new ArrayList<String>();
				familyList.add(each);
				family.put(s, familyList);
			} else {
				familyList = family.get(s);
				familyList.add(each);
			}
		}
		return family;
	}

	public ArrayList<String> pickLargestFamily(HashMap<String, ArrayList<String>> family) {

		int max = 1;

		for (String key : family.keySet()) {
			if (family.get(key).size() > max) {
				max = family.get(key).size();
				this.longDictionary = key;
			}
		}
		return family.get(longDictionary);
	}

}
