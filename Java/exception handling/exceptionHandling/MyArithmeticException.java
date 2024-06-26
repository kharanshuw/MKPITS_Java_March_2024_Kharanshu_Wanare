package exceptionHandling;

public class MyArithmeticException {
	public void checkException(int one,int two) {
		try {
			int result=one/two;
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occured");
			System.out.println(e);
		}
		
	}
}
