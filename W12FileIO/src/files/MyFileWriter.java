package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Utility class for writing to files.
 * 
 * @author meh
 *
 */
public class MyFileWriter {

	/**
	 * Write the sums to a file
	 * 
	 * @param fileName
	 * @param lineSum
	 * @param append
	 */
	public static void writeFileLineSums(String fileName, ArrayList<Double> lineSums, boolean append) {

		// create file object
		File file = new File(fileName);

		// defile file and pribtWriter
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(file, append);
			printWriter = new PrintWriter(fileWriter);

			// iterate over arraylist of values and write each to the file
			for (double line : lineSums) {
				printWriter.println(line);
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
