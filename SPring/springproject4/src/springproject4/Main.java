package springproject4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");

		Student student = (Student) applicationContext.getBean("s1");
		System.out.println(student);
	}

}
