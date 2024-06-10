package practise;
//**Find the frequency of each string in a list.**

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
		
	Map<Integer, Long> map  =list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
	System.out.println(map);
	}
	
	}
	
	
	