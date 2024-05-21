package assignment14.assignment6;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class OrderManagementSystem {

	LinkedList<Order> linkedList=  new LinkedList<Order>();
	
	public void addorder(Order order) {
		linkedList.add(order);
	}
	
	public void updatequantity(String orderidString,long no) {
		Iterator<Order> iterator =linkedList.iterator();
		while (iterator.hasNext()) {
			Order order = (Order) iterator.next();
			if (order.getOrderidString().equals(orderidString)) {
				order.setQuantity(no);
			}
		}
	}
	
	public void removeOrder(String orderidString) {
		Iterator<Order> iterator =linkedList.iterator();
		while (iterator.hasNext()) {
			Order order = (Order) iterator.next();
			if (order.getOrderidString().equals(orderidString)) {
				iterator.remove();
			}
		}
	}
	
	public void sort() {
		Collections.sort(linkedList,new DateComparator());
	}
	
	public void display() {
		Iterator<Order> iterator =linkedList.iterator();
		while (iterator.hasNext()) {
			Order order = (Order) iterator.next();
			
			System.out.println(order);
			
		}
	}
}
