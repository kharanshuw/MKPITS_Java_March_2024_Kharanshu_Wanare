package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment20 {
	public void containscheck(ArrayList<String> arrayList) {
		Stream<String> stream=arrayList.stream();
		boolean containsa=stream.anyMatch(
				(x)->{
					return x.contains("a".toLowerCase());
				}
				);
		
		System.out.println(containsa);			
		
	}
	
	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("ab");
		arrayList.add("bc");
		arrayList.add("cdf");
		arrayList.add("zfg");
		arrayList.add("zca");
		assignment20.containscheck(arrayList);
	}
}
