package assignment14.Assignmet6;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskManagementSystem {
	LinkedList<Task> linkedList;

	public TaskManagementSystem() {
		linkedList = new LinkedList<Task>();
	}

	public void addtask(Task task) {
		linkedList.add(task);
	}

	public void removeById(String id) {
		Iterator<Task> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Task task = (Task) iterator.next();
			if (task.getTaskidString().equals(id)) {
				iterator.remove();
				System.out.println("id detail deleted");
			}
		}
	}

	public void searchById(String id) {
		Iterator<Task> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Task task = (Task) iterator.next();
			if (task.getTaskidString().equals(id)) {

				System.out.println("id detail"+task);
			}
		}
	}

	public void sort() {
		Collections.sort(linkedList, new DatesComparator());
	}

	public void display() {
		Iterator<Task> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Task task = (Task) iterator.next();

			System.out.println("id detail deleted");

		}
	}

}
