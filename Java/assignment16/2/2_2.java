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
		  
		  for (int i = 0; i <vector.size(); i++) {
			  int smallest=i;
			 for (int j = i+1; j < vector.size(); j++) {
				if (vector.get(smallest)>vector.get(j)) {
					smallest=j;
				}
			}
			 int temp=vector.get(i);
			 vector.set(i,vector.get(smallest));
			 vector.set(smallest, temp);
			 
		}
		  
		  System.out.println(vector);
	}

}
