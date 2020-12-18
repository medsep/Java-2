
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads a file, parsing and cleaning each line.
 */
public class MyFileReader {

	private String filename;

	public MyFileReader(String filename) {
		this.filename = filename;
	}

	/**
	 * Reads content in a file and cleans content line by line. Example : " hello
	 * world " -> "hello world"
	 * 
	 * @return A list of strings with no empty spaces at the beginning or end
	 */
	public ArrayList<String> getCleanContent() {
		ArrayList<String> lines = new ArrayList<String>();

		try {
			BufferedReader file = new BufferedReader(new FileReader(filename));

			String line = file.readLine();

			while (line != null) {

				line = line.trim();

				if (!line.isEmpty()) {
					lines.add(line);
				}

				line = file.readLine();
			}

			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

}
