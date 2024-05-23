import java.util.ArrayList;
import java.util.Iterator;

public class Myarraylist {
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("red");
		arrayList.add("blue");
		arrayList.add("green");
		
		System.out.println(arrayList);
		
		Iterator<String> iterator=arrayList.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}