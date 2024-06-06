package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment20 {
	public void sortlist(ArrayList<String> arrayList) {
		Stream<String> stream=arrayList.stream();
		stream.sorted().forEach(
				(x)->{
				System.out.println(x);	
				}
				
				);
	}
	
	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("d");
		arrayList.add("b");
		arrayList.add("a");
		arrayList.add("g");
		arrayList.add("w");
		
		assignment20.sortlist(arrayList);
	}
}
