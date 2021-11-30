package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class testCase1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\object.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("course"));
		System.out.println(System.getProperty("user.dir"));

	}

}
