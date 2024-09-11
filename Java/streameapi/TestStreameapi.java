package streameapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreameapi {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(15);
		list.add(25);
		list.add(33);
		list.add(41);
		list.add(59);
		list.add(63);

		Stream<Integer> stream = list.stream();

		/*
		 * stream. forEach((x)->{ System.out.println(x); });
		 * 
		 * }
		 */

		/*
		 * List<Integer> list2=stream. map((x)->{ return x*x;
		 * }).collect(Collectors.toList());
		 */

		/*
		 * stream .map((x)-> {return Integer.reverse(x);} ) .forEach( (x)->{
		 * System.out.println(x); } ); }
		 */

		/*
		 * stream.filter((x) -> { if (x % 2 == 0) { return true; } else { return false;
		 * } }).forEach((x) -> { System.out.println(x); });
		 * 
		 */
		/*
		 * TestClass testClass=new TestClass(); stream .forEach( testClass::name );
		 */
		
		/*
		 * 
		 * use of map in 
		TestClass testClass=new TestClass();
		stream.map(
				testClass::devide
				)
		.forEach((x)->{
			System.out.println(x);
		});
		*/
		
	}
}
