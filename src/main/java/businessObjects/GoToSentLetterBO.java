package businessObjects;

import org.testng.Assert;
import pageObjects.CurentLetterPage;
import pageObjects.SentLettersFolder;

public class GoToSentLetterBO {

	private SentLettersFolder sentLetters = new SentLettersFolder();
	private CurentLetterPage curentLetterPage = new CurentLetterPage();

	public void openSentLetter() {
		sentLetters.checkSentLetters();
		sentLetters.choseCurentLetter();
	}

	public void isTheSameLetter(String messege){
		Assert.assertEquals(curentLetterPage.getMessage().getText(), messege);
	}
}
