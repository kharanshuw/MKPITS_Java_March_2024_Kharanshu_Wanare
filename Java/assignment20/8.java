package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment20 {
	public void avg(ArrayList<Integer> arrayList) {
		Stream<Integer> stream=arrayList.stream();
		Double double1=stream.mapToDouble(
				(x)->{
					return x;
				}
				).average()
				.orElse(0);
		System.out.println(double1);
	}
	
	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(45);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		assignment20.avg(arrayList);
	}
}
