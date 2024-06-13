package practise;


import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("apple", "banana", "grape", "longword");
		
				
	 List<String> list	=myList.stream().sorted(
				(a,b)->{
					return a.length()-b.length();
					}
				).collect(Collectors.toList());
	}
	
	}
	
	
	