package Test1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWriter1 {

	public static void main(String[] argv) throws Exception {
		FileWriter fw = new FileWriter("file.dat");
		String strs[] = { "com", "exe", "doc" };

		BufferedWriter outputWriter = null;
		outputWriter = new BufferedWriter(fw);
		for (int i = 0; i < strs.length; i++) {
			// Maybe:
			outputWriter.write(strs[i] + "");
			outputWriter.write(" ");
			// Or:
			// outputWriter.write(Integer.toString(strs[i]);
			// outputWriter.newLine();
		}
		outputWriter.flush();
		outputWriter.close();

	}
	// fw.close();
	// System.out.println();
}
