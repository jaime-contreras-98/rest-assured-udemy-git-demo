package bdd.cucumber.pojo;

import java.util.List;

public class OrdersRequest {

	private List<Order> orders;

	public OrdersRequest(List<Order> orders) {
		this.orders = orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

}
