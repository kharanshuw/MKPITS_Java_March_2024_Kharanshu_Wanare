package assignment20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(35);
		arrayList.add(40);
		arrayList.add(55);
		arrayList.add(55);
		arrayList.add(65);
		
		Map<String, List<Integer>> lisMap=arrayList.stream().collect(Collectors.groupingBy(
				x->{
					
					return x%2==0?"even":"odd";
				}
				)
				);
		
		System.out.println(lisMap);
	}
}
