package hangman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanEvilTest {

	private HangmanEvil hangEvil;
	private ArrayList<String> wordPool;
	private HashMap<String, ArrayList<String>> family;
	private ArrayList<String> largestFamily;
	private ArrayList<String> lines;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHangmanEvil() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testNewDictionary() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testBuildDictionary() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testPickLargestFamily() {
		// fail("Not yet implemented"); // TODO
		assertEquals(2, largestFamily.size());
		assertTrue(largestFamily.contains("help"));
		assertTrue(largestFamily.contains("belt"));
	}
}
