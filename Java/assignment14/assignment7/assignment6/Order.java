package assignment14.assignment6;

public class Order {
	String orderidString;
	String customernameString;
	String productString;
	long quantity;
	String orderdateString;
	public Order(String orderidString, String customernameString, String productString, long quantity,
			String orderdateString) {
		super();
		this.orderidString = orderidString;
		this.customernameString = customernameString;
		this.productString = productString;
		this.quantity = quantity;
		this.orderdateString = orderdateString;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderidString() {
		return orderidString;
	}
	public void setOrderidString(String orderidString) {
		this.orderidString = orderidString;
	}
	public String getCustomernameString() {
		return customernameString;
	}
	public void setCustomernameString(String customernameString) {
		this.customernameString = customernameString;
	}
	public String getProductString() {
		return productString;
	}
	public void setProductString(String productString) {
		this.productString = productString;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getOrderdateString() {
		return orderdateString;
	}
	public void setOrderdateString(String orderdateString) {
		this.orderdateString = orderdateString;
	}
	@Override
	public String toString() {
		return "Order [orderidString=" + orderidString + ", customernameString=" + customernameString
				+ ", productString=" + productString + ", quantity=" + quantity + ", orderdateString=" + orderdateString
				+ "]";
	}
	
	
}
