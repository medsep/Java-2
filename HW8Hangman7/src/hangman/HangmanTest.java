package hangman;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dictionary.HangmanDictionary;

class HangmanTest {

	Hangman hangman;

	@BeforeEach
	void setUp() throws Exception {

		HangmanDictionary myReader = new HangmanDictionary("src/dictionary/words_clean.txt");

		List<String> wordList = myReader.readFileIn();

		hangman = new HangmanTraditional(wordList);
	}

	@Test
	void testRandomChooseWord() {

		// since it's a random method, just repeat test
		assertTrue(hangman.wordList.contains(hangman.randomChooseWord()));

		assertTrue(hangman.wordList.contains(hangman.randomChooseWord()));

		assertTrue(hangman.wordList.contains(hangman.randomChooseWord()));

	}

	@Test
	void testIsGameOver() {

		assertFalse(hangman.isGameOver());

		hangman.getCorrectGuess().add("x".charAt(0));
		assertFalse(hangman.isGameOver());

		for (int i = 0; i < hangman.getTheWord().length(); i++) {
			hangman.getCorrectGuess().add(hangman.getTheWord().charAt(i));
		}
		assertTrue(hangman.isGameOver());

		hangman.getCorrectGuess().remove(1);
		assertFalse(hangman.isGameOver());
	}

}