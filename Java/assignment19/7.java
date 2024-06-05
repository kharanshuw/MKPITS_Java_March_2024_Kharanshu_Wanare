package streameapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment19 {

	public void filter(List<Integer> list) {
		Stream<Integer> stream=list.stream();
		TestClass testClass=new TestClass();
		stream.filter(testClass::greaterthanten).forEach((x)->System.out.println(x));
	}

	public static void main(String[] args) {
		Assignment19 assignment19 = new Assignment19();
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(89);
		list.add(41);
		list.add(5);
		list.add(8);
		
		assignment19.filter(list);
	}
}
