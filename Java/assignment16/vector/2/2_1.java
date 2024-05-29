package practise;
import java.util.Iterator;
import java.util.Vector;

public class Myvector {

	public static void main(String[] args) {
		  Vector<Integer> vector=new Vector<Integer>();
		  vector.add(7);
		  vector.add(8);
		  vector.add(3);
		  vector.add(1);
		  vector.add(2);
		  
		  System.out.println(vector);
		  //bubble sort in vector
		  for (int i = 0; i < vector.size()-1; i++) {
			for (int j = 0; j < vector.size()-i-1; j++) {
				if (vector.get(j)>vector.get(j+1)) {
					int temp=vector.get(j);
					vector.set(j, vector.get(j+1));
					vector.set(j+1,temp);
				}
			}
		}
		  System.out.println(vector);
	}

}
