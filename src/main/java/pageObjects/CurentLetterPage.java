package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurentLetterPage extends BasePage {

	@FindBy(xpath = "//div[@role='button']/div[@class='asa']")
	private WebElement deleteButton;

	public WebElement getMessage() {
		return message;
	}

	@FindBy(xpath = "//div[@class='gs']//div[@dir='ltr']")
	private WebElement message;

	@FindBy(css = "img.hA.T-I-J3[role='menu']")
	private WebElement moreOption;

	public void deleteCurentLetter() {
		webDriverWait.until(ExpectedConditions.visibilityOf(deleteButton));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));

	}
}
