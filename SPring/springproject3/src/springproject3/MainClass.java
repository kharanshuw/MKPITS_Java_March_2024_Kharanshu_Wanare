package springproject3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
public static void main(String[] args) {
	
	ApplicationContext applicationContext =new AnnotationConfigApplicationContext(Appconfig.class);
	
	Student studetStudent = applicationContext.getBean(Student.class);
	
	System.out.println(studetStudent);
}
}
