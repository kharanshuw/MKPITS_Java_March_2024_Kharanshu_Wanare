package practise;

import java.util.Vector;

public class Myvector {
	public void product(Vector<Integer> vector,Vector<Integer> vector2) {
		double product=0;
		if (vector.size()!=vector.size()) {
			System.out.println("both vector have different size");
		}			
			for (int i = 0; i < vector.size(); i++) {
				product=product+(vector.get(i)*vector2.get(i));
			}
		
	System.out.println(product);
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
	 
	 myvector.product(vector, vector1);
	 
}

}
