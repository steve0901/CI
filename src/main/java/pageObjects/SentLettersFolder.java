package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SentLettersFolder extends BasePage{

	@FindBy(css = "div.qj.qr")
	private WebElement sentLetterFolderButton;

	public WebElement getCurrentLetter() {
		return currentLetter;
	}

	@FindBy(css = "input[name='q']")
	private WebElement searchBar;

	@FindBy(xpath = "//form[@role='search']/button[4]")
	private WebElement searchBarButton;

	@FindBy(xpath = "//div[@role='main']//tbody/tr[1]/td[6]")
	private WebElement currentLetter;

	public void checkSentLetters(){
		/*sentLetterFolderButton.click();
		webDriverWait.until(ExpectedConditions.visibilityOf(currentLetter));*/
		searchBar.sendKeys("in:sent");
		searchBarButton.click();
		webDriverWait.until(ExpectedConditions.urlContains("sent"));
	}

	public void choseCurentLetter(){
		currentLetter.click();
	}





}
