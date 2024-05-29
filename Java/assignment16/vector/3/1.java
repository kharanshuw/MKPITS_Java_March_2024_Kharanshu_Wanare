package practise;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Myvector {
	public void binarysearch(Vector<Integer> vector,int no) {
		int left=0;
		int right=vector.size()-1;
		while (left<=right) {
			int mid=(right+left)/2;
			if (vector.get(mid)==no) {
				System.out.println("position "+mid);
				System.exit(0);
			}
			else if (no>vector.get(mid)) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		System.out.println("loop ended");
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
	 myvector.binarysearch(vector, 45);
}

}
