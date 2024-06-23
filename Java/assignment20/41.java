package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<List<Integer>> arrayList=new ArrayList<List<Integer>>();
		arrayList.add( Arrays.asList(10,20,30,40));
		arrayList.add( Arrays.asList(10,20,40));
		arrayList.add( Arrays.asList(10,20));
		arrayList.add(Arrays.asList(10,20,30,40,90));
		arrayList.add(Arrays.asList(10,20,30,40,50));
		
		List<Integer> list=arrayList.stream().flatMap(
				x->{
					return x.stream();
				}
				).collect(Collectors.toList());
		System.out.println(list);
	}
}
	
	