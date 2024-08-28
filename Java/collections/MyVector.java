package myproject;

import java.util.Vector;

public class MyVector {
  public static void main(String[] args) {
    Vector<Integer> v1=new Vector<Integer>();
    v1.add(1);
    v1.add(2);
    v1.add(3);
    v1.add(4);
    v1.add(1,99);
  
    v1.addElement(9856);
    System.out.println(v1.capacity());
    System.err.println(v1.contains(1));
    
    Integer[] arr1=new Integer[10];
    v1.copyInto(arr1);
    for (Integer x : arr1) {
		System.out.println(x);
	}
    
  }
}
