package practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Assignment{
	
	public void caseInsensitiveWordStorage() {
		TreeSet<String> treeSet=new TreeSet<String>(new Stringcomparator());
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter q to exit");
		while (true) {
			String string=scanner.next();
			if (string.equals("q")) {
				break;
			}
			treeSet.add(string);
		}
		
		for (String string : treeSet) {
			System.out.println(string);
		}
	}
	
	public static void main(String[] args) {
		Assignment assignment=new Assignment();
		assignment.caseInsensitiveWordStorage();
	}
}