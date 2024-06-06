package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment20 {
	
	public void unique(ArrayList<Integer> arrayList) {
		Stream<Integer> stream=arrayList.stream();
		stream.distinct().forEach(
				(x)->{
				System.out.println(x);	
				}
				
				
				);
	}
	
	
	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		assignment20.unique(arrayList);
	}
}
