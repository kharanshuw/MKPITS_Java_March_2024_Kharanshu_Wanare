package assignment14.Assignmet6;

import java.util.Comparator;

public class DatesComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		return o1.getDuedateString().compareTo(o2.getDuedateString());
	}

}
