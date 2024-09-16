package springproject7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student = (Student) applicationContext.getBean("student");
		
		System.out.println(student);
	}

}
