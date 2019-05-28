package stepDefenition;

import businessObjects.GoToSentLetterBO;
import businessObjects.LoginPageBO;
import businessObjects.NewLetterBO;
import model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailTestSteps {
	private Logger logger = LogManager.getLogger(GmailTestSteps.class);

	public void openChrome(){

	}

	public void logInIntoGmail(UserModel model) {
		LoginPageBO loginPageBO = new LoginPageBO();
		loginPageBO.logIn(model.getEmail(), model.getPassword());
		logger.info("Email and password are correct");
	}

	public void writeNewMessage(UserModel model){
		NewLetterBO newLetterBO = new NewLetterBO();
		newLetterBO.sendNewLetter(
				model.getMessage().getAdressee(),
				model.getMessage().getSubject(),
				model.getMessage().getText());
		logger.info("The message was sent");
	}

	public void verifyTheSentFolder(UserModel model){
		GoToSentLetterBO goToSentLetterBO = new GoToSentLetterBO();
		goToSentLetterBO.openSentLetter();
		goToSentLetterBO.isTheSameLetter(model.getMessage().getText());
		logger.info("The test was successful");
	}
}
