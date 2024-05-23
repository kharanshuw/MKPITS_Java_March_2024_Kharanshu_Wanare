import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Myarraylist {
	public static void main(String[] args) {
		List<String> arrayList=new ArrayList<String>();
		
		
		arrayList.add("red");
		arrayList.add("blue");
		arrayList.add("green");
		
		arrayList.add(0, "yello");
		
		System.out.println(arrayList.get(2));
		
	}
}
