package practise;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//**Convert a list of integers to a list of their squares.**
public class Assignment {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(45);
		list.add(12);
		list.add(13);
		list.add(4);
		list.add(126);
		list.add(13);
		list.add(485);
		
		List<Integer> list2	=list.stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(list2);
	}
	
	}
	
	
	