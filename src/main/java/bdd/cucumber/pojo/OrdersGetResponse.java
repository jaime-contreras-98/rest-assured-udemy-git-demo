package bdd.cucumber.pojo;

public class OrdersGetResponse {

	private OrdersData data;
	private String message;

	public OrdersData getData() {
		return data;
	}

	public void setData(OrdersData data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
