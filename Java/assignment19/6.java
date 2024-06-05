package streameapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment19 {

	public void maxandmin(List<Student> list) {
		//Java also provides utility methods like Comparator.comparing for simpler comparisons based on specific object properties.
		Comparator<Student> comparator=Comparator.comparing(Student::getAge);
		
		Stream<Student> straStream=list.stream();
		Stream<Student> straStream1=list.stream();
		Optional<Student> optional=straStream.max(comparator);
		if (optional.isPresent()) {
			System.out.println("max age");
			System.out.println(optional);
		}
		else {
			System.out.println("no age found");
		}
		
		Optional<Student> optional2=straStream1.min(comparator);
		
		if (optional2.isPresent()) {
			System.out.println("min");
			System.out.println(optional2);
		}
		else {
			System.out.println("not found min");
		}
	}

	public static void main(String[] args) {
		Assignment19 assignment19 = new Assignment19();
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("abc",5));
		list.add(new Student("d",10));
		list.add(new Student("e", 15));
		
		assignment19.maxandmin(list);
		
	}
}
