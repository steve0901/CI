package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurentLetterPage extends BasePage {

	@FindBy(xpath = "//div[@role='button']/div[@class='asa']")
	private WebElement deleteButton;

	@FindBy(xpath = "//div[@class='gs']//div[@dir='ltr']")
	private WebElement message;

	public WebElement getMessage() {
		return message;
	}

	public void deleteCurentLetter() {
		webDriverWait.until(ExpectedConditions.visibilityOf(deleteButton));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
	}
}
