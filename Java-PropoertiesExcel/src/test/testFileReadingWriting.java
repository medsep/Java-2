package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class testFileReadingWriting {

	public static void main(String[] args) throws Exception {

//create a file
		File file = new File("C:\\Users\\mehdi\\OneDrive\\Documents\\filewriting\\test.txt");
		file.createNewFile();
//write insdie
		FileWriter fw = new FileWriter("C:\\Users\\mehdi\\OneDrive\\Documents\\filewriting\\test.txt", true);
		BufferedWriter filewriter = new BufferedWriter(fw);

		filewriter.write("Please write inside!!!");
		filewriter.newLine();
		filewriter.write("This is the second line!!!");

		filewriter.flush();
//reader

		FileReader fr = new FileReader("C:\\Users\\mehdi\\OneDrive\\Documents\\filewriting\\test.txt");
		BufferedReader filereader = new BufferedReader(fr);

		// System.out.println(filereader.readLine());

		String i = "";
		while ((i = filereader.readLine()) != null) {
			System.out.println(i);
		}

	}

}
