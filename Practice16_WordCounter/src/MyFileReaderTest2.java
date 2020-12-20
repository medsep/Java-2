import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyFileReaderTest2 {

	MyFileReader myFileReader1;
	MyFileReader myFileReader2;
	MyFileReader myFileReader3;

	@BeforeEach
	void setUp() {

		// original war_and_peace.txt file
		this.myFileReader1 = new MyFileReader("war_and_peace.txt");

		// test file containing some text from war_and_peace.txt, with different
		// characters and info
		this.myFileReader2 = new MyFileReader("test1.txt");

		// test file containing some text from war_and_peace.txt, with empty lines
		this.myFileReader3 = new MyFileReader("test2.txt");
	}

	@Test
	public void testGetCleanContent() {

		// test original war_and_peace.txt file
		ArrayList<String> actual = myFileReader1.getCleanContent();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("The Project Gutenberg EBook of War and Peace, by Leo Tolstoy");
		expected.add("This eBook is for the use of anyone anywhere at no cost and with almost");
		expected.add("no restrictions whatsoever. You may copy it, give it away or re-use");
		expected.add("it under the terms of the Project Gutenberg License included with this");
		expected.add("eBook or online at www.gutenberg.org");
		expected.add("Title: War and Peace");
		expected.add("Author: Leo Tolstoy");
		expected.add("Translators: Louise and Aylmer Maude");
		expected.add("Posting Date: January 10, 2009 [EBook #2600]");
		expected.add("Last Updated: December 17, 2016");
		expected.add("Language: English");
		expected.add("Character set encoding: UTF-8");

		// assert first 12 lines containing text
		for (int i = 1; i < expected.size(); i++) {
			assertEquals(expected.get(i), actual.get(i));
		}

		// test shorter file
		actual = myFileReader2.getCleanContent();
		expected = new ArrayList<String>();
		expected.removeAll(expected);
		expected.add("Lines	Other Info");
		expected.add("\"The Project Gutenberg EBook of War and Peace, by Leo Tolstoy\"");
		expected.add("Author: Leo Tolstoy");
		expected.add("CHAPTER I");
		expected.add("\"�Well, Prince, so Genoa and Lucca are now just family estates of the\"");
		expected.add("\"Buonapartes. But I warn you, if you don�t tell me that this means war,\"");
		expected.add("if you still try to defend the infamies and horrors perpetrated by that");
		assertEquals(expected, actual);

		// TODO write at least 1 additional test case using a different MyFileReader

	}

}
