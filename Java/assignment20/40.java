package practise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(10,20,30,40,50,-50,-5,-9,-4);
		
		list.stream().filter(
				x->{
					if (x>=0) {
						return true;
					}
					else {
						return false;
					}
				}
				).forEach(
						(x)->{
						System.out.println(x);	
						}
						);
	}
}
	
	