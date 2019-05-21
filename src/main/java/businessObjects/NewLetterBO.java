package businessObjects;

import pageObjects.NewLetterPage;

public class NewLetterBO {
	NewLetterPage newLetter = new NewLetterPage();

	public void sendNewLetter(String adressee, String subject, String text){
		newLetter.sendNewLetter(adressee, subject, text);
	}
}
