package onlineshoppingcart;

public class Order {
	double totalamount;
	int totalitems;
		
	public Order(double totalamount, int totalitems) {
		super();
		this.totalamount = totalamount;
		this.totalitems = totalitems;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public int getTotalitems() {
		return totalitems;
	}
	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}
		
}
