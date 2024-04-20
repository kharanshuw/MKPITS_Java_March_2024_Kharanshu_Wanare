package practise;

import java.util.Iterator;

public class Assignment4 {

	public static void main(String[] args) {
		
		int intersection[];
		int arr1[]= {10,20,30,45,60};
		int arr2[]= {10,37,13,45,35};
		int totalLength=arr1.length+arr2.length;
		int union1[]=new int[totalLength];
		intersection=new int[totalLength];
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i]==arr2[i]) {
				union1[i]=arr1[i];
			}
			else {
				intersection[i]=arr1[i];
			}
		}
		
}
}