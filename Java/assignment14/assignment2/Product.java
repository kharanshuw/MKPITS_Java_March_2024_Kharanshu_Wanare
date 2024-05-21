package inventoryManagementSystem;

public class Product implements Comparable<Product> {
	private int productid;
	private String nameString;
	private int quantity;
	private double price;
	public Product(int productid, String nameString, int quantity, double price) {
		super();
		this.productid = productid;
		this.nameString = nameString;
		this.quantity = quantity;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", nameString=" + nameString + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int compareTo(Product o) {
		if (this.price==o.getPrice()) {
			return 0;
		}
		else if (this.price>o.getPrice()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	
	
}
