package practise;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Myvector {
	public void linearsearch(Vector<Integer> vector,int no    ) {
		for (int i = 0; i < vector.size(); i++) {
			if (no==vector.get(i)) {
				System.out.println(i+"position");
			}
		}
	}

public static void main(String[] args) {
	 Vector<Integer> vector=new Vector<Integer>();
	 
	 vector.add(5);
	 vector.add(9);
	 vector.add(45);
	 vector.add(1);
	 vector.add(2);
	 
	 Myvector myvector=new Myvector();
	 Collections.sort(vector);
	 myvector.linearsearch(vector, 9);
}

}
