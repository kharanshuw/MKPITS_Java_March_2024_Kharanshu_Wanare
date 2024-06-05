package streameapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment19 {
	
	public void filterstring(List<String> list) {
		Stream<String> stream=list.stream();
		List<String> list2=stream.filter(
				(x)->{
					boolean result=false;
					if (x.startsWith("A")) {
						result=true;
					}
					return result;
				}
				
				).collect(Collectors.toList());
		System.out.println(list2);
	}
	
	public static void main(String[] args) {
		Assignment19 assignment19=new Assignment19();
		List<String> list=new ArrayList<String>();
		list.add("ABC");
		list.add("bca");
		list.add("dcf");
		list.add("ABM");
		assignment19.filterstring(list);
	}
}
