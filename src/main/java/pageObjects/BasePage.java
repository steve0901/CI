package pageObjects;

import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait webDriverWait;


	public BasePage() {
		this.driver = WebDriverManager.getDriver();
		PageFactory.initElements(driver, this);
		webDriverWait = new WebDriverWait(driver, 20);
	}

}
