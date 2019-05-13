package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurentLetterPage {

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	@FindBy(css = "div.ar9.T-I-J3.J-J5-Ji")
	private WebElement deleteButton;

	public void deleteCurentLetter(){
		deleteButton.click();
	}
}
