package bdd.cucumber.pojo;

public class Message {

	private String message;
	private String greet;

	public Message(String message, String greet) {
		this.message = message;
		this.greet = greet;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	public String getGreet() {
		return greet;
	}

}
