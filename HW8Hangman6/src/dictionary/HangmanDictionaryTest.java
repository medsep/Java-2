package dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class HangmanDictionaryTest {

	ArrayList<String> list;

	@Test
	void testCleanWords() {
		list = new ArrayList<String>(
				Arrays.asList("apple", "baNana", "1st", "3-D", "compound word", "you're", "rug-cutting"));
		ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("apple"));
		assertTrue(list2.equals(HangmanDictionary.cleanWords(list)));
		list2 = new ArrayList<String>(Arrays.asList("apple", "baNana"));
		assertFalse(list2.equals(HangmanDictionary.cleanWords(list)));
		list2 = new ArrayList<String>(Arrays.asList("apple", "1st"));
		assertFalse(list2.equals(HangmanDictionary.cleanWords(list)));
		list2 = new ArrayList<String>(Arrays.asList("3-D", "rug-cutting"));
		assertFalse(list2.equals(HangmanDictionary.cleanWords(list)));
	}

}
