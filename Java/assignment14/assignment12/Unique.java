package assignment14;

import java.util.HashSet;
import java.util.Iterator;

public class UniqueEmailCollector {
	HashSet<Product> hs=new HashSet<Product>();
	public void add(Product p) {
		hs.add(p);
	}
	
	public void search(String idString) {
		Iterator<Product> iterator=hs.iterator();
		while (iterator.hasNext()) {
			Product p = (Product)(iterator.next());
			if (p.idString==idString) {
				System.out.println(p);
			}
		}
	}
	
	public void remove(String idString) {
		Iterator<Product> iterator=hs.iterator();
		while (iterator.hasNext()) {
			Product p = (Product)(iterator.next());
			if (p.idString==idString) {
				iterator.remove();
			}
		}
	}
	
	public void display() {
		Iterator<Product> iterator=hs.iterator();
		while (iterator.hasNext()) {
			Product p = (Product)(iterator.next());
			
			System.out.println(p);
			
		}
	}
	
	
}
