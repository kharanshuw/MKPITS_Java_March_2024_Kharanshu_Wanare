package assignment20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Assignment20 {
	
	public void maximum(ArrayList<Integer> arrayList) {
		Stream<Integer> stream=arrayList.stream();
		Comparator<Integer> comparator=new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		Optional<Integer> optional=stream.max(comparator);
		System.out.println(optional);
	}

	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(15);
		arrayList.add(16);
		arrayList.add(28);
		assignment20.maximum(arrayList);
	}
}
