package overriding;

public class FirefoxDriver extends WebDriver {

	public void click() {

		System.out.println(" Clicking in FF");

	}

	public void sendKeys() {
		System.out.println(" Typing in in FF");

	}

}
