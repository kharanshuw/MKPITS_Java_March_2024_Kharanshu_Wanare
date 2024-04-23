package onlineshoppingcart;

public class Product {
	private String nameString;
	private double price;
	private boolean isavailable;
	private int stock;
	
	public Product(String nameString, double price, boolean isavailable) {
		super();
		this.nameString = nameString;
		this.price = price;
		this.isavailable = isavailable;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isIsavailable() {
		return isavailable;
	}

	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void addProduct(int no) {
		
	}
	
	public void removeProduct() {
		
	}
}
