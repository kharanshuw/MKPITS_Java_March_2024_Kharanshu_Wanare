package functionalinterface;

import java.util.function.Consumer;

import lambdaexpression.Student;

public class MyConsumer {
public static void main(String[] args) {
	//consumer with lambda expression
	Consumer<String> consumer=(String x) -> {
		System.out.println(x);
		System.out.println("hello consumer1");
	};
	consumer.accept("abc");
	//consumer with method reference
	Consumer<String> consumer2=System.out::println;
	consumer2.accept("hellow consumer2");
	
	Student student=new Student();
	//consumer with student class disp method reference
	Consumer<String> consumer3=student::disp;
	consumer3.accept("abc");
	
	
}
}
