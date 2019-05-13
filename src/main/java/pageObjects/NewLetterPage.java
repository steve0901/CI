package pageObjects;

import Model.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.UUID;



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

	public void openSentLetters(){
		sentLetterConfirmation.click();
	}

}