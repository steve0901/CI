package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewLetterPage extends BasePage {

	@FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3[role='button']")
	private WebElement newLetterButton;

	@FindBy(css = "textarea[name='to']")
	private WebElement inputAdresseeBar;

	@FindBy(css = "input[name='subjectbox']")
	private WebElement inputSubjectBar;

	@FindBy(css = "div[role='textbox']")
	private WebElement inputTextArea;

	@FindBy(css = "div.T-I.J-J5-Ji.aoO.v7.T-I-atl.L3[role='button']")
	private WebElement sendLetterButton;

	public WebElement getSendDialogWindow() {
		return sendDialogWindow;
	}

	public WebElement getSentLetterConfirmation() {
		return sentLetterConfirmation;
	}

	@FindBy(css ="div.nH.Hd[role='dialog']")
	private WebElement sendDialogWindow;

	@FindBy(xpath ="//*[@id=\"link_vsm\"]")
	private WebElement sentLetterConfirmation;

	public void sendNewLetter(String adressee, String subject, String message) {
		newLetterButton.click();
		inputAdresseeBar.sendKeys(adressee);
		inputSubjectBar.sendKeys(subject);
		inputTextArea.sendKeys(message);
		sendLetterButton.click();
	}

	@FindBy(css = "div.qj.qr")
	private WebElement sentLetterFolderButton;

	public WebElement getSentLetterFolderButton() {
		return sentLetterFolderButton;
	}

	@FindBy(xpath = "//tbody/tr[0]//span")
	private WebElement currentLetter;

	public void checkSentLetters(){
		webDriverWait.until(ExpectedConditions.elementToBeClickable(sentLetterFolderButton));
		sentLetterFolderButton.click();
		webDriverWait.until(ExpectedConditions.elementToBeClickable(currentLetter));
		currentLetter.click();
		/*webDriverWait.until(ExpectedConditions.visibilityOf(currentLetter));*/
		/*searchBar.sendKeys("in:sent");
		searchBarButton.click();
		webDriverWait.until(ExpectedConditions.visibilityOf(currentLetter));*/
	}

	public void openSentLetters(){
		sentLetterConfirmation.click();
	}

}