package practise;

import java.util.Scanner;
import java.util.TreeSet;

public class Assignment{
	
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
	     
		 TreeSet<Integer> treeSet=new TreeSet<Integer>();
		 System.out.println("enter integer type -1 to exit");
		 while (true) {
			Integer integer=scanner.nextInt();
			if (integer.equals(-1)) {
				break;
			}
			treeSet.add(integer);
		 }
		 
		 System.out.println("your output");
		 for (Integer integer : treeSet) {
			System.out.println(integer);
		}
		 
	    }
	 
}