package practise;

import java.util.Iterator;
import java.util.Vector;

public class Myvector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> vector=new Vector<Integer>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		vector.add(4);
		vector.add(5);
		
		Integer integer=0;
		System.out.println(vector.remove(integer));
		System.out.println(vector);
		
		int size=vector.size();
		
		System.out.println(size);
		
		Iterator<Integer> iterator=vector.iterator();
		while (iterator.hasNext()) {
			Integer integer2 = (Integer) iterator.next();
			System.out.println(integer2);
		}
	}

}
