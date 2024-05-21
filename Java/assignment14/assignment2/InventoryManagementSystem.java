package inventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class InventoryManagementSystem {
	ArrayList<Product> arrayLisnewArrayList =new ArrayList<Product>();
	
	public void addNewProduct(int productid,String nameString,int quantity,double price) {
		Product product=new Product( productid, nameString, quantity, price);
		arrayLisnewArrayList.add(product);
		System.out.println("product added");
	}
	
	protected void updateQuantity(int productid,int quantity) {
		Iterator<Product> iterator=arrayLisnewArrayList.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			if (product.getProductid()==productid) {
				product.setQuantity(quantity);
				System.out.println("quantity updated");
			}
		}
	}
	protected void removeProduct(int productid) {
		Iterator<Product> iterator=arrayLisnewArrayList.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			if (product.getProductid()==productid) {
				iterator.remove();
			}
		}
	}
	protected void display() {
		Iterator<Product> iterator=arrayLisnewArrayList.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			System.out.println("product details"+product);
		}
	}
	
	public void displaybysort() {
		Collections.sort(arrayLisnewArrayList);
		System.out.println(arrayLisnewArrayList);
	}
}
