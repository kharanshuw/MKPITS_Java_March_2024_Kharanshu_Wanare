package streameapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Assignment19 {

	public void filter(List<Integer> list) {
		Stream<Integer> stream=list.stream();
		System.out.println(list.stream().reduce(1,(n,m)->n*m));
	}

	public static void main(String[] args) {
		Assignment19 assignment19 = new Assignment19();
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assignment19.filter(list);
	}
}
