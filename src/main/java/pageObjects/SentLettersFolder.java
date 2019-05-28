package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SentLettersFolder extends BasePage {

	@FindBy(css = "input[name='q']")
	private WebElement searchBar;

	@FindBy(xpath = "//form[@role='search']/button[4]")
	private WebElement searchBarButton;

	@FindBy(xpath = "//div[@role='main']//tbody/tr[1]/td[6]")
	private WebElement currentLetter;

	public WebElement getCurrentLetter() {
		return currentLetter;
	}

	public void checkSentLetters() {
		searchBar.sendKeys("in:sent");
		searchBarButton.click();
		webDriverWait.until(ExpectedConditions.urlContains("sent"));
	}

	public void choseCurentLetter() {
		currentLetter.click();
	}
}
