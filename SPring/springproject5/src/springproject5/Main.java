package springproject5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

	Student student=(Student) applicationContext.getBean("s1");
	
	System.out.println(student);
	
	student.printmap();
	}

}
