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

		String string = "Zambia";
		assertFalse(fileReader.isWordClean(string));

		string = "mrs.";
		assertFalse(fileReader.isWordClean(string));

		string = "you're";
		assertFalse(fileReader.isWordClean(string));

		string = "mother-in-law";
		assertFalse(fileReader.isWordClean(string));

		string = "post office";
		assertFalse(fileReader.isWordClean(string));

		string = "2nd";
		assertFalse(fileReader.isWordClean(string));

		string = "happy";
		assertTrue(fileReader.isWordClean(string));

	}

}
