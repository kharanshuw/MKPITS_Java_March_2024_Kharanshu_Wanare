package assignment14.assignment12;

import java.util.HashSet;
import java.util.Iterator;

public class ProductIdentifierManager {
	HashSet<Product> hashSet= new HashSet<Product>();
	
	public void add(Product product) {
		hashSet.add(product);
	}
	
	public void remove(String idString) {
		Iterator<Product> iterator=hashSet.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			if (product.getProductidString().equals(idString)) {
				iterator.remove();
			}
		}
	}
	
	public void check(String idString) {
		Iterator<Product> iterator=hashSet.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			if (product.getProductidString().equals(idString)) {
				System.out.println("present");
				System.out.println(product);
			}
		}
		
	}
	
	public void display() {
		Iterator<Product> iterator=hashSet.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			
				System.out.println(product);
			
		}
	}
}
