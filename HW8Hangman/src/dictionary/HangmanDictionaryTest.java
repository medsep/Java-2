package dictionary;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanDictionaryTest {

	@BeforeEach
	ArrayList<String> setUp() throws Exception {

		File file = new File("words.txt");

		ArrayList<String> wordList = new ArrayList<String>();

		Scanner scanner;

		try {
			scanner = new Scanner(file);

			String word;

			while (scanner.hasNextLine()) {
				word = scanner.nextLine().trim();

				if (approvedWord(word)) {
					wordList.add(word);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wordList;
	}

	@Test
	void testReadDictionary() {
		// ArrayList<String> wordList = new ArrayList<String>();

		ArrayList<String> wordList = null;
		assertEquals(wordList.size(), 17);
		// assertEquals(wordList.get(0), "woozy");
		// assertEquals(wordList.get(16), "helloworld");
	}

	@Test
	void testApprovedWord() {
		String word = "bana88na";
		assertTrue(approvedWord(word));

	}

	private boolean approvedWord(String word) {

		boolean approved = true;

		if (word.split("(A-Z)").length > 1) {
			approved = false;
		} else if (word.split(".").length > 1) {
			approved = false;
		} else if (word.split("'").length > 1) {
			approved = false;
		} else if (word.split("-").length > 1) {
			approved = false;
		} else if (word.split("\\s+").length > 1) {
			approved = false;
		} else if (word.split("(0-9)").length > 1) {
			approved = false;
		}

		return approved;
	}

}
