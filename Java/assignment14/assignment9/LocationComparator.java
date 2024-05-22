package assignment14.assignment9;

import java.util.Comparator;

public class LocationComparator implements Comparator<Event> {

	@Override
	public int compare(Event o1, Event o2) {
		return o1.getLocation().compareTo(o2.getLocation());
	}

}
