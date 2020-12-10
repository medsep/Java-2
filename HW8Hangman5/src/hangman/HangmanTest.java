package hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HangmanTest {

	Hangman hangman;

	@Test
	void testGetRandomWord() {
		hangman = new TraditionalHangman("words.txt");
		// test case 1: normal case
		hangman.cleanWords.clear();
		hangman.cleanWords.add("one");
		hangman.cleanWords.add("two");
		hangman.cleanWords.add("oneone");
		assertTrue(hangman.cleanWords.contains(hangman.getRandomWord()));

		// test case 2: normal case
		// when there is only one word in the text
		hangman.cleanWords.clear();
		hangman.cleanWords.add("one");
		assertEquals("one", hangman.getRandomWord());

	}

	@Test
	void testGetCleanWords() {
		// test case: clean word txt
		// word.txt contains "one, tw'o, 3.4"
		hangman = new TraditionalHangman("word.txt");
		// test case 1: normal case
		List<String> comp = new ArrayList<String>();
		comp.add("one");
		// clean word is "one"
		assertEquals(comp, hangman.getCleanWords("word.txt"));

	}

	@Test
	void isClean() {
		hangman = new TraditionalHangman("words.txt");

		// test case 1: upper case letters
		assertFalse(hangman.isClean("HI"));

		// test case 2: abbreviations
		assertFalse(hangman.isClean(".com"));

		// test case 3: apostrophe
		assertFalse(hangman.isClean("I'll"));

		// test case 4: hyphen
		assertFalse(hangman.isClean("t-tru"));

		// test case 5: compound word
		assertFalse(hangman.isClean("you are"));

		// test case 6: digit
		assertFalse(hangman.isClean("y5"));
	}

	@Test
	void testGetWordLength() {
		// test case 1: normal case
		hangman = new TraditionalHangman("words.txt");
		hangman.word = "anytime";
		assertEquals(7, hangman.getWordLength());

		// test case 2: normal case
		hangman.word = "kiwi";
		assertNotEquals(3, hangman.getWordLength());

		// test case 3: when the word is null
		hangman.word = "";
		assertEquals(0, hangman.getWordLength());
	}

	@Test
	void testContainsDigit() {

		hangman = new TraditionalHangman("words.txt");

		// test case 1: contains digit
		assertTrue(hangman.ContainsDigit("you2"));

		// test case 2: does not contain digit
		assertFalse(hangman.ContainsDigit("you"));
	}

	@Test
	void testIncorrectGusses() {
		hangman = new TraditionalHangman("words.txt");

		// test case 1: normal case
		hangman.incorrectGuesses.clear();
		hangman.incorrectGuesses("k");
		assertEquals("k", hangman.incorrectGuesses.get(0));

		// test case 2: normal case
		hangman.incorrectGuesses("p");
		assertEquals(2, hangman.incorrectGuesses.size());
		assertEquals("p", hangman.incorrectGuesses.get(1));
	}

	@Test
	void testIsGameOver() {
		// test case 1: game over
		hangman = new TraditionalHangman("words.txt");
		for (int i = 0; i < hangman.correct.length; i++)
			hangman.correct[i] = true;
		assertTrue(hangman.isGameOver());

		// test case 2: game not over
		for (int i = 0; i < hangman.correct.length; i++)
			hangman.correct[i] = false;
		assertFalse(hangman.isGameOver());
	}
}
