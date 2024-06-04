package functionalinterface;

import java.util.function.Supplier;

public class MySupplier {
public static void main(String[] args) {
	Supplier<Integer> supplier=new Supplier<Integer>() {
		
		@Override
		public Integer get() {
			return (int) Math.random();
		}
	};
	
	Supplier<Double> supplier2=()->{
		Double x= Math.random();
		return x;
	};
	
	Supplier<Double> supplier3=Math::random;
	double result=supplier.get();
	System.out.println(result);
}
}
