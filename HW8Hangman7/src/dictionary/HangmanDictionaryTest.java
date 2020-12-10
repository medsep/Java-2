package dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanDictionaryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testIsWordClean() {

		String string = "rug-cutting";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "Zambia";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "mrs.";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "you're";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "mother-in-law";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "post office";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "3-D";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "2nd";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "happy";
		assertTrue(HangmanDictionary.isWordClean(string));

		string = "baNana";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "1st";
		assertFalse(HangmanDictionary.isWordClean(string));

		string = "compound word";
		assertFalse(HangmanDictionary.isWordClean(string));

	}

}
