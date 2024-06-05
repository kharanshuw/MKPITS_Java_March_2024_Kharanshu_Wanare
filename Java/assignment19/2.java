package streameapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment19 {
	
	public void doubleinteger(List<Integer> list) {
		
		TestClass testClass =new TestClass();
		Stream<Integer> stream=list.stream();
		
		stream.map(
				testClass::doubleinteger
				
				).forEach(
						
						(x)->{
							System.out.println(x);
						}
						
						);;
	}
	
	public static void main(String[] args) {
		Assignment19 assignment19=new Assignment19();
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(45);
		list.add(79);
		
		assignment19.doubleinteger(list);
	}
}
