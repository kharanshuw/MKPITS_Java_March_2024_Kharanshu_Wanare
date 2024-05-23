import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Myarraylist {
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
		
		
		arrayList.add("red");
		arrayList.add("blue");
		arrayList.add("green");
		
		arrayList.add(0, "yello");
		
		arrayList.set(0, "white");
		
		arrayList.contains(new String("red"));
		arrayList.indexOf(new String("red"));
		
	}
}
