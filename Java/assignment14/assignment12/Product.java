package assignment14.assignment12;

public class Product {
String productidString;

public Product(String productidString) {
	super();
	this.productidString = productidString;
}

@Override
public String toString() {
	return "Product [productidString=" + productidString + "]";
}

public String getProductidString() {
	return productidString;
}

public void setProductidString(String productidString) {
	this.productidString = productidString;
}


}
