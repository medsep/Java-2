package overriding;

public class TestCase1 extends Base {

	String browserName = "firefox";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ChromeDriver driver = new ChromeDriver(); driver.click(); driver.sendKeys();
		 * driver.getTitle();
		 */

		TestCase1 tc = new TestCase1();
		tc.initBrowser();

	}

	public void initBrowser() {

		WebDriver driver = getBrowserInstance(browserName);

		driver.click();
		driver.sendKeys();
		driver.getTitle();

	}

}
