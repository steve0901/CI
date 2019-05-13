package pageObjects;

import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver;

	public BasePage() {
		this.driver = WebDriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
}
