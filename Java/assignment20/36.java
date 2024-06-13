package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(-5);
		arrayList.add(5);
		arrayList.add(12);
		arrayList.add(-6);
		
	List<String> list =arrayList.stream().map(x->x.toString()).collect(Collectors.toList());
	System.out.println(list);
	}
}
	
	