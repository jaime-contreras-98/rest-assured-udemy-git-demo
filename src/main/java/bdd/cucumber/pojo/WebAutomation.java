package bdd.cucumber.pojo;

public class WebAutomation {

	private String courseTitle;
	private String price;

	public WebAutomation(String courseTitle, String price) {
		this.courseTitle = courseTitle;
		this.price = price;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
