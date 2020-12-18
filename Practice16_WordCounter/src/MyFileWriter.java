import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Class to write a list of words to a file.
 */
public class MyFileWriter {

	/**
	 * Name of file being written to.
	 */
	private String filename;

	/**
	 * Creates MyFileWriter with given filename to write to.
	 * 
	 * @param filename to write to
	 */
	public MyFileWriter(String filename) {
		this.filename = filename;
	}

	/**
	 * Opens the file specified by filename and writes each word in the given list
	 * of words to the file. Each word is written to a new line in the file.
	 *
	 * Example(s): - If the given list of words contains: "a", "he", "in", "of",
	 * "to" Calling writeToFile(ArrayList<String> words) will open the file, then
	 * write each word in the given list of words to the file, in the following
	 * format: a he in of to
	 * 
	 * @param list of words to write to the file
	 */
	public void writeToFile(ArrayList<String> words) +-{

		// TODO Implement method
		File file = new File(filename);

		// defile file and pribtWriter
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(file);
			printWriter = new PrintWriter(fileWriter);

			// iterate over arraylist of values and write each to the file
			for (String line : words) {
				// Maybe:
				printWriter.write(line + "");
				printWriter.write(" ");
				// Or:
				// outputWriter.write(Integer.toString(strs[i]);
				// outputWriter.newLine();
			}

			// Memory flush
			printWriter.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// regardless of what happens close file objects
			try {
				fileWriter.close();
				printWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}