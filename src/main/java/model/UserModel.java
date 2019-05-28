package model;

public class UserModel {
	private String email;
	private String password;
	private Message message;

	public class Message {
		private String adressee;
		private String subject;
		private String text;

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

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Message(String adressee, String subject, String text) {
			this.adressee = adressee;
			this.subject = subject;
			this.text = text;
		}

		public Message() {
		}

		@Override
		public String toString() {
			return "Message{" +
					"adressee='" + adressee + '\'' +
					", subject='" + subject + '\'' +
					", text='" + text + '\'' +
					'}';
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public UserModel(String email, String password, Message message) {
		this.email = email;
		this.password = password;
		this.message = message;
	}

	public UserModel() {
	}

	@Override
	public String toString() {
		return "UserModel{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				", message=" + message +
				'}';
	}
}
