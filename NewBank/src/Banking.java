import org.openqa.selenium.firefox.FirefoxDriver;

import Part1.Calculator;

public class Banking {

	Calculator calc = new Calculator();

	public void profit() {

	}

	public void loss() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Banking b = new Banking();

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.bbc.co.uk/news");
	}

}
