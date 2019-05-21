import model.Const;
import driver.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CurentLetterPage;
import pageObjects.GmailLoginPage;
import pageObjects.NewLetterPage;
import pageObjects.SentLettersFolder;

import java.util.Iterator;
import java.util.stream.Stream;

public class GmailTest {

	@DataProvider(parallel = true)
	public Iterator<Object[]> users() {
		return Stream.of(
				new Object[]{"tester.toster2019@gmail.com", "synoviat1994"},
				new Object[]{"synoviat.test1@gmail.com", "synoviat1994"},
				new Object[]{"azorahaiy2019@gmail.com", "synoviat94"},
				new Object[]{"daenerystargarien6@gmail.com", "synoviat1994"},
				new Object[]{"johnsnowkingkiller@gmail.com", "gameofthrones2019"}).iterator();
	}


	@Test(dataProvider = "users")
	public void loginAndSendNewLetterTest(String email, String password){

		GmailLoginPage loginPage = new GmailLoginPage();
		loginPage.writeLogin(email);
		loginPage.writePasswordAndEnter(password);

		NewLetterPage newLetterPage = new NewLetterPage();
		newLetterPage.sendNewLetter(Const.ADRESSEE, Const.SUBJECT, Const.MESSAGE);
	//	Assert.assertFalse(newLetterPage.getSendDialogWindow().isDisplayed());
	//	Assert.assertTrue(newLetterPage.getSentLetterConfirmation().isDisplayed());
		SentLettersFolder sentLettersFolder = new SentLettersFolder();
		sentLettersFolder.checkSentLetters();
		sentLettersFolder.choseCurentLetter();

		CurentLetterPage curentLetterPage = new CurentLetterPage();
		Assert.assertEquals(curentLetterPage.getMessage().getText(), Const.MESSAGE );

		/*curentLetterPage.deleteCurentLetter();*/

	}
	@AfterMethod
	public void tearDown(){
		WebDriverManager.quit();
	}
}
