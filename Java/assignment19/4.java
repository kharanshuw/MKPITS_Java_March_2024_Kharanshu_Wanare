package streameapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment19 {

	public void sortlist(List<Integer> list) {
		
		
		Stream<Integer> stream = list.stream();
		
		HashMap<Integer, String> hashMap=new HashMap<Integer, String>();
		TestClass testClass = new TestClass();
		Integer sumInteger = stream.filter(
				//used testclass oddno method reference
				testClass::oddno

		)
				//maptoint method returns no in int form 
				.mapToInt(testClass::doubleinteger).sum();

		System.out.println(sumInteger);
	}

	public static void main(String[] args) {
		Assignment19 assignment19 = new Assignment19();
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(45);
		list.add(79);
		list.add(58);
		list.add(44);
		list.add(57);
		list.add(81);
		list.add(85);

		assignment19.sortlist(list);
	}
}
