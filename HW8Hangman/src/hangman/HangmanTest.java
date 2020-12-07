package hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanTest {

	private Hangman hang;

	private ArrayList<String> lines;

	@BeforeEach
	void setUp() throws Exception {
		hang = new Hangman();

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

	}

	@Test
	void testIsGameOver() {
		// assertTrue(hang.getCount(15), 15);
	}

	@Test
	void testSetGameOver() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testReadWords() {

		// String file = new File("words_clean_5.txt");
		Hangman hangman = new Hangman();
		ArrayList<String> lines = hangman.readWords("words_clean_5.txt");

		assertEquals(lines.size(), 17);
		assertEquals(lines.get(0), "woozy");
		assertEquals(lines.get(16), "helloworld");

	}

	@Test
	void testCleanWords() {
		Hangman hangman = new Hangman();
		ArrayList<String> lines = hangman.readWords("words_clean_5.txt");

		assertEquals(lines.size(), 17);
		assertEquals(lines.get(0), "woozy");
		assertEquals(lines.get(16), "helloworld");
	}

	@Test
	void testSelectWord() {
		Hangman hangman = new Hangman();
		ArrayList<String> lines = hangman.readWords("words_clean.txt");

		assertEquals(lines.size(), 57);
		assertEquals(lines.get(40), "bought");
		assertEquals(lines.get(25), "brood");
		assertNotEquals(lines.get(56), "");

	}

	@Test
	void testIsGameOverString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testCorrectGuess() {
		assertTrue(hang.correctGuess("word", "w"));
		assertFalse(hang.correctGuess("word", "a"));
	}

	@Test
	void testPrint() {
		HangmanGame.current = new ArrayList<String>();
		for (int i = 0; i < "word".length(); i++) {
			HangmanGame.current.add("_ ");
		}
		HangmanGame.incorrectList = new ArrayList<String>();

		hang.print("word", "w");
		assertEquals(hang.getCount(), 1);

		hang.print("word", "a");
		assertEquals(hang.getCount(), 2);
		assertEquals(hang.getCountMistakes(), 1);
	}

}
