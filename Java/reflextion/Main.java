package reflextion;

import java.lang.reflect.Field;

public class Main {
public static void main(String[] args) {
	Student student=new Student();
	try {
		Class class1=Class.forName("reflextion.Student");
		System.out.println(class1.getName());
		Field field[] = class1.getDeclaredFields();
		for (Field field2 : field) {
			System.out.println(field2);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
