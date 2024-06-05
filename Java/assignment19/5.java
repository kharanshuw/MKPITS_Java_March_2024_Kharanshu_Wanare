package streameapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment19 {

	public void sortlist(List<Integer> list) {
		TestClass testClass=new TestClass();
		Stream<Integer> stream=list.stream();
		//group by method of collectors class 
		//group by method takes 2 parameter 1st is input on which you want to do operation 2nd is the operation you want to do on the 1st para
		//function .identity method returns the value which is given to it by para 
		Map<Integer, Long> map=stream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(map);
	}

	public static void main(String[] args) {
		Assignment19 assignment19 = new Assignment19();
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(45);
		list.add(79);
		list.add(58);
		list.add(58);
		list.add(57);
		list.add(81);
		list.add(81);

		assignment19.sortlist(list);
	}
}
