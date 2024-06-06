package assignment20;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Assignment20 {
	
	public void filter(ArrayList<Integer> arrayList) {
		TestClass testClass=new TestClass();
		Stream<Integer> stream=arrayList.stream();
		stream.filter(testClass::evenno).forEach(testClass::printing);;
	}

	public static void main(String[] args) {
		Assignment20 assignment20=new Assignment20();
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(15);
		arrayList.add(16);
		arrayList.add(28);
		assignment20.filter(arrayList);
	}
}
