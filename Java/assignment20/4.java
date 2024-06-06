package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment20 {
	public void toupperclass(ArrayList<String> arrayList) {
		Stream<String> stream=arrayList.stream();
		List<String> arrayList2=stream.map(
				 (x)->{
					return x.toUpperCase();
				}
				
				).collect(Collectors.toList());
		System.out.println(arrayList2);
	}
	
	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("d");
		
		assignment20.toupperclass(arrayList);
	}
}
