package assignment20;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class Assignment20 {	
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(55);
		arrayList.add(10);
		arrayList.add(4);
		arrayList.add(79);
	List<Integer> list=arrayList.stream().filter(
			x->{
				if (x>5) {
					return true;
				}
				else {
					return false;
				}
			}
			).collect(Collectors.toList());
	System.out.println(list);
	}
}
