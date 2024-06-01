package practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Assignment{
	
	 public static void main(String[] args) {
		 ArrayList<Integer> arrayList=new ArrayList<Integer>();
		 arrayList.add(1);
		 arrayList.add(5);
		 arrayList.add(45);
		 arrayList.add(9);
		 arrayList.add(4);
		 arrayList.add(4);
		 arrayList.add(31);
		 arrayList.add(4);
		 arrayList.add(6);
		 arrayList.add(4);
		 arrayList.add(6);
		 arrayList.add(31);
		 arrayList.add(99);
		 for (int i = 0; i < 1000; i++) {
	            // Add some duplicates here (adjust as needed)
	            if (i % 5 == 0) {
	                arrayList.add(5); // Add 5 every 5th iteration
	            } else if (i % 10 == 0) {
	                arrayList.add(10); // Add 10 every 10th iteration
	            } else {
	                arrayList.add(i); // Add unique numbers (0 to 999)
	            }
	        }
		 long starttime=System.nanoTime();
		 HashSet<Integer> hashSet=new HashSet<Integer>(arrayList);
		 for (Integer integer : hashSet) {
			System.out.println(integer);
		}
		 long endtime=System.nanoTime();
		 long executionTime
         = (endtime - starttime) / 1000000;
		 System.out.println("hashset time"+executionTime+"ms");
		 
		 starttime=System.nanoTime();
		
		 LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<Integer>(arrayList);
		 for (Integer integer : linkedHashSet) {
			System.out.println(integer);
		}
		  endtime=System.nanoTime();
		  executionTime= (endtime - starttime) / 1000000;
		  
		 System.out.println("linkedhashset time"+executionTime+"ms");
		 
		 
		 starttime=System.nanoTime();
			
		 
		 TreeSet<Integer> treeSet =new TreeSet<Integer>(arrayList);
		 for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		  endtime=System.nanoTime();
		  executionTime= (endtime - starttime) / 1000000;
		 System.out.println("treeset time"+executionTime+"ms");
		 
		 
	    }
	 
}