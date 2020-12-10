import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanGameTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRandomChooseVersion() {

		// test the game version randomly
		String version = HangmanGame.randomChooseVersion();

		assertTrue(version.equals("traditional hangman") || version.equals("evil hangman"));

		assertTrue(version.equals("traditional hangman") || version.equals("evil hangman"));

		assertTrue(version.equals("traditional hangman") || version.equals("evil hangman"));

	}

}