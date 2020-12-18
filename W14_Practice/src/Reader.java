import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	/**
	 * Read the file and return the List<String>
	 * 
	 * @param fileName
	 * @return List<String> lines
	 */
	public static List<String> readFile(String fileName) {
		List<String> lines = new ArrayList<>();

		BufferedReader br = null;
		try {
			String line;
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				line = line.trim();
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return lines;
	}
}
