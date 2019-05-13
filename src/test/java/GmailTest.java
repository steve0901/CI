import Model.Const;
import driver.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.CurentLetterPage;
import pageObjects.GmailLoginPage;
import pageObjects.NewLetterPage;

public class GmailTest {

	@Test
	public void loginAndSendNewLetterTest(){

		GmailLoginPage loginPage = new GmailLoginPage();
		loginPage.writeLogin(Const.LOGIN);
		loginPage.writePasswordAndEnter(Const.PASSWORD);

		NewLetterPage newLetterPage = new NewLetterPage();
		newLetterPage.sendNewLetter(Const.ADRESSEE, Const.SUBJECT, Const.MESSAGE);
		Assert.assertFalse(newLetterPage.getSendDialogWindow().isDisplayed());
		Assert.assertTrue(newLetterPage.getSentLetterConfirmation().isDisplayed());
		newLetterPage.openSentLetters();
		/*SentLettersFolder sentLettersFolder = new SentLettersFolder();
		sentLettersFolder.checkSentLetters();
		Assert.assertEquals(sentLettersFolder.getCurrentLetter().getText(), Const.MESSAGE);
		sentLettersFolder.choseCurentLetter();*/
		CurentLetterPage curentLetterPage = new CurentLetterPage();
		curentLetterPage.deleteCurentLetter();
	}
	@AfterTest
	public void tearDown(){
		WebDriverManager.quit();
	}
}
