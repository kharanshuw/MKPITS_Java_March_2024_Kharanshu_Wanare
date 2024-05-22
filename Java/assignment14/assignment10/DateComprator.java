package assignment14.assignment10;
import java.util.Comparator;
public class DateComprator implements Comparator<WebPage>{

	@Override
	public int compare(WebPage o1, WebPage o2) {
		return o1.getVisitDate().compareTo(o2.getVisitDate());
	}

}
