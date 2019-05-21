import businessObjects.CheckSentLetterBO;
import businessObjects.LoginPageBO;
import businessObjects.NewLetterBO;
import driver.WebDriverManager;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.XMLparser;

import java.util.Iterator;
import java.util.stream.Stream;

public class GmailTest {

	private Logger logger = LogManager.getLogger(GmailTest.class);
	XMLparser xmLparser = new XMLparser();
	User user = xmLparser.getUser();


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
	public void loginAndSendNewLetterTest(String email, String password) {

		LoginPageBO loginPageBO = new LoginPageBO();
		loginPageBO.logIn(email, password);
		logger.info("Email and password are correct");

		NewLetterBO newLetterBO = new NewLetterBO();
		newLetterBO.sendNewLetter(user.getAdressee(), user.getSubject(), user.getTextMessage());
		logger.info("The message was sent");

		CheckSentLetterBO checkSentLetterBO = new CheckSentLetterBO();
		checkSentLetterBO.checkSentLettersFolder(user.getTextMessage());
		logger.info("The test was successful");
	}

	@AfterMethod
	public void tearDown() {
		WebDriverManager.quit();
	}
}
