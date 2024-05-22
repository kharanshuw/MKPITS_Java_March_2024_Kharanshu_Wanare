package assignment14.assignment9;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class EventScheduling {
	LinkedList linkedList=new LinkedList<Event>();
	public void add(Event event) {
		linkedList.add(event);
	}
	public void removeById(String id) {
		Iterator<Event> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Event e = (Event) iterator.next();
			if (e.getEvnetidString().equals(id)) {
				iterator.remove();
				System.out.println("id detail deleted");
			}
		}
	}
	
	public void details(String eventName) {
		Iterator<Event> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Event e = (Event) iterator.next();
			if (e.getEventName().equals(eventName)) {
				
				System.out.println("id detail "+e);
			}
		}
	}
	
	public void display() {
		Iterator<Event> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Event e = (Event) iterator.next();
			
				System.out.println("id detail "+e);
		
		}
	}
	
	public void sort() {
		LocationComparator locationComparator= new LocationComparator();
		Collections.sort(linkedList,locationComparator);
	}
}
