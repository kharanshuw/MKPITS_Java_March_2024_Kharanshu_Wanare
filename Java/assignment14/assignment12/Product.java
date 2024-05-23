package assignment14;

public class Product {
	String idString;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String idString) {
		super();
		this.idString = idString;
	}

	@Override
	public String toString() {
		return "Product [idString=" + idString + "]";
	}

	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}
	
	
}
