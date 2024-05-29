package practise;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Myvector {
	public void sum(Vector<Integer> vector,Vector<Integer> vector2) {
		Vector<Integer> vector3=new Vector<Integer>();
		if (vector.size()!=vector.size()) {
			System.out.println("both vector have different size");
		}			
			for (int i = 0; i < vector.size(); i++) {
				vector3.add(vector.get(i)+vector2.get(i));
			}
		
		System.out.println(vector3);
	}

public static void main(String[] args) {
	 Vector<Integer> vector=new Vector<Integer>();
	 
	 vector.add(5);
	 vector.add(9);
	 vector.add(45);
	 vector.add(1);
	 vector.add(2);
	 
 Vector<Integer> vector1=new Vector<Integer>();
	 
	 vector1.add(6);
	 vector1.add(7);
	 vector1.add(8);
	 vector1.add(9);
	 vector1.add(10);
	 
	 Myvector myvector=new Myvector();
	 
	 myvector.sum(vector, vector1);
	 
}

}
