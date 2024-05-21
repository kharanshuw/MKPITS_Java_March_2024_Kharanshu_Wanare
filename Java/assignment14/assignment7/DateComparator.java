package assignment14.assignment6;

import java.util.Comparator;

public class DateComparator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
	return	o1.getOrderdateString().compareTo(o2.getOrderdateString());
	}

}
