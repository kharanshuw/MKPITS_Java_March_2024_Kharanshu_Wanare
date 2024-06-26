package myownexception;

public class InvalidAgeException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "invalid age";
	}
}
