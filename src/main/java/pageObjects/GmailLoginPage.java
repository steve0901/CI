package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends BasePage {

	@FindBy(id = "identifierId")
	private WebElement loginInputBar;

	@FindBy(id = "identifierNext")
	private WebElement identifierNextButton;

	@FindBy(name = "password")
	private WebElement passwordInputBar;

	@FindBy(id = "passwordNext")
	private WebElement passwordNextBatton;

	public void writeLogin(String login) {
		loginInputBar.sendKeys(login);
		identifierNextButton.click();
	}

	public void writePasswordAndEnter(String password) {
		passwordInputBar.sendKeys(password);
		passwordNextBatton.click();
	}
}
