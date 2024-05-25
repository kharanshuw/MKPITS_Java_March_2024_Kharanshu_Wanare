package exceptionHandling;

import myownexception.InvalidAgeException;

public class AgeExceptionTest  {
	public void agecheck(int age) throws InvalidAgeException {
		
		if (age>100 || age <0) {
			InvalidAgeException invalidAgeException=new InvalidAgeException();
			
			throw invalidAgeException;
		}
		else {

			System.out.println(age);
		}
		
		
		
	}
}
