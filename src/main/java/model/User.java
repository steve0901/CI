package model;

public class User {
	private Integer number;
	private String adressee;
	private String subject;
	private String textMessage;


	public String getAdressee() {
		return adressee;
	}

	public void setAdressee(String adressee) {
		this.adressee = adressee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
