package businessObjects;


import model.Const;
import org.testng.Assert;
import pageObjects.CurentLetterPage;
import pageObjects.SentLettersFolder;

public class CheckSentLetterBO {

	private SentLettersFolder sentLetters = new SentLettersFolder();
	private CurentLetterPage curentLetterPage = new CurentLetterPage();

	public void checkSentLettersFolder(String messege){
		sentLetters.checkSentLetters();
		sentLetters.choseCurentLetter();
		Assert.assertEquals(curentLetterPage.getMessage().getText(),messege);
	}
}
