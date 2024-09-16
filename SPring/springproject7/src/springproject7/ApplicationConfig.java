package springproject7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Address address()
	{
		Address address =new Address("maharashtra");
		
		return address;
	}
	
	@Bean
	public Student student() {
		Student student =new Student();
		
		//student.setAddress(address());
		
		student.setCityString("nagpur");
		
		student.setNameString("pratik");
		
		
		return student;
	}
}
