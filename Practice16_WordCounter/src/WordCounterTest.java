import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.junit.jupiter.api.Test;

class WordCounterTest {

	@Test
	void testWordCounter() {
		
		// Create new FileReader
		MyFileReader fr = new MyFileReader("war_and_peace.txt");
		
		// Get clean lines from the File
		ArrayList<String> linesSol = fr.getCleanContent();
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(linesSol);
		
		// Get map of words and counts 
		Map<String, Integer> counters = wc.getWordCounter();

		// Test the count of different words in map
		assertEquals(counters.get("at"), 4201);
		assertEquals(counters.get("in"), 8228);
		assertEquals(counters.getOrDefault("adasdada", 0), 0);
		assertEquals(counters.getOrDefault(" ", 0), 0);
		
		
		// TODO write at least 3 additional test cases 
		// Recommended: Test the counts of other words in the map. (Remember, words are case-sensitive.)

	}
	
	@Test
	void testGetWordsOccuringMoreThan() {
		
		// Create new FileReader
		MyFileReader fr = new MyFileReader("war_and_peace.txt");
		
		// Get clean lines from the File
		ArrayList<String> linesSol = fr.getCleanContent();
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(linesSol);
		
		ArrayList<String> ls1 = wc.getWordsOccuringMoreThan(0);
		assertEquals(ls1.size(),41993);
		
		ArrayList<String> ls2 = wc.getWordsOccuringMoreThan(1000);
		assertEquals(ls2.size(),57);
		
		ArrayList<String> ls3 = wc.getWordsOccuringMoreThan(10000);
		assertEquals(ls3.size(),5);
		
		
		// TODO write at least 3 additional test cases 
		// Recommended: Test edge cases.  For example: Small numbers, large numbers, negative numbers, etc.
		
	}
	
	@Test
	void testGenerateWordCounts() {
		// lines to count words
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("war and the");
		lines.add("war the peace peace");
		lines.add("the war the");
		
		Map<String, Integer> expectedCounts = new HashMap<String, Integer>();
		expectedCounts.put("war", 3);
		expectedCounts.put("and", 1);
		expectedCounts.put("the", 4);
		expectedCounts.put("peace", 2);
		
		// Create new Word Counter
		WordCounter wc = new WordCounter(lines);
		
		// Get and test map of words and counts
		assertEquals(expectedCounts, wc.getWordCounter());
		
		
		// TODO write at least 3 additional test cases
		// Recommended: Define other lists of lines and test the generated map of word counts
	}

}