package assignment20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
       List<List<Integer>> list=new ArrayList<List<Integer>>();
       list.add(Arrays.asList(10,20,30,40,50));
       list.add(Arrays.asList(50,60,70,80));
       list.add(Arrays.asList(40,80,90));
       list.add(Arrays.asList(66));
       
       list.stream().flatMap(List::stream).forEach(x->System.out.println(x));
       
	}
}
