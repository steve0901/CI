package businessObjects;

import pageObjects.GmailLoginPage;

public class LoginPageBO {

	private GmailLoginPage loginPage = new GmailLoginPage();

	public void logIn(String email, String password){
		loginPage.writeLogin(email);
		loginPage.writePasswordAndEnter(password);
	}

}
