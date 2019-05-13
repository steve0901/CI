package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentLettersFolder {

	@FindBy(xpath = "//a[@title='Надіслані']")
	private WebElement sentLetterFolderButton;

	public WebElement getCurrentLetter() {
		return currentLetter;
	}

	@FindBy(xpath = "//div/input[@dir='ltr']")
	private WebElement searchBar;

	@FindBy(xpath = "//tbody/tr[1]//span")
	private WebElement currentLetter;

	public void checkSentLetters(){
		sentLetterFolderButton.click();
		/*searchBar.sendKeys("in:sent");
		searchBar.submit();*/
	}

	public void choseCurentLetter(){
		currentLetter.click();
	}





}
