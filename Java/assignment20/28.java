package practise;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(12);
		list.add(133);
		list.add(45);
		list.add(122);
		list.add(133);
		list.add(4);
		list.add(126);
		list.add(13);
		list.add(485);
		
	 String string  =  list.stream()
		   .map(x->x.toString())
		  .collect(Collectors.joining(", "));	
	 System.out.println(string);
	}
	
	}
	
	
	