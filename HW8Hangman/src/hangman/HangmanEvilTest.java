package hangman;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanEvilTest {

	private HangmanEvil hang;
	private ArrayList<String> newDictionary;
	private HashMap<String, ArrayList<String>> family;
	private ArrayList<String> largestFamily;
	private ArrayList<String> lines;

	@BeforeEach
	void setUp() throws Exception {
		hang = new HangmanEvil();

		File file = new File("words.txt");

		lines = new ArrayList<String>();

		FileReader fileReader = null;

		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line = bufferedReader.readLine();
			// get the first 34 lines of word.txt (contains only one valid word "a")
			while (line != null && lines.size() <= 34) {
				if (!line.isEmpty()) {
					lines.add(line);
				}
				line = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		newDictionary = hang.newDictionary("words_clean_5.txt");
		family = hang.buildDictionary(newDictionary, "e");
		largestFamily = hang.pickLargestFamily(family);

	}

	@Test
	void testNewDictionary() {

		assertEquals(15, newDictionary.size());
		assertFalse(newDictionary.contains("bode"));
		assertNotEquals(newDictionary.size(), 0);
	}

	@Test
	void testBuildDictionary() {
		assertEquals(5, family.size());
		assertEquals("level", family.get("-e-e-").get(0));
		assertEquals("bench", family.get("-e---").get(0));
	}

	@Test
	void testPickLargestFamily() {
		// fail("Not yet implemented"); // TODO
		assertEquals(11, largestFamily.size());
		assertTrue(largestFamily.contains("blood"));
		assertTrue(largestFamily.contains("brood"));
		assertFalse(largestFamily.contains("disastrous"));
	}
}
