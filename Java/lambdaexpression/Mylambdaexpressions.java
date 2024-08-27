package lambdaexpression;

import java.util.ArrayList;
import java.util.Collections;



public class Mylambdaexpressions {
public static void main(String[] args) {
	
	//lambda expression without argument
	Myinterface myinterface=()->{
		System.out.println("hello interface1");
	};
	myinterface.display();
	
	Myinterface2 myinterface2=()->{
		System.out.println("hello interface2");
	};
	
	myinterface2.display();
	//method reference of runnable interface
	Runnable runnable=()->{
		System.out.println("hello runnable");
	};
	
	runnable.run();
	}

	Myinterface3 myinterface3=(int a)->{
		return a;
	};
	
	
	
	/*ArrayList<Student> arrayList=new ArrayList<Student>();
	arrayList.add(new Student("c",1));
	arrayList.add(new Student("a",2));
	arrayList.add(new Student("b",0));
	
	//comparator interface as lambda expression
	Collections.sort(arrayList, (s1,s2)->{
		return s1.getName().compareTo(s2.getName());
	});
	
	Collections.sort(arrayList,(s1,s2)->{
		return Integer.compare(s1.getId(), s2.getId());
	});
	
	System.out.println(arrayList);*/
}
