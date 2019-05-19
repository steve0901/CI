package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurentLetterPage extends BasePage {

	@FindBy(css = "div.asa::after")
	private WebElement deleteButton;

	public void deleteCurentLetter(){
		deleteButton.click();
	}
}
